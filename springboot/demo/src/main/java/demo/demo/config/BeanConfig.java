package demo.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import demo.demo.ImageUtil;

// 스프링에서 어떠한 코드로 설정을할때
// @Configuration 어노테이션을 붙여주면 스프링이 해당 클래스를 설정으로 인식한다.
@Configuration
public class BeanConfig {
    public BeanConfig() {
        System.out.println("BeanConfig Bean 생성");
    }
    @Bean
    public ImageUtil imageUtil() {
        return new ImageUtil();
    }
    

    @Bean
    public String Bean1() {
        return "bean1";
    }


}
