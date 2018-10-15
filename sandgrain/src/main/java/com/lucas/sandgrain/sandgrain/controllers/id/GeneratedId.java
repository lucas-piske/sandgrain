package com.lucas.sandgrain.sandgrain.controllers.id;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lucas.sandgrain.sandgrain.controllers.id.serializer.GeneratedIdSerializer;

@JsonSerialize(using = GeneratedIdSerializer.class)
public class GeneratedId {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
