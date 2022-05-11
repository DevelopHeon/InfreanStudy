package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

	// 주문 생성 요청이 오면 회원 정보 조회 하고
	private final MemberRepository memberRepository;
	// 할인정책에 회원정보를 넘겨준다. 
//	private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
	// 클라이언트 코드를 변경해야함, 문제 발생
	private final DiscountPolicy discountPolicy; // 인터페이스만 생성하면 NPE 발생
	
	// 어떤 할인 정책이 들어올지 알수 없음 DIP를 지켜서 인터페이스에만 의존하기때문에
	@Autowired
	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}


	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		// 회원의 아이디를 찾는다.
		Member member = memberRepository.findById(memberId);
		// 할인에 대한건 discountpolicy가 알아서 해줘라, orderservice에서는 할인 금액을 모른다.
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
