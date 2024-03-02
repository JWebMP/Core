package com.jwebmp.core.implementations;

import com.google.common.base.*;
import com.google.inject.*;
import com.guicedee.client.*;
import com.jwebmp.core.base.ajax.*;
import jakarta.servlet.http.*;
import net.sf.uadetector.*;

import static com.guicedee.services.jsonrepresentation.json.StaticStrings.STRING_EMPTY;

public class ReadableUserAgentProvider implements Provider<ReadableUserAgent>
{
	
	@Inject
	private UserAgentStringParser userAgentStringParser;
	
	@Override
	public ReadableUserAgent get()
	{
		try
		{
			HttpServletRequest request = IGuiceContext.get(HttpServletRequest.class);
			String headerInformation = request.getHeader("User-Agent");
			if (!Strings.isNullOrEmpty(headerInformation))
			{
				ReadableUserAgent agent = userAgentStringParser.parse(headerInformation);
				return agent;
			}
			return defaultAgent();
		}
		catch (ProvisionException | OutOfScopeException e)
		{
			try
			{
				AjaxCall<?> call = IGuiceContext.get(AjaxCall.class);
				HeadersDTO headers = call.getHeaders();
				if (!Strings.isNullOrEmpty(headers.useragent))
				{
					ReadableUserAgent agent = userAgentStringParser.parse(headers.useragent);
					return agent;
				}
			}
			catch (Throwable T)
			{
				return defaultAgent();
			}
			return defaultAgent();
		}
	}
	
	
	
	public static ReadableUserAgent defaultAgent()
	{
		return new UserAgent(DeviceCategory.EMPTY, UserAgentFamily.FIREFOX, STRING_EMPTY, STRING_EMPTY, OperatingSystem.EMPTY,
				STRING_EMPTY, STRING_EMPTY,
				UserAgentType.BROWSER, STRING_EMPTY, STRING_EMPTY, VersionNumber.UNKNOWN);
	}
}
