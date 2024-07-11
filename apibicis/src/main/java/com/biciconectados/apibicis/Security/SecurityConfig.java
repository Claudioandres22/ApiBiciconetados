/*package com.biciconectados.apibicis.Security;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableAutoConfiguration
@RequiredArgsConstructor
public class SecurityConfig {

    /*@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {

            return http
                    .csrf(csrf -> csrf.disable())
                    .authorizeHttpRequests(authRequest -> authRequest
                            .requestMatchers("auth/**").permitAll()
                            .anyRequest().authenticated()
                    )
                    .formLogin(Customizer.withDefaults())
                    .build();


    }




























    //@Autowired
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.sessionManagement(
                management -> management.sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS))
                .authorizeRequests(Authorize -> Authorize
                        .requestMatchers("/api/**").authenticated()
                        .anyRequest().permitAll())
                .csrf(csrf -> csrf.disable());



        return http.build();
    }






*/





