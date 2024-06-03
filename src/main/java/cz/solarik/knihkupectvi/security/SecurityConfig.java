package cz.solarik.knihkupectvi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

// Zde je nastaveni Spring-Security
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers(antMatcher("/h2-console/**")).permitAll()
                                .anyRequest().authenticated()
                )
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                // Zde si nastavujeme vlastni login stranku
                .formLogin(form -> form
                    // Tohle zavalo metodu v @Controller ktera je namapovana na @GetMappging("/prihlaseni")
                    .loginPage("/prihlaseni")
                    // V pripade uspesneho prihlaseni, se zavola tahle URL (zase @Controller s mapovanim)
                    .successForwardUrl("/domecek")
                    .permitAll()
                )
                .build();
    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        // Chceme authentizaci s JDBC (relacni databaze)
        return new JdbcUserDetailsManager(dataSource);
    }

    @Autowired
    public void configure(
            AuthenticationManagerBuilder authenticationManagerBuilder,
            DataSource dataSource,
            PasswordEncoder passwordEncoder,
            @Value("${spring.jpa.hibernate.ddl-auto}") String ddlAuto) throws Exception {

        // Zde si nastavujeme AuthenticationManager - co je Spring objekt
        final var builder = authenticationManagerBuilder
                .jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder);

        if (ddlAuto.contains("drop")) {
            dropSchema(dataSource);
        }
        if (ddlAuto.contains("create")) {
            builder.withDefaultSchema();
        }
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    protected void dropSchema(DataSource dataSource) {
        final var jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute("DROP TABLE IF EXISTS AUTHORITIES");
        jdbcTemplate.execute("DROP TABLE IF EXISTS USERS");
    }
}
