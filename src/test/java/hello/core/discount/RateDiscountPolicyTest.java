package hello.core.discount;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;

class RateDiscountPolicyTest {

	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
	
	@Test
	@DisplayName("VIP는 10% 할인이 적용되어야 한다") // Junit5 부터 한글도 지원
	void vip_o() {
		//given
		Member member = new Member(1L, "memberVIP", Grade.VIP);
		//when
		int discount = discountPolicy.discount(member, 10000);
		//then
		assertThat(discount).isEqualTo(1000);
	}
	
	@Test
	@DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
	void vip_x() { // Test시에는 실패 테스트도 작성 해보아야 함
		//given
		Member member = new Member(2L, "memberBASIC", Grade.BASIC);
		//when
		int discount = discountPolicy.discount(member, 10000);
		//then
		assertThat(discount).isEqualTo(0); // import static을 해주게 되면 간결하게 작성이 가능
	}
}
