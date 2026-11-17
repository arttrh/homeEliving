package ecommerce.api.home.living.senai.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableSpringConfigured
@EnableMethodSecurity
public class SpringSecurity {
    @Bean
    public PasswordEncoder bc(){
        return new BCryptPasswordEncoder();
    }
}
