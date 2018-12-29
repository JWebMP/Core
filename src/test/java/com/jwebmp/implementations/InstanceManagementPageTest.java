package com.jwebmp.implementations;

import com.jwebmp.BaseTestClass;
import com.jwebmp.core.Page;
import com.jwebmp.core.plugins.jquery.JQueryPageConfigurator;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.guicedinjection.interfaces.IDefaultService;
import com.jwebmp.testing.BaseTest;
import com.jwebmp.testing.services.ITestInstanceDestroyService;
import com.jwebmp.testing.services.ITestInstanceInitializerService;
import com.jwebmp.testing.services.ITestInstanceResetService;

import static com.jwebmp.core.base.servlets.enumarations.DevelopmentEnvironments.*;

public class InstanceManagementPageTest
		implements ITestInstanceResetService, ITestInstanceDestroyService, ITestInstanceInitializerService,
				           IDefaultService<InstanceManagementPageTest>
{
	@Override
	public void reset(BaseTest testInstance)
	{
		destroy(testInstance);
		initialize(testInstance);
	}

	@Override
	public void destroy(BaseTest testInstance)
	{
		JQueryPageConfigurator.setEnabled(false);
		JQueryPageConfigurator.setRequired(false);
		if (BaseTestClass.class.isAssignableFrom(testInstance.getClass()))
		{
			BaseTestClass.class.cast(testInstance)
			                   .getInstance()
			                   .destroy();
		}
		GuiceContext.destroy();
	}

	@Override
	public void initialize(BaseTest testInstance)
	{
		JQueryPageConfigurator.setEnabled(false);
		JQueryPageConfigurator.setRequired(false);
		GuiceContext.inject();
		if (BaseTestClass.class.isAssignableFrom(testInstance.getClass()))
		{
			BaseTestClass.class.cast(testInstance)
			                   .setInstance(new Page<>());

			BaseTestClass.class.cast(testInstance)
			                   .getInstance()
			                   .setTiny(false)
			                   .setRunningEnvironment(Development);
		}
	}

	@Override
	public Integer sortOrder()
	{
		return Integer.MIN_VALUE + 1000;
	}
}
