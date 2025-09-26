package springbootsecurity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springbootsecurity.entity.Member;
import springbootsecurity.repository.MemberRepository;
import springbootsecurity.service.MemberService;

@Service("memberService")
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void registMember(Member member) {
		
		// 회원아이디가 존재한다면
		if(memberRepository.existsByUsername(member.getUsername())) {
			throw new IllegalArgumentException("이미 존재하는 사용자입니다!");
		}
		
		// 비밀번호 암호화
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		
		// 롤이 없다면 ROLE_USER로 설정
		if(member.getRole()==null) {
			member.setRole("ROLE_USER");
		}
		
		memberRepository.save(member);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Member getMember(String username) {
		return memberRepository.findByUsername(username).orElse(null);
	}
	
}


























