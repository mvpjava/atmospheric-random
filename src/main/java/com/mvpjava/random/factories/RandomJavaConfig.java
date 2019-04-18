package com.mvpjava.random.factories;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mvpjava.random.Application;
import com.mvpjava.random.AtmosphericRandom;
import com.mvpjava.random.RandomMapper;

@Configuration
public class RandomJavaConfig {
	
	public @Value("${uri}")     String uri;
	public @Value("${apiKey}")  String apiKey;
	public @Value("${jsonrpc}") String jsonrpc;

	@Bean
	public Application application() {
		return new Application(atmosphericRandom());
	}
	
	@Bean
	public AtmosphericRandom atmosphericRandom() {
		return new AtmosphericRandom(closeableHttpClient(), httpPostFactory(), randomMapper());
	}
	/**********************************************************************************************/
	/****************************************** PRIVATE	 ******************************************/
	/**********************************************************************************************/
	
	private CloseableHttpClient closeableHttpClient() {
		// Spring will automatically Invoke destroy method 'close' since it
		// knows bean implements Closeable Interface. No need for boiler plate destroyMethod="close"
		return HttpClients.createDefault();
	}

	private HttpPostFactory httpPostFactory() {
		return new HttpPostFactory(new AtomicInteger(), apiKey, uri, jsonrpc, randomMapper());
	}
	
	private RandomMapper randomMapper() {
		return new RandomMapper();
	}

}