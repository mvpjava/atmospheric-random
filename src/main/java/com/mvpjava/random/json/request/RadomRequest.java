package com.mvpjava.random.json.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class RadomRequest {
	private String jsonrpc; 
	private String method;
    private int id;
	@JsonProperty(value = "params")	private HttpParams httpParams;

	public RadomRequest(int id, String jsonrpc, String methodName, HttpParams httpParams) {
		this.id = id;
		this.jsonrpc = jsonrpc;
		this.method = methodName;
		this.httpParams = httpParams;
	}

	public String getMethod() {
		return method;
	}

	public int getId() {
		return id;
	}

	public String getJsonrpc() {
		return jsonrpc;
	}

	public HttpParams getHttpParams() {
		return httpParams;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((httpParams == null) ? 0 : httpParams.hashCode());
		result = prime * result + id;
		result = prime * result + ((jsonrpc == null) ? 0 : jsonrpc.hashCode());
		result = prime * result + ((method == null) ? 0 : method.hashCode());
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
		RadomRequest other = (RadomRequest) obj;
		if (httpParams == null) {
			if (other.httpParams != null)
				return false;
		} else if (!httpParams.equals(other.httpParams))
			return false;
		if (id != other.id)
			return false;
		if (jsonrpc == null) {
			if (other.jsonrpc != null)
				return false;
		} else if (!jsonrpc.equals(other.jsonrpc))
			return false;
		if (method == null) {
			if (other.method != null)
				return false;
		} else if (!method.equals(other.method))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RadomRequest [jsonrpc=" + jsonrpc + ", method=" + method + ", id=" + id + ", httpParams=" + httpParams
				+ "]";
	}


}
