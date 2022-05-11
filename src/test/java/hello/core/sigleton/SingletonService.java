package hello.core.sigleton;

public class SingletonService {
	
	// static으로 선언해주면 클래스 영역에 올라가므로 하나만 존재하게 된다.
	private static final SingletonService instance = new SingletonService();
	
	// private 생성자를 통해 외부에서 호출이 불가능하도록 설정
	private SingletonService() {	}
	
	// 싱글톤 패턴의 객체를 호출하기 위한 방법은 getInstance() 밖에 없다.
	public static SingletonService getInstance() {
		return instance;
	}
	
	public void logic() {
		System.out.println("싱글톤 객체 로직 호출");
	}
}
