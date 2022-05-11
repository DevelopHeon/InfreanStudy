package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE) // 어느 레벨에 붙일건지 지정해주는 애노테이션
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {

}
