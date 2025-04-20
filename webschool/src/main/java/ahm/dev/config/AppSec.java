package ahm.dev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppSec {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
            .requestMatchers("/assets/css/**").permitAll()
            .requestMatchers("/assets/scripts/**").permitAll()
            .requestMatchers("/assets/images/**").permitAll()
            .requestMatchers("/assets/webfonts/**").permitAll()
            .requestMatchers("/").permitAll()
            .requestMatchers("/home").permitAll()
            .requestMatchers("/login").permitAll()
            .requestMatchers("/logout").permitAll()
            .requestMatchers("/register").permitAll()
            .requestMatchers("/about").permitAll()
            .requestMatchers("/contact").permitAll()
            .requestMatchers("/dashboard").permitAll()
            .anyRequest().authenticated();

        // login process
        http.formLogin().loginPage("/login")
            .defaultSuccessUrl("/home", true)   
            .failureUrl("/login?error=true")
            .permitAll();

        http.logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login?logout=true")
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID");

        http.csrf().disable();
        
        return http.build();
    }
    
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.builder()
            .username("user")
            .password(passwordEncoder().encode("pass"))
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }
    

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}
