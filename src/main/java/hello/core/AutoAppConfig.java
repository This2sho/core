package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(// 어노테이션붙은 컴포넌트를 찾아서 자동으로 등록해
        basePackages = "hello.core.member", // 베이스 패키지 시작 위치 설정
        basePackageClasses = AutoAppConfig.class, // 지정한 클래스의 패키지를 탐색 시작 위치로 지정 (default는 ComponentScan 쓰여진 package를 시작 위치로)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // 뺄 컴포넌트 추가
)
public class AutoAppConfig {
}
