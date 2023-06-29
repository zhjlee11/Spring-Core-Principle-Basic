package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(



        // 아래 두개의 디폴트는, 현재 코드가 있는 패키지(hello.core)을 탐색.
        // 관례에 따르면, 이 Configuration 클래스는 최상단 패키지에 넣어두고 디폴트로 최상단 패키지부터 탐색, 즉 모든 패키지 탐색하기.
        basePackages = "hello.core.member", // 이 패키지에 있는 것들만 Bean 등록
        basePackageClasses = AutoAppConfig.class, // 이 클래스를 탐색 시작 위치로.

        //AppConfig 클래스의 Configuration은 비활성화하는 용도
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {



}
