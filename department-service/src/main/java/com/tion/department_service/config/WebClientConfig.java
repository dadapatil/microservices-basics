package com.tion.department_service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.tion.department_service.client.EmployeeClient;

import io.netty.resolver.DefaultAddressResolverGroup;
import reactor.netty.http.client.HttpClient;

@Configuration
public class WebClientConfig {
	
	@Autowired
	private LoadBalancedExchangeFilterFunction filterFunction;
	
	@Bean 
	@LoadBalanced
	public WebClient.Builder employeeWebClient() {
//		return WebClient.builder()
//				.baseUrl("http://employee-service")
//				.filter(filterFunction)
//				.build();
		HttpClient httpClient = HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
	    return WebClient.builder()
	            .clientConnector(new ReactorClientHttpConnector(httpClient));
	}
//	@Bean
//	public EmployeeClient getEmployeeClient() {
//		
//		HttpServiceProxyFactory httpserviceproxyfactory 
//		= HttpServiceProxyFactory.builderFor(WebClientAdapter.create(employeeWebClient())).build();
//
//		return  httpserviceproxyfactory.createClient(EmployeeClient.class);
//	}

}
