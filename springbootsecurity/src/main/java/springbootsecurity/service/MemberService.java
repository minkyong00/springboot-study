package springbootsecurity.service;

import springbootsecurity.entity.Member;

public interface MemberService {

	public default void registMember(Member member) {};
	
	public default Member getMember(String username) { return null; }
	
}
