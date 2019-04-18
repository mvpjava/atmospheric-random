package com.mvpjava.random.json.response;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class RandomData {
	private final int[] data;
	private final String completionTime;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public RandomData(  @JsonProperty("data") int[] data, 
						@JsonProperty("completionTime") String completionTime )
	{
		this.data = data;
		this.completionTime = completionTime;
	}

	public int[] getData() {
		return data;
	}

	public String getCompletionTime() {
		return completionTime;
	}

	@Override
	public String toString() {
		return "RandomData [data=" + Arrays.toString(data) + ", completionTime=" + completionTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((completionTime == null) ? 0 : completionTime.hashCode());
		result = prime * result + Arrays.hashCode(data);
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
		RandomData other = (RandomData) obj;
		if (completionTime == null) {
			if (other.completionTime != null)
				return false;
		} else if (!completionTime.equals(other.completionTime))
			return false;
		if (!Arrays.equals(data, other.data))
			return false;
		return true;
	}

}

