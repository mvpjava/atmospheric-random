package com.mvpjava.random.json.request;

public final class HttpParams {
	private final String apiKey;
	private final int n;
	private final int min;
	private final int max;
	private final boolean replacement;
	private final int base;

	public HttpParams(String apiKey,int n,int min,int max,boolean replacement,int base)
	{
		this.apiKey = apiKey;
		this.n = n;
		this.min = min;
		this.max = max;
		this.replacement = replacement;
		this.base = base;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apiKey == null) ? 0 : apiKey.hashCode());
		result = prime * result + base;
		result = prime * result + max;
		result = prime * result + min;
		result = prime * result + n;
		result = prime * result + (replacement ? 1231 : 1237);
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
		HttpParams other = (HttpParams) obj;
		if (apiKey == null) {
			if (other.apiKey != null)
				return false;
		} else if (!apiKey.equals(other.apiKey))
			return false;
		if (base != other.base)
			return false;
		if (max != other.max)
			return false;
		if (min != other.min)
			return false;
		if (n != other.n)
			return false;
		if (replacement != other.replacement)
			return false;
		return true;
	}

	public String getApiKey() {
		return apiKey;
	}

	public int getN() {
		return n;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	public boolean isReplacement() {
		return replacement;
	}

	public int getBase() {
		return base;
	}

}
