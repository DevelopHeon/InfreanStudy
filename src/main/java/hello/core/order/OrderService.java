package hello.core.order;

public interface OrderService {
	// Order 인터페이스의 구현체, 주문생성 메소드
	Order createOrder(Long memberId, String itemName, int itemPrice);
}
