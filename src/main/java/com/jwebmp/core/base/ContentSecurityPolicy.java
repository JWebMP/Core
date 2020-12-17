package com.jwebmp.core.base;

import com.google.common.base.Strings;
import com.google.inject.servlet.RequestScoped;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.interfaces.IContentSecurityPolicy;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import static com.guicedee.guicedinjection.json.StaticStrings.STRING_SPACE;
import static com.jwebmp.core.base.html.attributes.MetaAttributes.*;
import static com.jwebmp.core.base.servlets.enumarations.ComponentTypes.*;

@RequestScoped
public class ContentSecurityPolicy<J extends ContentSecurityPolicy<J>>
        extends DivSimple<J> implements IContentSecurityPolicy<J>,
                                        com.jwebmp.core.base.html.interfaces.children.HeadChildren
{
    private static final String httpEquivName = "Content-Security-Policy";
    public static final String self = "'self'";
    public static final String dataRegister = "data:";
    public static final String unsafeEval = "unsafe-eval";
    public static final String unsafeInline = "'unsafe-inline'";

    private final Set<String> defaultSrc = new TreeSet<>();
    private final Set<String> scriptSrc = new TreeSet<>();
    private final Set<String> styleSrc = new TreeSet<>();
    private final Set<String> imgSrc = new TreeSet<>();
    private final Set<String> connectSrc = new TreeSet<>();
    private final Set<String> fontSrc = new TreeSet<>();
    private final Set<String> objectSrc = new TreeSet<>();
    private final Set<String> mediaSrc = new TreeSet<>();
    private final Set<String> frameSrc = new TreeSet<>();
    private final Set<String> sandbox = new TreeSet<>();
    private final Set<String> reportUi = new TreeSet<>();
    private final Set<String> childSrc = new TreeSet<>();
    private final Set<String> formAction = new TreeSet<>();
    private final Set<String> frameAncestors = new TreeSet<>();
    private final Set<String> pluginTypes = new TreeSet<>();

    public ContentSecurityPolicy()
    {
        setTag(Metadata);
        addAttribute(Http_Equiv.toString(), httpEquivName);
    }

    @Override
    public void preConfigure()
    {
        if (!isConfigured())
        {
			StringBuilder output = new StringBuilder();
            if (!defaultSrc.isEmpty())
            {
				output.append("default-src ").append(setToList(defaultSrc)).append( "; ");
            }
			if (!scriptSrc.isEmpty())
			{
				output.append("script-src ").append(setToList(scriptSrc)).append(" ; ");
			}
			if (!styleSrc.isEmpty())
			{
				output.append("style-src ").append(setToList(styleSrc)).append(" ; ");
			}
			if (!imgSrc.isEmpty())
			{
				output.append("img-src ").append(setToList(imgSrc)).append(" ; ");
			}
			if (!connectSrc.isEmpty())
			{
				output.append("connect-src ").append(setToList(connectSrc)).append(" ; ");
			}
			if (!fontSrc.isEmpty())
			{
				output.append("font-src ").append(setToList(fontSrc)).append(" ; ");
			}
			if (!objectSrc.isEmpty())
			{
				output.append("object-src ").append(setToList(objectSrc)).append(" ; ");
			}
			if (!mediaSrc.isEmpty())
			{
				output.append("media-src ").append(setToList(mediaSrc)).append(" ; ");
			}
			if (!frameSrc.isEmpty())
			{
				output.append("frame-src ").append(setToList(frameSrc)).append(" ; ");
			}
			if (!childSrc.isEmpty())
			{
				output.append("child-src ").append(setToList(childSrc)).append(" ; ");
			}
			if(!Strings.isNullOrEmpty(output.toString()))
			    addAttribute("content", output.toString());
            super.preConfigure();
        }
    }

    public StringBuilder setToList(Set<String> set)
	{
		StringBuilder output = new StringBuilder();
        set.forEach(s -> output.append(s).append(STRING_SPACE));
		output.deleteCharAt(output.length() - 1);
		return output;
	}

    @Override
    @SuppressWarnings("unchecked")
    public J registerSelf()
    {
        defaultSrc.add(self);
        scriptSrc.add(self);
        scriptSrc.add(unsafeInline);
        styleSrc.add(self);
        styleSrc.add(unsafeInline);
        imgSrc.add(self);
        imgSrc.add(dataRegister);
        connectSrc.add(self);
        fontSrc.add(self);
        objectSrc.add(self);
        mediaSrc.add(self);
        frameSrc.add(self);
        childSrc.add(self);
        return (J) this;
    }

    public IContentSecurityPolicy<?> asMe()
    {
        return this;
    }

    @Override
    public Set<String> getDefaultSrc()
    {
        return defaultSrc;
    }

    @Override
    public Set<String> getScriptSrc()
    {
        return scriptSrc;
    }

    @Override
    public Set<String> getStyleSrc()
    {
        return styleSrc;
    }

    @Override
    public Set<String> getImgSrc()
    {
        return imgSrc;
    }

    @Override
    public Set<String> getConnectSrc()
    {
        return connectSrc;
    }

    @Override
    public Set<String> getFontSrc()
    {
        return fontSrc;
    }

    @Override
    public Set<String> getObjectSrc()
    {
        return objectSrc;
    }

    @Override
    public Set<String> getMediaSrc()
    {
        return mediaSrc;
    }

    @Override
    public Set<String> getFrameSrc()
    {
        return frameSrc;
    }

    @Override
    public Set<String> getSandbox()
    {
        return sandbox;
    }

    @Override
    public Set<String> getReportUi()
    {
        return reportUi;
    }

    @Override
    public Set<String> getChildSrc()
    {
        return childSrc;
    }

    @Override
    public Set<String> getFormAction()
    {
        return formAction;
    }

    @Override
    public Set<String> getFrameAncestors()
    {
        return frameAncestors;
    }

    public Set<String> getPluginTypes()
    {
        return pluginTypes;
    }


}
