package hello.core.sigleton;

public class StatefulService {
	
//	private int price; // 상태를 유지하는 필드 -> 10000원이 20000원으로 변경이 되어버림
	
	public int order(String name, int price) {
		System.out.println("name = " + name + " price = " + price);
//		this.price = price; // 여기가 문제
		return price;
	}
	
}
