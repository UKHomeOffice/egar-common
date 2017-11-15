package uk.gov.digital.ho.egar.shared.util;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.Map;
import java.util.UUID;
import java.util.function.Predicate;

import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JwtTools{
	Predicate<Object> nullCheck = (s) -> s != null; 
	Predicate<Object> isUUID = (s) -> s.getClass() == UUID.randomUUID().getClass();
	private static final String KEY_FOR_USER_UUID ="sub";
	@SuppressWarnings("unchecked")
	public String getUUIDFromBearerToken(String bearerToken) throws AccessDeniedException{

		if (bearerToken == null) {
			throw new AccessDeniedException("Unauthorised");
		}
		ObjectMapper objectMapper = new ObjectMapper();
		bearerToken = bearerToken.replace("Bearer", "").trim();
		
		Jwt token = JwtHelper.decode(bearerToken);
		Map<String, Object> claimsMap = null;
		try {
			claimsMap = objectMapper.readValue(token.getClaims(), Map.class);
		} catch (IOException e) {
			throw new AccessDeniedException("Unauthorised");
		}				
		if(nullCheck.test(claimsMap.get(KEY_FOR_USER_UUID))){
			return isUUID.test(claimsMap.get(KEY_FOR_USER_UUID))? claimsMap.get(KEY_FOR_USER_UUID).toString():
				(String) claimsMap.get(KEY_FOR_USER_UUID);
		}
		throw new AccessDeniedException("Unauthorised");
	}
}
