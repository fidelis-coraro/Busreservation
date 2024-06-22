package com.busBooking.config;

import java.io.IOException;
import java.util.Collection;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
										Authentication authentication) throws IOException, ServletException {

		String redirectUrl = determineRedirectUrl(authentication);
		if (redirectUrl == null) {
			throw new IllegalStateException("Failed to determine redirect URL for user with roles: " +
					authentication.getAuthorities());
		}
		new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
	}

	private String determineRedirectUrl(Authentication authentication) {
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			String role = grantedAuthority.getAuthority();
			if (role.equals("USER")) {
				return "/dashboard";

			} else if (role.equals("ADMIN")) {
				return "/adminScreen";
			}
		}
		return null;
	}
}


