package springbootsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// 스프링 보안 설정
@Configuration
// 스프링 시큐리티 활성화
@EnableWebSecurity
public class SecurityConfig {

	// SecurityFilterChain: 스프링 시큐리티 필터 체인을 커스텀마이징
	// HttpSecurity: URL별 접근 권한, 로그인/로그아웃, CSRF 설정 ...
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
		.authorizeHttpRequests(auth -> auth // URL 경로별 접근 권한을 설정
			// /, /join, /css/** 경로 접근 모두 허용
			.requestMatchers("/", "/join", "/css/**").permitAll()
			// 그 외 모든 요청은 인증된 사용자만 접근 허용
			.anyRequest().authenticated()
		)
		.formLogin(form -> form // 사용자 정의 로그인 폼 설정
			.loginPage("/login") // 로그인 화면 URL
			.loginProcessingUrl("/login") // 로그인 처리 URL
			.defaultSuccessUrl("/", true) // 로그인 성공 시 /로 무조건(true) 이동
			.permitAll() // 로그인 화면 URL은 모든 접근 허용 
		)
		.logout(logout -> logout // 로그아웃 설정
			.logoutUrl("/logout") // 로그아웃 URL
			.logoutSuccessUrl("/login?logout") // 로그아웃 성공 시 이동
			.permitAll() // 로그아웃 URL은 모든 접근 허용 
		)
		.csrf(csrf -> csrf.disable()); // CSRF 비활성화 (개발 시 비활성화, 운영 시 활성화)
		
	// SecurityFilterChain 반환
	return http.build();
	} //FilterChain
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		// 비밀번호 bcrypt 암호화 개체 리턴
		// bcrypt 암호화: 단방향 암호화 (원본 > 암호화(o), 암호화 > 원본(x))
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	// 인증 관리자
	public AuthenticationManager authenticationManager(
		AuthenticationConfiguration configuration
	) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
}







































