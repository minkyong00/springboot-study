package springbootsecurity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import springbootsecurity.entity.Member;
import springbootsecurity.repository.MemberRepository;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepository;
	
	// 인증 사용자 정보, 인증 관련된 정보
	// 사용자명(아이디)에 해당하는 사용자정보와 권한정보들을 가진 UserDetails를 반환하는 메소드
	@Override
	public UserDetails loadUserByUsername(String username) 
		throws UsernameNotFoundException {
		
		// 데이터베이스에 해당 사용자가 있으면 획득, 없으면 예외 처리
		Member member = memberRepository.findByUsername(username)
			.orElseThrow(() -> new UsernameNotFoundException("해당 사용자가 없습니다!"));
		
		// 권한(인가) 리스트를 획득 (롤에 해당하는 권한 목록)
		List<GrantedAuthority> authorityList
			= List.of(new SimpleGrantedAuthority(member.getRole()));
		
		// 사용자명, 비밀번호, 권한 리스트를 가진 인증 사용자 정보(User) 리턴
		// User는 UserDetails(인증사용자 정보 + 인증사용자 권한 정보) 구현체
		return new User(
			member.getUsername(),
			member.getPassword(),
			authorityList
		);
	}

}





































