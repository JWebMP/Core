package com.jwebmp.interception;

import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.guicedinjection.interfaces.IGuiceModule;
import com.jwebmp.interception.services.AjaxCallIntercepter;
import com.jwebmp.interception.services.DataCallIntercepter;
import com.jwebmp.interception.services.SiteCallIntercepter;

import java.util.ServiceLoader;
import java.util.Set;

@SuppressWarnings({"Convert2Diamond","unchecked", "rawtypes"})
public class JWebMPInterceptionBinder
	extends AbstractModule
		implements IGuiceModule<JWebMPInterceptionBinder>
{
	public static final Key<Set<AjaxCallIntercepter>> AjaxCallInterceptorKey = Key.get(new TypeLiteral<Set<AjaxCallIntercepter>>() {});
	public static final Key<Set<DataCallIntercepter>> DataCallInterceptorKey = Key.get(new TypeLiteral<Set<DataCallIntercepter>>() {});
	public static final Key<Set<SiteCallIntercepter>> SiteCallInterceptorKey = Key.get(new TypeLiteral<Set<SiteCallIntercepter>>() {});

	@Override
	public void configure()
	{
		bind(JWebMPInterceptionBinder.AjaxCallInterceptorKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(AjaxCallIntercepter.class, ServiceLoader.load(AjaxCallIntercepter.class)))
		      .in(Singleton.class);

		bind(JWebMPInterceptionBinder.DataCallInterceptorKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(DataCallIntercepter.class, ServiceLoader.load(DataCallIntercepter.class)))
		      .in(Singleton.class);

		bind(JWebMPInterceptionBinder.SiteCallInterceptorKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(SiteCallIntercepter.class, ServiceLoader.load(SiteCallIntercepter.class)))
		      .in(Singleton.class);
	}
}
