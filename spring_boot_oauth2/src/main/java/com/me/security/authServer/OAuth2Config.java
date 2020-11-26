//package com.me.security.authServer;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.ClientDetailsService;
//import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
//import org.springframework.security.oauth2.provider.endpoint.TokenEndpointAuthenticationFilter;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
//import org.springframework.security.rsa.crypto.KeyStoreKeyFactory;
//
//import com.me.service.UserDetailsService;
//
//@Configuration
//@EnableAuthorizationServer
//public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
//
//	private boolean checkUserScope = true; // is from property file	
//	@Autowired
//	private DataSource dataSource;
//	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//	
//	@Bean // dummy to solve the error
//	PasswordEncoder getEncoder() {
//		passwordEncoder = new BCryptPasswordEncoder();
//	    return passwordEncoder;
//	}
//	
//	@Autowired
//	private UserDetailsService userDetailsService;
//	
//	@Autowired
//	private ClientDetailsService clientDetailsService;
//	
////	@Autowired
////	@Qualifier("authenticationManagerBean")
////	private AuthenticationManager authenticationManager;
//	
////	@Bean
////	public AuthenticationManager customAuthenticationManager() throws Exception {
////	  return customAuthenticationManager();
////	}
//	
//	// Used for CUstom Oauth2 security 
//	@Bean
//	public OAuth2RequestFactory requestFactory() {
//		CustomOauth2RequestFactory reqFactory = new CustomOauth2RequestFactory(clientDetailsService);
//		reqFactory.setCheckUserScopes(true);
//		return reqFactory;
//	}
//	
//	
//	@Bean
//	public TokenStore tokenStore() {
//		return new JwtTokenStore(jwtAccessTokenConverter());
//	}
//	
//	@Bean
//	public JwtAccessTokenConverter jwtAccessTokenConverter() {
//		JwtAccessTokenConverter converter = new CustomTokenEnhancer();
//		converter.setKeyPair(
//				new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), "password".toCharArray()).getKeyPair("jwt"));
//		return converter;
//	}
//
//	@Override
//	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
////		configurer.jdbc(dataSource)
////		.passwordEncoder(passwordEncoder)
//		clients
//		.inMemory()
//		;
//	}
//	
////	@Bean
////	public TokenEndpointAuthenticationFilter tokenEndpointAuthenticationFilter() {
////		return new TokenEndpointAuthenticationFilter(authenticationManager, requestFactory());
////	} 
//	
//	@Override
//	public void configure(AuthorizationServerSecurityConfigurer endpoints) throws Exception {
//		endpoints.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
//	}
//	
////	@Override
////	public void configure(AuthorizationServerEndpointsConfigurer authServer) throws Exception {
////		authServer.tokenStore(tokenStore()).tokenEnhancer(jwtAccessTokenConverter())
////		.authenticationManager(authenticationManager).userDetailsService(userDetailsService);
////		if (checkUserScope) {
////			authServer.requestFactory(requestFactory());
////		}
////	}
////	
//	
//}
