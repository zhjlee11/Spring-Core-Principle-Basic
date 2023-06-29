package hello.core.scan.Filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE) //클래스 레벨에 붙는 어노테이션이라는 의미
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {



}
