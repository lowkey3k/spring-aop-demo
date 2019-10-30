package com.demo;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.retry.annotation.EnableRetry;

import java.util.TimeZone;

/**
 * Created by Administrator on 2019/7/26.
 */
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableJpaRepositories
@EnableRetry
public class SpringAopDemoApplication {

    public static void main(String args[]) {
        args = new String[1];
        args[0] = "***********************################@@@@@@@@@@@@@@@@@@@@@@@@@@";
        SpringApplication.run(SpringAopDemoApplication.class, args);
    }

    @Bean
    public Hibernate5Module hibernate5Module() {
        return new Hibernate5Module();
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonBuilderCustomizer() {
        return builder -> {
            builder.indentOutput(true);
            builder.timeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        };
    }
}
