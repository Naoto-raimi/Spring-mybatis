package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().mvcMatchers("/css/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.formLogin().permitAll();

        http.authorizeRequests()
            .mvcMatchers("/").permitAll()
            .mvcMatchers("/user").authenticated()
            .mvcMatchers("/admin").hasRole("ADMIN")
            .anyRequest().authenticated();

        http.logout().logoutSuccessUrl("/");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                // パスワードは "user"
                .withUser("user").roles("USER").password("$2a$10$nU7XaV7jAcmQRjdcWy0UVubRt1/.QjNOooUfZYCrHHxPEsPApIZ7a").and()
                // パスワードは "admin"
                .withUser("admin").roles("ADMIN").password("$2a$10$dLNUlmLI2wKBOK3eU0tEzufZCwZTE7b0Wlg7suAFl44aZrddG8UgG");
    }
}
