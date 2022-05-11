package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {
// MemberService의 구현체
	
	private final MemberRepository memberRepository; // 추상화에만 의존 DIP를 지킴
	@Autowired //(ac.getBean(MemberRepository.class) 과 비슷하다.
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	@Override
	public void join(Member member) { // 다형성에 의해서 구현체의 save 호출
		memberRepository.save(member);

	}

	@Override
	public Member findMember(Long memberId) {
		return memberRepository.findById(memberId);
	}
	
	// test 용
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}

}
