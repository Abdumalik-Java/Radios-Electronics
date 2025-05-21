package abdumalik.dev.radioselectronics.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.UUID;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public AuthenticationProvider authenticationProvider() {
        String password = UUID.randomUUID().toString();
        System.out.println("                ---------------------------User Password -----------------------> " + password);

        UserDetails user = User.builder()
                .username("user")
                .password("{noop}" + password)
                .roles("USER")
                .build();

        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(new InMemoryUserDetailsManager(user));
        return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
            authorizationManagerRequestMatcherRegistry

                    // About class
                    .requestMatchers(HttpMethod.GET, "/about","/about/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/about").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/about/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/about/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    // Address class
                    .requestMatchers(HttpMethod.GET, "/address","/address/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/address").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/address/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/address/*").hasRole("ADMIN")
                    // Blog class
                    .requestMatchers(HttpMethod.GET, "/blog","/blog/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/blog").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/blog/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/blog/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    // Card class
                    .requestMatchers(HttpMethod.GET, "/card","/card/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/card").hasAnyRole("SUPER_ADMIN", "ADMIN", "USER")
                    .requestMatchers(HttpMethod.PUT, "/card").hasAnyRole("SUPER_ADMIN", "ADMIN", "USER")
                    .requestMatchers(HttpMethod.DELETE, "/card").hasAnyRole("SUPER_ADMIN", "ADMIN", "USER")
                    // CartItems class
                    .requestMatchers(HttpMethod.GET, "/cartItems","/cartItems/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/cartItems").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/cartItems/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/cartItems/*").hasAnyRole("SUPER_ADMIN","ADMIN")
                    // Category class
                    .requestMatchers(HttpMethod.GET, "/category", "/category/**").permitAll()
                    .requestMatchers(HttpMethod.POST, "/category").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/category/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/category/*").hasAnyRole("SUPER_ADMIN","ADMIN")
                    // Checkout class
                    .requestMatchers(HttpMethod.GET, "/checkout","/checkout/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/checkout").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/checkout/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/checkout/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    // Comment class
                    .requestMatchers(HttpMethod.GET, "/comment","/comment/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/comment").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/comment/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/comment/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    // Contact class
                    .requestMatchers(HttpMethod.GET, "/contact","/contact/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/contact").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/contact/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/contact/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    // Language class
                    .requestMatchers(HttpMethod.GET, "/language","/language/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/language").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/language/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/language/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    // Like class
                    .requestMatchers(HttpMethod.GET, "/like","/like/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/like").permitAll()
                    .requestMatchers(HttpMethod.PUT, "/like/*").permitAll()
                    .requestMatchers(HttpMethod.DELETE, "/like/*").permitAll()
                    // Login class
                    .requestMatchers(HttpMethod.GET, "/login","/login/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/login").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/login/*").hasAnyRole("SUPER_ADMIN", "ADMIN", "USER")
                    .requestMatchers(HttpMethod.DELETE, "/login/*").hasAnyRole("SUPER_ADMIN", "ADMIN", "USER")
                    // Photo class
                    .requestMatchers(HttpMethod.GET, "/phone","/phone/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/phone").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/phone/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/phone/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    // Product class
                    .requestMatchers(HttpMethod.GET, "/product","/product/**").permitAll()
                    .requestMatchers(HttpMethod.POST, "/product").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/product/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/product/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    // Tags class
                    .requestMatchers(HttpMethod.GET, "/tag","/tag/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/tag").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/tag").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/tag").hasAnyRole("SUPER_ADMIN", "ADMIN","USER")
                    // Total class
                    .requestMatchers(HttpMethod.GET, "/total","/total/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/total").hasAnyRole("SUPER_ADMIN", "ADMIN", "USER")
                    .requestMatchers(HttpMethod.PUT, "/total/*").hasAnyRole("SUPER_ADMIN", "ADMIN", "USER")
                    .requestMatchers(HttpMethod.DELETE, "/total/*").permitAll()
                    // YourOrder class
                    .requestMatchers(HttpMethod.GET, "/yourOrder","/yourOrder/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/yourOrder").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/yourOrder/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/yourOrder/*").hasAnyRole("SUPER_ADMIN", "ADMIN")


                    .anyRequest()
                    .authenticated();
        }).formLogin(Customizer.withDefaults());

        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.ignoringRequestMatchers("/api/**"));
        http.cors(cors -> cors.configurationSource(request -> {
            var config = new org.springframework.web.cors.CorsConfiguration();
            config.setAllowedOrigins(List.of("https://your-frontend.com")); // frontend domain
            config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
            config.setAllowedHeaders(List.of("*"));
            return config;
        }));
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {

            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                String md5 = MD5Util.getMD5(rawPassword.toString());
                return md5.equals(encodedPassword);
            }
        };

    }

}