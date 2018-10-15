package com.lucas.sandgrain.sandgrain.namespacemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.lucas.sandgrain.namespacemanager.InstanceNamespaceManager;

@Component
public class InstanceNamespaceManagerStarter {

	private final InstanceNamespaceManager instanceNamespaceManager;

	@Autowired
	public InstanceNamespaceManagerStarter(
			InstanceNamespaceManager instanceNamespaceManager) {
		this.instanceNamespaceManager = instanceNamespaceManager;
	}
	
	@EventListener(ApplicationStartedEvent.class)
	public void onApplicationStart() throws Exception {
		instanceNamespaceManager.start();
	}
	
}
