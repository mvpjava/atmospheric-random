package com.mvpjava.random;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvpjava.random.json.response.RandomResponse;

public class RandomMapper extends ObjectMapper {
	private static final long serialVersionUID = 1L;

	public RandomMapper () {
		super();
	}
	
	public RandomResponse mapHttpResponseToRandomResponse(CloseableHttpResponse httpResponse) {
		String jsonResponse = mapHttpEntityToString(httpResponse.getEntity());
		RandomResponse randomResponse = mapStringToObject(jsonResponse, RandomResponse.class);
		objectToString(randomResponse);//just to log out for demo purposes
		return randomResponse;
	}

	public String mapHttpEntityToString(final HttpEntity httpEntity) {
		String jsonStringResponse = null;
		try {
			jsonStringResponse = IOUtils.toString(httpEntity.getContent(), StandardCharsets.UTF_8);
		} catch (UnsupportedOperationException | IOException e) {
			e.printStackTrace();
		}
		return jsonStringResponse;
	}

	private <T> T mapStringToObject(String jsonString, Class<T> clazz) {
		T obj = null;
		try {
			obj = super.readValue(jsonString, clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public String objectToString(Object object) {
		String objAsString = null;
		try {
			objAsString = super.writerWithDefaultPrettyPrinter().writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(objAsString);
		return objAsString;
	}

}
