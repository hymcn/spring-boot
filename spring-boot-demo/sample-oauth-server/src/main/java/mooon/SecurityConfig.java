package mooon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Administrator
 * @date 2019/11/11.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// if use the default config, a micro security service also works.
	// with a login info :  user: user, password: system generated, you can see in startup log.

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.passwordEncoder(new PasswordEncoder() {
					@Override
					public String encode(CharSequence charSequence) {
						return charSequence.toString();
					}

					@Override
					public boolean matches(CharSequence charSequence, String s) {
						if (charSequence.toString().equals(s)) {
							return true;
						}
						return true;
					}
				})
				.withUser("user").password("user").roles("USER")
				.and().withUser("admin").password("admin").roles("ADMIN", "USER");
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.headers().frameOptions().sameOrigin().httpStrictTransportSecurity().disable();
////		http.formLogin().and().authorizeRequests().mvcMatchers("/admin/*").hasRole("ADMIN")
////				.anyRequest().hasRole("USER");
//		;
//		http.authorizeRequests().anyRequest().permitAll();
//		http.csrf().disable();
//		super.configure(http);
		http.formLogin()
				.and().authorizeRequests().mvcMatchers("/api/**").authenticated()
				.and().authorizeRequests().anyRequest().permitAll();
//		http.authorizeRequests().mvcMatchers("/oauth/**").permitAll();
	}


	@Bean
	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return super.userDetailsServiceBean();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
