package com.jwebmp.core.services;

import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.guicedinjection.interfaces.IGuiceModule;

import java.util.ServiceLoader;
import java.util.Set;

@SuppressWarnings({"Convert2Diamond", "MissingFieldJavaDoc"})
public class JWebMPServicesBindings
	extends AbstractModule
		implements IGuiceModule<JWebMPServicesBindings>
{
	public static final Key<Set<IPageConfigurator>> IPageConfiguratorsKey = Key.get(new TypeLiteral<Set<IPageConfigurator>>() {});
	public static final Key<Set<RenderAfterScripts>> RenderAfterScriptsKey = Key.get(new TypeLiteral<Set<RenderAfterScripts>>() {});
	public static final Key<Set<RenderAfterDynamicScripts>> RenderAfterDynamicScriptsKey = Key.get(new TypeLiteral<Set<RenderAfterDynamicScripts>>() {});
	public static final Key<Set<RenderBeforeScripts>> RenderBeforeScriptsKey = Key.get(new TypeLiteral<Set<RenderBeforeScripts>>() {});
	public static final Key<Set<RenderBeforeDynamicScripts>> RenderBeforeDynamicScriptsKey = Key.get(new TypeLiteral<Set<RenderBeforeDynamicScripts>>() {});
	public static final Key<Set<RenderBeforeLinks>> RenderBeforeLinksKey = Key.get(new TypeLiteral<Set<RenderBeforeLinks>>() {});
	public static final Key<Set<RenderAfterLinks>> RenderAfterLinksKey = Key.get(new TypeLiteral<Set<RenderAfterLinks>>() {});

	@Override
	public void configure()
	{
		//noinspection unchecked
		bind(JWebMPServicesBindings.IPageConfiguratorsKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(IPageConfigurator.class, ServiceLoader.load(IPageConfigurator.class)))
		      .in(Singleton.class);
		bind(JWebMPServicesBindings.RenderAfterScriptsKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(RenderAfterScripts.class, ServiceLoader.load(RenderAfterScripts.class)))
		      .in(Singleton.class);
		bind(JWebMPServicesBindings.RenderAfterDynamicScriptsKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(RenderAfterDynamicScripts.class, ServiceLoader.load(RenderAfterDynamicScripts.class)))
		      .in(Singleton.class);
		bind(JWebMPServicesBindings.RenderBeforeScriptsKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(RenderBeforeScripts.class, ServiceLoader.load(RenderBeforeScripts.class)))
		      .in(Singleton.class);
		bind(JWebMPServicesBindings.RenderBeforeDynamicScriptsKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(RenderBeforeDynamicScripts.class, ServiceLoader.load(RenderBeforeDynamicScripts.class)))
		      .in(Singleton.class);
		bind(JWebMPServicesBindings.RenderBeforeLinksKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(RenderBeforeLinks.class, ServiceLoader.load(RenderBeforeLinks.class)))
		      .in(Singleton.class);
		bind(JWebMPServicesBindings.RenderAfterLinksKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(RenderAfterLinks.class, ServiceLoader.load(RenderAfterLinks.class)))
		      .in(Singleton.class);
	}
}
