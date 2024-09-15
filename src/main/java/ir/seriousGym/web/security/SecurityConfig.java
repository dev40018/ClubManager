package ir.seriousGym.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.XorCsrfTokenRequestAttributeHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        XorCsrfTokenRequestAttributeHandler xor = new XorCsrfTokenRequestAttributeHandler();
        xor.setCsrfRequestAttributeName("_csrf");
        http
                .csrf(csrf -> csrf.csrfTokenRequestHandler(xor))
                .authorizeHttpRequests(
                        request -> request
                        .requestMatchers(
                                "/login",
                                "/register",
                                "/clubs",
                                "/register/**",
                                "/css/**",
                                "/js/**",
                                "/assets/**")
                        .permitAll()
                                .anyRequest()
                                .authenticated()
                ).formLogin(form -> form

                        //you can use webDefaults
                        .loginPage("/login")
                        .defaultSuccessUrl("/clubs")
                        .loginProcessingUrl("/login")
                        .failureUrl("/login?error=true")
                        .permitAll()
                )
                .logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll()
                );
        return http.build();
    }
    
}
