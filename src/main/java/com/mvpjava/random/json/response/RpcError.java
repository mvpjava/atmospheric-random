package com.mvpjava.random.json.response;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public final class RpcError {
	private final int code;
	private final String message;
	private final String [] data;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public RpcError(@JsonProperty("code") int code,
					@JsonProperty("message") String message,
					@JsonProperty("data") String[] data )
	{
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String[] getData() {
		return data;
	}
	
	String getDataAsString () {
		return Arrays.toString(getData());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		result = prime * result + Arrays.hashCode(data);
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RpcError other = (RpcError) obj;
		if (code != other.code)
			return false;
		if (!Arrays.equals(data, other.data))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RpcError [code=" + code + ", message=" + message + ", data=" + Arrays.toString(data) + "]";
	}


	
}
