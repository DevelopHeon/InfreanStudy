package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy; // 인터페이스만 생성하면 NPE 발생

	@Autowired
	public OrderServiceImpl(MemberRepository memberRepository,@MainDiscountPolicy DiscountPolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		// 할인에 대한건 discountpolicy가 알아서 해줘라, ordersaervice에서는 할인 금액을 모른다.
		// 할인에 대한 변경시에는 할인쪽만 수정해주면 된다. 주문쪽까지 고칠 필요는 X
		// 단일책임화 원칙을 잘 지킨 케이스
		int discountPrice = discountPolicy.discount(member, itemPrice);
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}
	
	// 테스트용
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}

}
