package uk.gov.digital.ho.egar.shared.util.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public abstract class NoCallStackException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoCallStackException(String message, Throwable cause) {
		super(message, cause, false, false);
	}

	public NoCallStackException() {
		this(null,null);
	}


	public NoCallStackException(String message) {
		this(message,null);
	}

	public NoCallStackException(Throwable cause) {
		this(null,cause);
	}

}
