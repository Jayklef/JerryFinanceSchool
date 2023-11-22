package com.jayklef.JerryFinanceSchool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http
                .authorizeHttpRequests(
                        (authz) -> authz.
                               // .requestMatchers("/contacts")
                                anyRequest()

                                .authenticated()
                                .requestMatchers("/contact")
                                .permitAll()
                                .and()
                                .logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true)
                                .permitAll())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("USER").password("password").roles("USER")
                .and()
                .withUser("ADMIN").password("password").roles("ADMIN")
                .and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }




}


