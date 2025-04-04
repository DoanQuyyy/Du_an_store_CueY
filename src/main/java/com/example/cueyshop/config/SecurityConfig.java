package com.example.cueyshop.config;

import com.example.cueyshop.services.CustomUserDetailServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class SecurityConfig {
    @Autowired
    private CustomUserDetailServies customUserDetailServies;
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests((auth)->auth.requestMatchers("/CueYShop/**").permitAll().requestMatchers("/admin/**").hasAuthority("ADMIN").requestMatchers("/login", "/login?error").permitAll().anyRequest().authenticated()).formLogin(login->login.loginPage("/login").loginProcessingUrl("/login").usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/admin",true));
        return http.build();
    }
    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return (web)->web.debug(true).ignoring().requestMatchers("/static/**","/assets/**","Image/**");
    }

}
