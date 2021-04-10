package com.jwebmp.core.base.ajax;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HeadersDTO
{
    public String useragent;
    public String referer;
    public String myIP;

    public String getUseragent() {
        return useragent;
    }

    public HeadersDTO setUseragent(String useragent) {
        this.useragent = useragent;
        return this;
    }

    public String getReferer() {
        return referer;
    }

    public HeadersDTO setReferer(String referer) {
        this.referer = referer;
        return this;
    }

    public String getMyIP() {
        return myIP;
    }

    public HeadersDTO setMyIP(String myIP) {
        this.myIP = myIP;
        return this;
    }
}
