package com.demo;

import com.demo.db.TransactionUserService;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.TimeZone;

/**
 * Created by Administrator on 2019/7/26.
 */
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableJpaRepositories
@EnableRetry
@RestController
public class SpringAopDemoApplication {

    @Autowired
    TransactionUserService transactionUserService;

    public static void main(String args[]) {
        SpringApplication.run(SpringAopDemoApplication.class, args);
    }

    @GetMapping("/insert")
    public void insert(@RequestParam Long id) {
        transactionUserService.insertUser(id);
    }

    @GetMapping("/delete")
    public void delete(@RequestParam Long id) {
        transactionUserService.deleteUser(id);
    }

    @GetMapping("/tran")
    public void tran() {
        transactionUserService.testTransaction(1L, 2L);
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
