package com.mvpjava.random.json.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/* Modeled after following response from response.org
{
	  "jsonrpc" : "2.0",
	  "result" : {
	    "random" : {
	      "data" : [ 92 ],
	      "completionTime" : "2019-04-06 10:17:35Z"
	    },
	    "bitsUsed" : 7,
	    "bitsLeft" : 249799,
	    "requestsLeft" : 988,
	    "advisoryDelay" : 1140
	  },
	  "id" : 1
}
*/
public final class RandomResponse {
	private final String jsonrpc;
	private final RadomResult result;
	private RpcError error;
	private final int id;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public RandomResponse(  @JsonProperty("jsonrpc") String jsonrpc, 
							@JsonProperty("result") RadomResult result,
							@JsonProperty("id") int id) 
	{
		this.jsonrpc = jsonrpc;
		this.result = result;
		this.id = id;
	}

	public String getJsonrpc() {
		return jsonrpc;
	}

	public int getId() {
		return id;
	}

	public RadomResult getResult() {
		return result;
	}

	@JsonIgnore
	public int[] getRandomData() {
		RadomResult result = getResult();
		if (result == null) {
			System.out.printf("!!!! An error occurred %s ... returning an empty value !!!!\n", getError().getDataAsString());
			int[] emptyArray = new int[]{};
			return emptyArray;
		}
		RandomData randomData = result.getRandom();
		return randomData.getData();
	}

	public RpcError getError() {
		return error;
	}

	/*
	 * public void setError(RpcError error) { this.error = error; }
	 */

}
