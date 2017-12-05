package uk.gov.digital.ho.egar.shared.auth.api.token;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * Custom user for Egar API's, makes the token and UUID for active user
 * available in the security context
 * 
 * @author Keshava.Grama
 *
 */
public class UserWithUUID extends User {

	private static final long serialVersionUID = 1L;

	private final Optional<UUID> userUuid;
	private final Optional<String> headerToken;

	public UserWithUUID(String username, String userUUID, Collection<? extends GrantedAuthority> authorities,
			String headerToken) throws Exception {
		super(username, "", true, true, true, true, authorities);
		this.userUuid = Optional.of(UUID.fromString(userUUID));
		this.headerToken = Optional.of(headerToken);
	}

	public UUID getUserUuid() {
		return userUuid.isPresent() ? userUuid.get() : null;
	}

	public String getHeaderToken() {
		return headerToken.isPresent()? headerToken.get():null;
	}

	/**
	 * Retrieves and checks the current authentication context.
	 * Searching for a authentication principle of the type  UserWithUUID.
	 * @return the value of {@link #getUserUuid()} of the UserWithUUID stored in Principle.
	 */
	public static UUID getUUIDOfUser() {

		
		Object principle = UserWithUUID.getPrinciple();

		
		if ( principle instanceof UserWithUUID) 
		{
			UserWithUUID userInContext = (UserWithUUID) principle ;

			if ( userInContext.getUserUuid() == null ) new AuthenticationServiceException("No authentication Token");

			return userInContext.getUserUuid();
		}

		throw new AuthenticationServiceException("Invalid Token");
	}

	public static String getTokenOfUser() {

		Object principle = UserWithUUID.getPrinciple();

		if ( principle instanceof UserWithUUID) 
		{
			UserWithUUID userInContext = (UserWithUUID) principle ;

			if ( userInContext.getHeaderToken() == null ) new AuthenticationServiceException("No authentication Token");

			return userInContext.getHeaderToken();
		}

		throw new AuthenticationServiceException("Invalid Token");
	}


	private static Object getPrinciple() {
		if (SecurityContextHolder.getContext() == null) throw new AuthenticationServiceException("No Context");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if ( auth == null ) throw new AuthenticationServiceException("No Authentication");

		Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if ( principle == null ) throw new AuthenticationServiceException("Authentication configuration issue.");

		return principle;
	}
}
