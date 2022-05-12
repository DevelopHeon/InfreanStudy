package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
       ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{

        @Autowired(required = false) // 의존관계가 없을경우 메소드 자체가 호출이 되지 않음
        public void setNoBean1(Member noBean1){ // 스프링 컨테이너에 관리되는게 아님
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired // 호출은 되지만 null로 반환된다.
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }
        @Autowired // 스프링 빈이 없으면 Optional.empty 로 반환
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
