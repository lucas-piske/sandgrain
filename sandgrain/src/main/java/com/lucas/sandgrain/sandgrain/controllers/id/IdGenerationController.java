package com.lucas.sandgrain.sandgrain.controllers.id;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.sandgrain.idgenerator.api.id.IdService;
import com.lucas.sandgrain.idgenerator.domain.model.instance.NoInstanceNamespaceAvailableException;
import com.lucas.sandgrain.idgenerator.domain.model.time.TimestampRetrievalException;

@RestController
public class IdGenerationController {

	@Resource(name="idGenerationService")
	public IdService idGenerationService;
	
	@RequestMapping(value = "/id/new", method = RequestMethod.POST)
	public GeneratedId generateNewId() throws TimestampRetrievalException, NoInstanceNamespaceAvailableException {
		long newLongId = idGenerationService.generateId();
		
		GeneratedId generatedId = new GeneratedId();
		generatedId.setId(newLongId);
		return generatedId;
	}
	
}
