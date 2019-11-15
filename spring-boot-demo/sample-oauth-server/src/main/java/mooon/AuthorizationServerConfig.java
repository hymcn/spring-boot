package mooon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @date 2019/11/12.
 */
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private RedisConnectionFactory connectionFactory;

    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient("appid")
                .resourceIds("res-1")
                .authorizedGrantTypes("client_credentials", "authorization_code", "implicit", "password")
                .scopes("app")
                .authorities("ROLE_APP")
                .redirectUris("http://localhost:8081/api/a")
                .secret(passwordEncoder().encode("123"))
                .accessTokenValiditySeconds(24 * 60 * 30)
                .refreshTokenValiditySeconds(48* 60 * 60);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        Map<String, PasswordEncoder> passwordEncoderMap = new HashMap<>();
        passwordEncoderMap.put("noop", org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance());
        return new DelegatingPasswordEncoder("noop", passwordEncoderMap);
    }


    /**
     * Spring security5中新增加了加密方式，并把原有的spring security的密码存储格式改了
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
        endpoints.tokenStore(tokenStore());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()");
        security.checkTokenAccess("isAuthenticated()");
    }

    @Bean
    public TokenStore tokenStore() {
        return new RedisTokenStore(connectionFactory);
    }

}
