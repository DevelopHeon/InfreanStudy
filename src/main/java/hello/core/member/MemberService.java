package hello.core.member;

public interface MemberService {
	
	void join(Member member); // 회원 가입 메소드
	
	Member findMember(Long memberId); //회원 조회
	
}
