package com.me.security.authServer;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import com.me.model.Oauth_User;

public class CustomTokenEnhancer extends JwtAccessTokenConverter {

	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Oauth_User user = (Oauth_User) authentication.getPrincipal();
		Map<String, Object> info = new LinkedHashMap<>(accessToken.getAdditionalInformation());
		info.put("email", user.getEmail());
		
		DefaultOAuth2AccessToken customOAuth2AccessToken = new DefaultOAuth2AccessToken(accessToken);
		customOAuth2AccessToken.setAdditionalInformation(info);
		return super.enhance(accessToken, authentication);
	}
	
}
