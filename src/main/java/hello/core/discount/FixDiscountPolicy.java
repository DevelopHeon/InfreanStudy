package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy {

	private int discountFixAmount = 1000; // 1000원 할인
	@Override
	public int discount(Member member, int price) {
		// Enum의 경우 == 을 이용하여 비교
		// VIP의 경우 1000원 할인, 아닐경우 할인 금액 없음
		if(member.getGrade() == Grade.VIP) {
			return discountFixAmount;
		}else {
			return 0;
		}
	}
}
