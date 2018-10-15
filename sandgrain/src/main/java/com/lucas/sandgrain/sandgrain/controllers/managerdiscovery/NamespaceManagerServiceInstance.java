package com.lucas.sandgrain.sandgrain.controllers.managerdiscovery;

import java.util.Optional;

public class NamespaceManagerServiceInstance {

	private String address;
	private int port;
	private Optional<Integer> sslPort;
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getPort() {
		return port;
	}
	
	public void setPort(int port) {
		this.port = port;
	}
	
	public Optional<Integer> getSslPort() {
		return sslPort;
	}
	
	public void setSslPort(Optional<Integer> sslPort) {
		this.sslPort = sslPort;
	}
	
}
