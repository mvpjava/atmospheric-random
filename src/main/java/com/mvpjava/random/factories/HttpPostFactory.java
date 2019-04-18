package com.mvpjava.random.factories;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import com.mvpjava.random.RandomMapper;
import com.mvpjava.random.json.request.HttpParams;
import com.mvpjava.random.json.request.RadomRequest;


public class HttpPostFactory {

	private final AtomicInteger idGenerator;
	private final String apiKey;
	private final String jsonRpcVersion;
	private final String uri;
	private final RandomMapper mapper;
	
	public static final int DEFAULT_NUM_OF_RANDOMS = 1; 
	public static final int DEFAULT_MIN_RANDOM_RANGE = 1; 
	public static final int DEFAULT_MAX_RANDOM_RANGE = 1000; 
	public static final boolean DEFAULT_UNIQUE_VALUES = true; /* known as repeatable */
	public static final int DEFAULT_BASE = 10; 
	
	public HttpPostFactory(AtomicInteger idGenerator, String apiKey, String uri, String jsonRpcVersion, RandomMapper mapper) {
		this.idGenerator = idGenerator;
		this.apiKey = apiKey;
		this.jsonRpcVersion = jsonRpcVersion;
		this.uri = uri;
		this.mapper = mapper;
	}
	
	public HttpPost newHttpPostRequest() {
		return createHttpPostRequest(newIntegersRandomRequest()) ;
	}

	public HttpPost newHttpPostRequest(int numberOfIntegers, int minimumValue, int maximumValue) {
		RadomRequest randomRequest = newIntegersRandomRequest(numberOfIntegers, minimumValue, maximumValue);
		return createHttpPostRequest(randomRequest) ;
	}	
	
	public HttpPost newHttpPostRequest(int numberOfIntegers, int minimumValue, int maximumValue, boolean replacement, int base) {
		RadomRequest randomRequest = newIntegersRandomRequest(numberOfIntegers, minimumValue, maximumValue, replacement, base);
		return createHttpPostRequest(randomRequest) ;
	}	
	
	protected RadomRequest newIntegersRandomRequest() {
		return newIntegersRandomRequest 
				(DEFAULT_NUM_OF_RANDOMS, DEFAULT_MIN_RANDOM_RANGE, DEFAULT_MAX_RANDOM_RANGE, DEFAULT_UNIQUE_VALUES, DEFAULT_BASE);
	}	
	
	protected RadomRequest newIntegersRandomRequest(int numberOfIntegers, int minimumValue, int maximumValue) {
		return newIntegersRandomRequest (numberOfIntegers, minimumValue, maximumValue, true, 10);
	}
	
	protected RadomRequest newIntegersRandomRequest(int numberOfIntegers, int minimumValue, int maximumValue, boolean replacement, int base) {
		HttpParams httpParams = new HttpParams (apiKey, numberOfIntegers, minimumValue, maximumValue, replacement, base);
		RadomRequest randomRequest = new RadomRequest(getNextId(), jsonRpcVersion, "generateIntegers", httpParams);
		return randomRequest;
	}
	
	private HttpPost createHttpPostRequest (final RadomRequest randomRequest) {
		String randomRequestAsString = 	mapper.objectToString(randomRequest);
		HttpPost httpPost = new HttpPost(uri);
		httpPost.setEntity(new StringEntity(randomRequestAsString, ContentType.APPLICATION_JSON));
		return httpPost;
	}
	
	private int getNextId() {
		return idGenerator.getAndIncrement();
	}


}
