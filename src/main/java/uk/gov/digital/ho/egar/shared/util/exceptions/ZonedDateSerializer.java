/**
 * 
 */
package uk.gov.digital.ho.egar.shared.util.exceptions;

import java.io.IOException;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
/**
 * Custom serializer for ZonedDateTime used for timestamps.
 */
public class ZonedDateSerializer extends JsonSerializer<ZonedDateTime> {

	@Override
	public void serialize(ZonedDateTime value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		gen.writeString(value.toString());
	}

}
