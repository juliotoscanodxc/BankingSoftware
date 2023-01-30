package com.luxoft.training.spring.cloud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("account")
                .password("{noop}account")
                .authorities("ACCOUNT_READ",
                        "ACCOUNT_WRITE", "ACCOUNT_PROCESS")
                .and()
                .withUser("card")
                .password("{noop}card")
                .authorities("CARD_WRITE", "ACCOUNT_READ")
                .and()
                .withUser("client")
                .password("{noop}client")
                .authorities("CLIENT_READ",
                        "CLIENT_WRITE", "ACCOUNT_READ", "CARD_READ")
                .and()
                .withUser("processing")
                .password("{noop}processing")
                .authorities("PROCESSING", "ACCOUNT_PROCESS");
    }
}

