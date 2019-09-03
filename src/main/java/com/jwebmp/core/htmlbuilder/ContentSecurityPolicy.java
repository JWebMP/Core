package com.jwebmp.core.htmlbuilder;

import com.google.inject.servlet.RequestScoped;
import com.jwebmp.core.base.html.DivSimple;

import java.util.LinkedHashSet;
import java.util.Set;

import static com.jwebmp.core.base.html.attributes.MetaAttributes.*;
import static com.jwebmp.core.base.servlets.enumarations.ComponentTypes.*;

@RequestScoped
public class ContentSecurityPolicy<J extends ContentSecurityPolicy<J>>
		extends DivSimple<J>
{
	private static final String httpEquivName = "Content-Security-Policy";
	private static final String self = "self";
	private static final String dataRegister = "data:";
	private static final String unsafeEval = "unsafe-eval";

	private final Set<String> defaultSrc = new LinkedHashSet<>();
	private final Set<String> scriptSrc = new LinkedHashSet<>();
	private final Set<String> styleSrc = new LinkedHashSet<>();
	private final Set<String> imgSrc = new LinkedHashSet<>();
	private final Set<String> connectSrc = new LinkedHashSet<>();
	private final Set<String> fontSrc = new LinkedHashSet<>();
	private final Set<String> objectSrc = new LinkedHashSet<>();
	private final Set<String> mediaSrc = new LinkedHashSet<>();
	private final Set<String> frameSrc = new LinkedHashSet<>();
	private final Set<String> sandbox = new LinkedHashSet<>();
	private final Set<String> reportUi = new LinkedHashSet<>();
	private final Set<String> childSrc = new LinkedHashSet<>();
	private final Set<String> formAction = new LinkedHashSet<>();
	private final Set<String> frameAncestors = new LinkedHashSet<>();
	private final Set<String> pluginTyoes = new LinkedHashSet<>();

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

		}
		super.preConfigure();
	}

	@SuppressWarnings("unchecked")
	public J registerSelf()
	{
		defaultSrc.add(self);
		defaultSrc.add(dataRegister);
		scriptSrc.add(self);
		scriptSrc.add(dataRegister);
		scriptSrc.add(unsafeEval);
		styleSrc.add(self);
		styleSrc.add(dataRegister);
		imgSrc.add(self);
		imgSrc.add(dataRegister);
		connectSrc.add(self);
		connectSrc.add(dataRegister);
		fontSrc.add(self);
		fontSrc.add(dataRegister);
		objectSrc.add(self);
		objectSrc.add(dataRegister);
		mediaSrc.add(self);
		mediaSrc.add(dataRegister);
		frameSrc.add(self);
		frameSrc.add(dataRegister);
		childSrc.add(self);
		childSrc.add(dataRegister);
		return (J) this;
	}

	public static String getHttpEquivName()
	{
		return httpEquivName;
	}

	public static String getSelf()
	{
		return self;
	}

	public static String getDataRegister()
	{
		return dataRegister;
	}

	public static String getUnsafeEval()
	{
		return unsafeEval;
	}

	public Set<String> getDefaultSrc()
	{
		return defaultSrc;
	}

	public Set<String> getScriptSrc()
	{
		return scriptSrc;
	}

	public Set<String> getStyleSrc()
	{
		return styleSrc;
	}

	public Set<String> getImgSrc()
	{
		return imgSrc;
	}

	public Set<String> getConnectSrc()
	{
		return connectSrc;
	}

	public Set<String> getFontSrc()
	{
		return fontSrc;
	}

	public Set<String> getObjectSrc()
	{
		return objectSrc;
	}

	public Set<String> getMediaSrc()
	{
		return mediaSrc;
	}

	public Set<String> getFrameSrc()
	{
		return frameSrc;
	}

	public Set<String> getSandbox()
	{
		return sandbox;
	}

	public Set<String> getReportUi()
	{
		return reportUi;
	}

	public Set<String> getChildSrc()
	{
		return childSrc;
	}

	public Set<String> getFormAction()
	{
		return formAction;
	}

	public Set<String> getFrameAncestors()
	{
		return frameAncestors;
	}

	public Set<String> getPluginTyoes()
	{
		return pluginTyoes;
	}
}
