package com.fjx.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.fjx.spring")
@Import(JdbcConfig.class)
public class SpringConfig {


}
