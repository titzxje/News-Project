package com.web.news.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());

    }

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/post/create").hasRole("ADMIN")
                .antMatchers("/post/edit/**").hasRole("ADMIN")
                .antMatchers("/post").hasAnyRole("ADMIN", "USER")
                .antMatchers("/").permitAll();
        
        http.authorizeRequests()
                .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/register").permitAll();


        http.authorizeRequests()
                .and().exceptionHandling().accessDeniedPage("/403");

        http.authorizeRequests()
                .and().formLogin()
                .loginPage("/login").permitAll()
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/home")
                .failureUrl("/login?message=error")
                .usernameParameter("username")
                .passwordParameter("password")

                .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?message=logout");
    }
}
