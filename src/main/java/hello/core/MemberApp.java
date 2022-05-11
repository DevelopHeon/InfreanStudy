package hello.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class MemberApp {
	
	public static void main(String[] args) {
		
//		AppConfig appConfig = new AppConfig();
//		MemberService memberService = appConfig.memberService();
//		MemberService memberService = new MemberServiceImpl();

		// Spring을 사용하여 AppConfig 생성
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		// bean에 등록된 메서드의 이름, 타입으로 찾아온다.
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		
		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);
		
		Member findMember = memberService.findMember(1L);
		System.out.println("new member = " + member.getName());
		System.out.println("find Member = " + findMember.getName());
	}
}
