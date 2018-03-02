package uk.gov.digital.ho.egar.shared.auth.api.token;

import java.util.UUID;


import org.springframework.http.HttpHeaders;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * JWT token support.
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class UserValues extends AuthValues{

	public static final String EMAIL_HEADER = "x-auth-email";
	public static final String FORENAME_HEADER = "x-auth-given-name";
	public static final String SURNAME_HEADER = "x-auth-family-name";
	public static final String CONTACT_HEADER = "x-auth-contact"; //FIXME need header.this is wrong
	public static final String ALTERNATIVE_CONTACT_HEADER = "x-auth-alt-contact"; //FIXME need header.this is wrong

	private String email;
	private String forename;
	private String surname;
	private String contact;
	private String alternativeContact;

	public UserValues(String authHeader, UUID userUuid, String email, String forename, String surname, String contact,
			String alternativeContact) {
		super(authHeader, userUuid);
		this.email = email;
		this.forename = forename;
		this.surname = surname;
		this.contact = contact;
		this.alternativeContact = alternativeContact;
	}
	
	public HttpHeaders createHttpHeaders() {

		HttpHeaders headers = super.createHttpHeaders();
		addEmail(headers);
		addForename(headers);
		addSurname(headers);
		addContact(headers);
		addAlternativeContact(headers);
		
		return headers ;
	}

	private void addAlternativeContact(HttpHeaders headers) {
		if ( this.getAlternativeContact() != null )
		{
			headers.add(ALTERNATIVE_CONTACT_HEADER, this.getAlternativeContact());
		}
	}		

	private void addContact(HttpHeaders headers) {
		if ( this.getContact() != null )
		{
			headers.add(CONTACT_HEADER, this.getContact() );
		}
	}		
	
	private void addSurname(HttpHeaders headers) {
		if ( this.getSurname() != null )
		{
			headers.add(SURNAME_HEADER, this.getSurname() );
		}
	}		

	private void addForename(HttpHeaders headers) {
		
		if ( this.getForename() != null )
		{
			headers.add(FORENAME_HEADER, this.getForename() );
		}
	}
		
	private void addEmail(HttpHeaders headers) {
		
		if ( this.getEmail() != null )
		{
			headers.add(EMAIL_HEADER, this.getEmail() );
		}
	}

	

}
