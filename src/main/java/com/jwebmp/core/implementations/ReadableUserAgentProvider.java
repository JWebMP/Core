package com.jwebmp.core.implementations;

import com.google.inject.Provider;
import com.guicedee.guicedinjection.GuiceContext;
import jakarta.servlet.http.HttpServletRequest;
import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;

public class ReadableUserAgentProvider implements Provider<ReadableUserAgent>
{
	@Override
	public ReadableUserAgent get()
	{
		HttpServletRequest request = GuiceContext.get(HttpServletRequest.class);
		String headerInformation = request.getHeader("User-Agent");
		ReadableUserAgent agent = GuiceContext.inject()
		                                      .getInstance(UserAgentStringParser.class)
		                                      .parse(headerInformation);
		return agent;
	}
}
