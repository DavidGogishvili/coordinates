package ge.davidgogishvili.projects.coordinates.Security;

import ge.davidgogishvili.projects.coordinates.Repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final UserRepo userRepo;

    @Bean
    public PasswordEncoder getPasswordEncoder () {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("login").permitAll().anyRequest().authenticated()
                )
                .httpBasic(withDefaults())
                .formLogin(withDefaults());

        return http.build();
    }
    @Bean
    public UserManager userDetailsService() {
        return new UserManager(userRepo);
    }

}