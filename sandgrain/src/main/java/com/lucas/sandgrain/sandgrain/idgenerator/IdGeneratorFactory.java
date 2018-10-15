package com.lucas.sandgrain.sandgrain.idgenerator;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lucas.sandgrain.idgenerator.api.id.IdService;
import com.lucas.sandgrain.idgenerator.api.id.IdServiceImpl;
import com.lucas.sandgrain.idgenerator.domain.model.id.IdGenerationService;
import com.lucas.sandgrain.idgenerator.domain.model.instance.DataCenterNamespace;
import com.lucas.sandgrain.idgenerator.domain.model.sequence.SequenceRegistry;
import com.lucas.sandgrain.idgenerator.domain.model.sequence.TwelveBitSequenceFactory;
import com.lucas.sandgrain.idgenerator.infrastructure.instance.InstanceNamespaceAccessorImpl;
import com.lucas.sandgrain.idgenerator.infrastructure.time.BackShiftWaitStrategy;
import com.lucas.sandgrain.idgenerator.infrastructure.time.OnlyIncreasingTimestampRetriever;
import com.lucas.sandgrain.idgenerator.infrastructure.time.SystemTimeInMillisRetriever;
import com.lucas.sandgrain.namespacemanager.InstanceNamespaceManager;

@Configuration
public class IdGeneratorFactory {

	@Resource(name="instanceNamespaceManager")
	private InstanceNamespaceManager namespaceManager;
	
	@Bean(name="idGenerationService")
	public IdService idGenerationService() {
		InstanceNamespaceAccessorImpl namespaceAccessor = 
				new InstanceNamespaceAccessorImpl(
						namespaceManager.getContainerService());
		
		SystemTimeInMillisRetriever timeInMillisRetriever = 
				new SystemTimeInMillisRetriever();
		
		return new IdServiceImpl(
				new IdGenerationService(
						new SequenceRegistry(
								new TwelveBitSequenceFactory()),
						new OnlyIncreasingTimestampRetriever(
								timeInMillisRetriever,
								new BackShiftWaitStrategy(
										timeInMillisRetriever)),
						namespaceAccessor,
						new DataCenterNamespace(0)
						)
				);
	}
	
}
