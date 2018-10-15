package com.lucas.sandgrain.sandgrain.controllers.managerdiscovery;

import com.lucas.sandgrain.namespacemanager.api.InstanceNamespaceManagerConnectionDTO;

public class NamespaceManagerServiceInstanceAssembler {

	public NamespaceManagerServiceInstance fromDTO(
			InstanceNamespaceManagerConnectionDTO dto) {
		NamespaceManagerServiceInstance instance = 
				new NamespaceManagerServiceInstance();
		
		instance.setAddress(dto.getAddress());
		instance.setPort(dto.getPort());
		instance.setSslPort(dto.getSslPort());
		
		return instance;
	}
	
}
