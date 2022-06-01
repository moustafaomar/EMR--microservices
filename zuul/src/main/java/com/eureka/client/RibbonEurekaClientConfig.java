package com.eureka.client;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import com.netflix.niws.loadbalancer.NIWSDiscoveryPing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

public class RibbonEurekaClientConfig {


	@Bean
	public IPing ribbonPing(IClientConfig config) {
		return new NIWSDiscoveryPing();
	}

	@Bean
	public IRule ribbonRule(IClientConfig config) {
		return new AvailabilityFilteringRule();
	}

	@Autowired
	DiscoveryClient discoveryClient;
	@Bean
	public ServerList<Server> getServerList(IClientConfig config) {

		return new ServerList<Server>() {
			@Override
			public List<Server> getInitialListOfServers() {
				return new ArrayList<>();
			}

			@Override
			public List<Server> getUpdatedListOfServers() {
				List<Server> serverList = new ArrayList<>();

				List<ServiceInstance> list = discoveryClient.getInstances(config.getClientName());
				for (ServiceInstance instance : list) {
					serverList.add(new Server(instance.getHost(), instance.getPort()));
				}
				return serverList;
			}
		};
	}

}