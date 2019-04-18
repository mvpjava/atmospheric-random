package com.mvpjava.random.json.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class RadomResult {
	private final RandomData random;
	private final int bitsUsed;
	private final int bitsLeft;
	private final int requestsLeft;
	private final int advisoryDelay;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public RadomResult(@JsonProperty("random") RandomData random,
						@JsonProperty("bitsUsed") int bitsUsed,
						@JsonProperty("bitsLeft") int bitsLeft,
						@JsonProperty("requestsLeft") int requestsLeft,
						@JsonProperty("advisoryDelay") int advisoryDelay) 
	{
		this.random = random;
		this.bitsUsed = bitsUsed;
		this.bitsLeft = bitsLeft;
		this.requestsLeft = requestsLeft;
		this.advisoryDelay = advisoryDelay;
	}

	public RandomData getRandom() {
		return random;
	}

	public int getBitsUsed() {
		return bitsUsed;
	}

	public int getBitsLeft() {
		return bitsLeft;
	}

	public int getRequestsLeft() {
		return requestsLeft;
	}

	public int getAdvisoryDelay() {
		return advisoryDelay;
	}

	@Override
	public String toString() {
		return "RadomResult [random=" + random + ", bitsUsed=" + bitsUsed + ", bitsLeft=" + bitsLeft + ", requestsLeft="
				+ requestsLeft + ", advisoryDelay=" + advisoryDelay + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + advisoryDelay;
		result = prime * result + bitsLeft;
		result = prime * result + bitsUsed;
		result = prime * result + ((random == null) ? 0 : random.hashCode());
		result = prime * result + requestsLeft;
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
		RadomResult other = (RadomResult) obj;
		if (advisoryDelay != other.advisoryDelay)
			return false;
		if (bitsLeft != other.bitsLeft)
			return false;
		if (bitsUsed != other.bitsUsed)
			return false;
		if (random == null) {
			if (other.random != null)
				return false;
		} else if (!random.equals(other.random))
			return false;
		if (requestsLeft != other.requestsLeft)
			return false;
		return true;
	}

}
