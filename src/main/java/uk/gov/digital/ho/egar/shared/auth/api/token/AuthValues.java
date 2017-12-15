package uk.gov.digital.ho.egar.shared.auth.api.token;

import java.util.UUID;

import org.springframework.http.HttpHeaders;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthValues {

	public static final String USERID_HEADER = "x-auth-subject";
	public static final String AUTH_HEADER = "Authorization";
	
	private final String authHeader;
	private final UUID userUuid;
	
	
	public HttpHeaders createHttpHeaders() {
		
		HttpHeaders headers = new HttpHeaders();
		
		addUserUuid(headers);
		addAuthHeader(headers);
		
		return headers ;
	}

	private void addAuthHeader(HttpHeaders headers) {
		
		if ( this.getAuthHeader() != null )
		{
			headers.add(AUTH_HEADER, this.getAuthHeader() );
		}
		
	}

	private void addUserUuid(HttpHeaders headers) {

		if ( this.getUserUuid() != null )
		{
			headers.add(USERID_HEADER, this.getUserUuid().toString() );
		}

		
	}
	
}
