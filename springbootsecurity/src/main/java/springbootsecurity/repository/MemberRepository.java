package springbootsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springbootsecurity.entity.Member;

@Repository("memberRepository")
public interface MemberRepository extends JpaRepository<Member, Long> {
	
	Optional<Member> findByUsername(String username);
	
	boolean existsByUsername(String username);
	
	
}
