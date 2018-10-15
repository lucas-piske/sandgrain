package com.lucas.sandgrain.sandgrain.namespacemanager;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lucas.sandgrain.namespacecontainer.component.NamespaceContainerComponentFactoryImpl;
import com.lucas.sandgrain.namespaceledger.component.NamespaceLedgerComponentFactoryImpl;
import com.lucas.sandgrain.namespacemanager.InstanceNamespaceManager;
import com.lucas.sandgrain.namespacemanager.config.InstanceNamespaceManagerConfig;
import com.lucas.sandgrain.namespacemanager.curator.CuratorFrameworkFactoryImpl;
import com.lucas.sandgrain.namespacemanager.id.InstanceNamespaceManagerIdGenerator;
import com.lucas.sandgrain.namespacepinger.component.NamespacePingerComponentFactoryImpl;

@Configuration
public class InstanceNamespaceManagerFactory {

	@Value("${sandgrain.advertisedAddress}")
	private String advertisedAddress;
	
	@Value("${server.port}")
	private int port;
	
	@Value("${sandgrain.clusterId}")
	private int clusterId;
	
	@Value("${sandgrain.pingIntervalMs}")
	private int pingIntervalMs;
	
	@Value("${sandgrain.pingTakeoverMinWaitTimeMs}")
	private long pingTakeoverMinWaitTimeMs;
	
	@Value("${sandgrain.zkConnectString}")
	private String zkConnectString;
	
	@Value("${sandgrain.zkPathPrefix}")
	private String zkPathPrefix;
	
	
	@Bean(name="instanceNamespaceManager")
	public InstanceNamespaceManager namespaceManager() {
		InstanceNamespaceManagerConfig config = new InstanceNamespaceManagerConfig();
    	config.setAddress(advertisedAddress);
    	config.setPort(port);
    	config.setSslPort(Optional.empty());
		config.setClusterId(clusterId);
    	config.setPingIntervalMs(pingIntervalMs);
    	config.setPingTakeoverMinWaitTime(pingTakeoverMinWaitTimeMs);
    	config.setZkConnectString(zkConnectString);
    	config.setZkPathPrefix(zkPathPrefix);
    	
		return new InstanceNamespaceManager(
				new CuratorFrameworkFactoryImpl(),
				new InstanceNamespaceManagerIdGenerator(),
				new NamespacePingerComponentFactoryImpl(),
				new NamespaceLedgerComponentFactoryImpl(),
				new NamespaceContainerComponentFactoryImpl(),
				config);
	}
	
}
