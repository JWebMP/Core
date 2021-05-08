package com.jwebmp.core.implementations;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.OutOfScopeException;
import com.google.inject.Provider;
import com.google.inject.ProvisionException;
import com.guicedee.guicedinjection.GuiceContext;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.HeadersDTO;
import jakarta.servlet.http.HttpServletRequest;
import net.sf.uadetector.*;

import static com.guicedee.guicedinjection.json.StaticStrings.STRING_EMPTY;

public class ReadableUserAgentProvider implements Provider<ReadableUserAgent> {

    @Inject
    private UserAgentStringParser userAgentStringParser;

    @Override
    public ReadableUserAgent get() {
        try {
            HttpServletRequest request = GuiceContext.get(HttpServletRequest.class);
            String headerInformation = request.getHeader("User-Agent");
            if (!Strings.isNullOrEmpty(headerInformation)) {
                ReadableUserAgent agent = userAgentStringParser.parse(headerInformation);
                return agent;
            }
            return defaultAgent();
        } catch (ProvisionException | OutOfScopeException e) {
            try
            {
                AjaxCall<?> call = GuiceContext.get(AjaxCall.class);
                HeadersDTO headers = call.getVariable("headers")
                                         .as(HeadersDTO.class);
                if (!Strings.isNullOrEmpty(headers.useragent))
                {
                    ReadableUserAgent agent = userAgentStringParser.parse(headers.useragent);
                    return agent;
                }
            }catch (Throwable T)
            {
                return defaultAgent();
            }
            return defaultAgent();
        }
    }

    private ReadableUserAgent defaultAgent() {
        return new UserAgent(DeviceCategory.EMPTY, UserAgentFamily.FIREFOX, STRING_EMPTY, STRING_EMPTY, OperatingSystem.EMPTY,
                STRING_EMPTY, STRING_EMPTY,
                UserAgentType.BROWSER, STRING_EMPTY, STRING_EMPTY, VersionNumber.UNKNOWN);
    }
}
