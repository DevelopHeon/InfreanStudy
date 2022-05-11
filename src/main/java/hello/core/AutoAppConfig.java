package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(// @Component가 붙은 클래스를 찾아서 자동으로 스프링 bean을 등록해준다. AppConfig는 수동으로 등록해주는 것이기 때문에 예외로 빼준다.
		excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

	@Bean(name="memoryMemberRepository")
	MemberRepository memberRepository(){
		return new MemoryMemberRepository();
	}
}
