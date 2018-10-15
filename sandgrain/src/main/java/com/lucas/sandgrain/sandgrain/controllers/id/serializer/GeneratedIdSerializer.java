package com.lucas.sandgrain.sandgrain.controllers.id.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.lucas.sandgrain.sandgrain.controllers.id.GeneratedId;

public class GeneratedIdSerializer extends StdSerializer<GeneratedId> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GeneratedIdSerializer() {
        this(null);
    }
   
    public GeneratedIdSerializer(Class<GeneratedId> t) {
        super(t);
    }
	
	@Override
	public void serialize(GeneratedId value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		
			gen.writeStringField("strId", value.getId().toString());
			gen.writeNumberField("numId", value.getId());
			
		gen.writeEndObject();
	}

}
