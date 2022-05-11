package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;

public class MemberServiceTest {
// Junit 테스트하기 위한 클래스
	
	MemberService memberService;
	
	@BeforeEach // test 실행전 무조건 실행되는 어노테이션
	public void beforeEach() {
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
	}
	@Test
	void join() {
		//given
		Member member = new Member(1L, "memberA", Grade.VIP);
		
		//when
		memberService.join(member);
		Member findMember = memberService.findMember(1L);
		
		//then Assertions : 검증시 사용하는 API
		Assertions.assertThat(member).isEqualTo(findMember);
		// member랑 findMember랑 똑같냐는 의미
	}
}
