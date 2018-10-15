package com.lucas.sandgrain.sandgrain.controllers.managerdiscovery;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.sandgrain.namespacemanager.InstanceNamespaceManager;

@RestController
public class NamespaceManagerServiceDiscoveryController {

	@Resource(name="instanceNamespaceManager")
	private InstanceNamespaceManager namespaceManager;
	
	private NamespaceManagerServiceInstanceAssembler serviceInstanceAssembler = 
			new NamespaceManagerServiceInstanceAssembler();
	
	@RequestMapping(value = "/instances", method = RequestMethod.GET)
	public List<NamespaceManagerServiceInstance> getOnlineServiceInstances() {
		return namespaceManager
		.getManagerDiscoveryService()
		.getOnlineManagerInstances()
		.stream()
		.map(instDTO -> serviceInstanceAssembler.fromDTO(instDTO))
		.collect(Collectors.toList());
	}
	
}
