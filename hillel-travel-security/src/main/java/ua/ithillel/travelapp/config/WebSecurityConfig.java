package ua.ithillel.travelapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import ua.ithillel.travelapp.filter.JwtFilter;
import ua.ithillel.travelapp.repo.UserRepo;
import ua.ithillel.travelapp.service.AppUserDetailsService;
import ua.ithillel.travelapp.util.JwtUtil;

import java.util.Arrays;
import java.util.List;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JwtUtil jwtUtil;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Basic AUTH
//        http
//                .csrf(AbstractHttpConfigurer::disable) // cross server request forgery
//                .authorizeHttpRequests(reqs -> reqs
//                        .requestMatchers(antMatcher("/register"), antMatcher("/login")).permitAll()
//                        .anyRequest().authenticated())
//                .cors(conf -> conf.disable())
//                .httpBasic(basic -> basic.authenticationEntryPoint(new AppBasicAuthenticationEntryPoint()));

        // JWT AUTH
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(reqs -> reqs
                        .requestMatchers(antMatcher("/register"), antMatcher("/login")).permitAll()
                        .anyRequest().authenticated())
                .cors(conf -> conf.disable())
                .sessionManagement(conf -> conf.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(new JwtFilter(jwtUtil, userDetailsService()),
                UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedHeaders(List.of(HttpHeaders.CONTENT_TYPE, HttpHeaders.AUTHORIZATION));
        configuration.setAllowedMethods(Arrays.asList("GET","POST", "DELETE", "PUT", "OPTIONS"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
//        UserDetails userDetails = User.withUsername("hillel")
//                .password(passwordEncoder().encode("Hillel123"))
//                .build();
//
//        return new InMemoryUserDetailsManager(userDetails);
        return new AppUserDetailsService(userRepo);
    }
}
