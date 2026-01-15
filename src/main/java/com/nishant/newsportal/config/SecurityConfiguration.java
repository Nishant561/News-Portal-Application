package com.nishant.newsportal.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain defaultSecurityFilterConfiguration(HttpSecurity http) throws Exception{
        http.csrf((csrf) -> csrf.ignoringRequestMatchers("/saveuser").ignoringRequestMatchers("/login"))
                .authorizeHttpRequests(
                        auth ->
                                auth
                                        .requestMatchers("/register").permitAll()
                                        .requestMatchers("/saveuser").permitAll()
                                        .requestMatchers("/login").permitAll()
                                        .requestMatchers("/home").hasRole("USER")
                                        .requestMatchers("/profile").hasRole("USER")
                                        .anyRequest().permitAll()


                )
                .formLogin(loginConfig -> loginConfig.loginPage("/login").usernameParameter("email").passwordParameter("password").defaultSuccessUrl("/home").failureUrl("/login?errors=true").permitAll())
                .logout(logoutconfig -> logoutconfig.logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll());





        return http.build();
    }


   /* @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails user = User.builder().username("nishant").password(passwordEncoder().encode("nishant")).roles("USER").build();


        return new InMemoryUserDetailsManager(user);


    }*/


}


