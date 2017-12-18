package uk.gov.digital.ho.egar.shared.util.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * This is a base exception class to prevent the JVM from scanning the Java call stack unnecessarily when throwing an exception.
 * This is a performance improvement as determining the call stack takes 100x times longer to construct the object.
 * This object also may be used to create a JSON response for system errors so it suppresses empty methods.
 * Such as {@link #getCause()} and {@link #getStackTrace()}.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public abstract class NoCallStackException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoCallStackException(String message, Throwable cause) {
		// This is the call that turns off the stack trace "finding".
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
