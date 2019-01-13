package mn.saga.vstream.configs;

import mn.saga.vstream.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
@EnableWebSecurity(debug = true)
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private int expiration = 4*60*60; // 4hours

    @Autowired
//    @Qualifier("userDetailsService")
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("admin")
                .secret("secret")
                .accessTokenValiditySeconds(expiration)
                .refreshTokenValiditySeconds(58000)
                .authorities("ROLE_ADMIN", "ROLE_USER")
                .scopes("read")
                .redirectUris("/login")
                .authorizedGrantTypes("password", "refresh_token", "client_credentials")
                .and()
                .withClient("browser")
                .secret("secret")
                .accessTokenValiditySeconds(expiration)
                .refreshTokenValiditySeconds(58000)
                .authorities("ROLE_USER")
                .scopes("read")
                .redirectUris("/login")
                .authorizedGrantTypes("password", "refresh_token", "client_credentials");
    }


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer configurer) throws Exception {
        configurer.authenticationManager(authenticationManager);
        configurer.userDetailsService(userDetailsService);
    }
}
