package com.lucas.sandgrain.sandgrain.namespacemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.lucas.sandgrain.namespacemanager.InstanceNamespaceManager;

@Component
public class InstanceNamespaceManagerStopper {
	
	private final InstanceNamespaceManager instanceNamespaceManager;

	@Autowired
	public InstanceNamespaceManagerStopper(InstanceNamespaceManager instanceNamespaceManager) {
		this.instanceNamespaceManager = instanceNamespaceManager;
	}
	
	@EventListener(ContextClosedEvent.class)
	public void onApplicationContextClosing() throws Exception {
		instanceNamespaceManager.stop();
	}
	
	@EventListener(ApplicationFailedEvent.class)
	public void onApplicationFail() throws Exception {
		instanceNamespaceManager.stop();
	}
	
}
