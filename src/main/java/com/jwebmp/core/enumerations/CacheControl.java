package com.jwebmp.core.enumerations;

public enum CacheControl
{
	/**
	 * Public - may be cached in public shared caches.
	 */
	PUBLIC,
	/**
	 * may only be cached in private cache
	 */
	PRIVATE,
	/**
	 * may not be cached
	 */
	NO_CACHE,
	/**
	 * may be cached but not archived
	 */
	NO_STORE;

	@Override
	public String toString()
	{
		return super.toString()
		            .replace('_', '-');
	}
}
