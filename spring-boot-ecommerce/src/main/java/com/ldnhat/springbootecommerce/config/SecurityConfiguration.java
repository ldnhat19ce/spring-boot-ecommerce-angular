package com.ldnhat.springbootecommerce.config;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
                http.authorizeRequests()
                .antMatchers("/api/orderses/**")
                .authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt();
        http.cors();
        //System.out.println("filter");
        Okta.configureResourceServer401ResponseBody(http);

        // disable csrf since we are not using cookies for session tracking
        http.csrf().disable();
    }

    //    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//
//        http.authorizeRequests()
//                .antMatchers("/api/orderses/**")
//                .authenticated()
//                .and()
//                .oauth2ResourceServer()
//                .jwt();
//        http.cors();
//        System.out.println("filter");
//        //Okta.configureResourceServer401ResponseBody(http);
//        return http.build();
//    }
}
