package mooon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @author Administrator
 * @date 2019/11/28.
 */
@EnableWebFluxSecurity
public class SecurityConfig {

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(
			ServerHttpSecurity http) {
		http.csrf().disable()
				.authorizeExchange()
				.pathMatchers(HttpMethod.GET, "/api/admin").hasRole("ADMIN")
				.pathMatchers("/**").permitAll()
				.and()
				.httpBasic();
		return http.build();
	}
}
