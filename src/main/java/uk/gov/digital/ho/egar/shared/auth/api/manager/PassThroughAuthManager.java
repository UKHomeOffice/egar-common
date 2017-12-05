package uk.gov.digital.ho.egar.shared.auth.api.manager;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * Passthrough AuthenticationManager, just sets the authenticated value for Users to true
 * @author Keshava.Grama
 *
 */
@Component
public class PassThroughAuthManager implements AuthenticationManager{

	@Override
	public Authentication authenticate(Authentication validAuth) throws AuthenticationException {
		validAuth.setAuthenticated(true);
		return validAuth;
	}

}
