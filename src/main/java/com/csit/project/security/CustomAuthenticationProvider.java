package com.csit.project.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

	//private static Logger loger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
		
		
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		System.out.println("username : "+username+" password.... : "+password);
		
		String pass = "$2a$06$urPD/aBOjkuVb.LQ/tjBZet54A1XKGxAJOEhImkFPZEZLYLQnFDY2";
		if(username.equals("admin") && new BCryptPasswordEncoder().matches(password, pass)){
			System.out.println("authenticated");
			List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
			String[] roles = {"ROLE_ADMIN","ROLE_USER","ROLE_ACCOUNT","ROLE_MANAGER","ROLE_READER"};
			for(int i=0;i<5;i++){
				list.add(new SimpleGrantedAuthority(roles[i]));
			}
			
			return new UsernamePasswordAuthenticationToken(username, pass, list);
		}
		
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
