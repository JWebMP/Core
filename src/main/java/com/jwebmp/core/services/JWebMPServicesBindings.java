package com.jwebmp.core.services;

import com.google.inject.Key;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.jwebmp.core.base.angular.services.*;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.guicedinjection.abstractions.GuiceInjectorModule;
import com.jwebmp.guicedinjection.interfaces.IGuiceDefaultBinder;

import java.util.ServiceLoader;
import java.util.Set;

@SuppressWarnings("Convert2Diamond")
public class JWebMPServicesBindings
		implements IGuiceDefaultBinder<JWebMPServicesBindings, GuiceInjectorModule>
{
	public static final Key<Set<IPageConfigurator>> IPageConfiguratorsKey = Key.get(new TypeLiteral<Set<IPageConfigurator>>() {});
	public static final Key<Set<RenderAfterScripts>> RenderAfterScriptsKey = Key.get(new TypeLiteral<Set<RenderAfterScripts>>() {});
	public static final Key<Set<RenderAfterDynamicScripts>> RenderAfterDynamicScriptsKey = Key.get(new TypeLiteral<Set<RenderAfterDynamicScripts>>() {});
	public static final Key<Set<RenderBeforeScripts>> RenderBeforeScriptsKey = Key.get(new TypeLiteral<Set<RenderBeforeScripts>>() {});
	public static final Key<Set<RenderBeforeDynamicScripts>> RenderBeforeDynamicScriptsKey = Key.get(new TypeLiteral<Set<RenderBeforeDynamicScripts>>() {});
	public static final Key<Set<RenderBeforeLinks>> RenderBeforeLinksKey = Key.get(new TypeLiteral<Set<RenderBeforeLinks>>() {});
	public static final Key<Set<RenderAfterLinks>> RenderAfterLinksKey = Key.get(new TypeLiteral<Set<RenderAfterLinks>>() {});

	public static final Key<Set<IAngularDirective>> AngularDirectivesKey = Key.get(new TypeLiteral<Set<IAngularDirective>>() {});
	public static final Key<Set<IAngularControllerScopeStatement>> AngularControllerScopeStatementsKey = Key.get(new TypeLiteral<Set<IAngularControllerScopeStatement>>() {});
	public static final Key<Set<IAngularModule>> AngularModulesKey = Key.get(new TypeLiteral<Set<IAngularModule>>() {});
	public static final Key<Set<IAngularConfigurationScopeStatement>> AngularConfigurationScopeStatementKey = Key.get(
			new TypeLiteral<Set<IAngularConfigurationScopeStatement>>() {});
	public static final Key<Set<IAngularConfiguration>> AngularConfigurationKey = Key.get(new TypeLiteral<Set<IAngularConfiguration>>() {});
	public static final Key<Set<IAngularController>> AngularControllerKey = Key.get(new TypeLiteral<Set<IAngularController>>() {});
	public static final Key<Set<IAngularFactory>> AngularFactoryKey = Key.get(new TypeLiteral<Set<IAngularFactory>>() {});

	@Override
	public void onBind(GuiceInjectorModule module)
	{
		module.bind(JWebMPServicesBindings.IPageConfiguratorsKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(IPageConfigurator.class, ServiceLoader.load(IPageConfigurator.class)))
		      .in(Singleton.class);
		module.bind(JWebMPServicesBindings.RenderAfterScriptsKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(RenderAfterScripts.class, ServiceLoader.load(RenderAfterScripts.class)))
		      .in(Singleton.class);
		module.bind(JWebMPServicesBindings.RenderAfterDynamicScriptsKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(RenderAfterDynamicScripts.class, ServiceLoader.load(RenderAfterDynamicScripts.class)))
		      .in(Singleton.class);
		module.bind(JWebMPServicesBindings.RenderBeforeScriptsKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(RenderBeforeScripts.class, ServiceLoader.load(RenderBeforeScripts.class)))
		      .in(Singleton.class);
		module.bind(JWebMPServicesBindings.RenderBeforeDynamicScriptsKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(RenderBeforeDynamicScripts.class, ServiceLoader.load(RenderBeforeDynamicScripts.class)))
		      .in(Singleton.class);
		module.bind(JWebMPServicesBindings.RenderBeforeLinksKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(RenderBeforeLinks.class, ServiceLoader.load(RenderBeforeLinks.class)))
		      .in(Singleton.class);
		module.bind(JWebMPServicesBindings.RenderAfterLinksKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(RenderAfterLinks.class, ServiceLoader.load(RenderAfterLinks.class)))
		      .in(Singleton.class);

		module.bind(JWebMPServicesBindings.AngularDirectivesKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(IAngularDirective.class, ServiceLoader.load(IAngularDirective.class)))
		      .in(Singleton.class);
		module.bind(JWebMPServicesBindings.AngularControllerScopeStatementsKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(IAngularControllerScopeStatement.class, ServiceLoader.load(IAngularControllerScopeStatement.class)))
		      .in(Singleton.class);
		module.bind(JWebMPServicesBindings.AngularModulesKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(IAngularModule.class, ServiceLoader.load(IAngularModule.class)))
		      .in(Singleton.class);
		module.bind(JWebMPServicesBindings.AngularConfigurationScopeStatementKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(IAngularConfigurationScopeStatement.class, ServiceLoader.load(IAngularConfigurationScopeStatement.class)))
		      .in(Singleton.class);
		module.bind(JWebMPServicesBindings.AngularConfigurationKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(IAngularConfiguration.class, ServiceLoader.load(IAngularConfiguration.class)))
		      .in(Singleton.class);
		module.bind(JWebMPServicesBindings.AngularControllerKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(IAngularController.class, ServiceLoader.load(IAngularController.class)))
		      .in(Singleton.class);
		module.bind(JWebMPServicesBindings.AngularFactoryKey)
		      .toProvider(() -> GuiceContext.instance()
		                                    .getLoader(IAngularFactory.class, ServiceLoader.load(IAngularFactory.class)))
		      .in(Singleton.class);
	}
}
