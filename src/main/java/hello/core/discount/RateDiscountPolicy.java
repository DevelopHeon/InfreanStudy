package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("mainDiscountPolicy") // 문자열이기때문에 컴파일러에서 인식이 안됨
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {
// 새로운 할인 정책으로 변경
	
	private int discountPercent = 10; // 할인율 10%
	
	@Override
	public int discount(Member member, int price) {
		if(member.getGrade() == Grade.VIP) {
			return price * discountPercent / 100;
		}else {
			return 0;
		}
	}
}
