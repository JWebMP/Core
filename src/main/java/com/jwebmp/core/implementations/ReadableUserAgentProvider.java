package com.jwebmp.core.implementations;

import com.google.inject.OutOfScopeException;
import com.google.inject.Provider;
import com.google.inject.ProvisionException;
import com.guicedee.guicedinjection.GuiceContext;
import jakarta.servlet.http.HttpServletRequest;
import net.sf.uadetector.*;

import static com.guicedee.guicedinjection.json.StaticStrings.STRING_EMPTY;

public class ReadableUserAgentProvider implements Provider<ReadableUserAgent> {
    @Override
    public ReadableUserAgent get() {
        try {
            HttpServletRequest request = GuiceContext.get(HttpServletRequest.class);
            String headerInformation = request.getHeader("User-Agent");
            ReadableUserAgent agent = GuiceContext.inject()
                    .getInstance(UserAgentStringParser.class)
                    .parse(headerInformation);
            return agent;
        } catch (ProvisionException | OutOfScopeException e) {
            return new UserAgent(DeviceCategory.EMPTY, UserAgentFamily.FIREFOX, STRING_EMPTY, STRING_EMPTY, OperatingSystem.EMPTY,
                    STRING_EMPTY, STRING_EMPTY,
                    UserAgentType.BROWSER, STRING_EMPTY, STRING_EMPTY, VersionNumber.UNKNOWN);
        }
    }
}
