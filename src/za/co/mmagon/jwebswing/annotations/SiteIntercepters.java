/*
 * Copyright (C) 2017 Marc Magon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package za.co.mmagon.jwebswing.annotations;

import com.armineasy.injection.GuiceContext;
import org.aopalliance.intercept.MethodInvocation;
import za.co.mmagon.jwebswing.interception.DefaultIntercepter;
import za.co.mmagon.jwebswing.interception.SiteCallInterceptor;
import za.co.mmagon.logger.LogFactory;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Marc Magon
 * @since 05 Apr 2017
 */
class SiteIntercepters implements org.aopalliance.intercept.MethodInterceptor
{

	private static final Logger LOG = LogFactory.getLog(SiteIntercepters.class.getName());

	/*
	 * Constructs a new SiteIntercepters
	 */
	public SiteIntercepters()
	{
		//Nothing needed
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable
	{

		LOG.finer("Intercepting Site Call");
		Set<Class<? extends SiteCallInterceptor>> res = GuiceContext.reflect().getSubTypesOf(SiteCallInterceptor.class);
		List<SiteCallInterceptor> outs = new ArrayList<>();
		for (Class<? extends SiteCallInterceptor> re : res)
		{
			if (re.isInterface())
			{
				continue;
			}
			SiteCallInterceptor intercepter = re.newInstance();
			GuiceContext.inject().injectMembers(intercepter);
			outs.add(intercepter);
		}
		Collections.sort(outs, Comparator.comparing(DefaultIntercepter::sortOrder));
		for (SiteCallInterceptor out : outs)
		{
			LOG.log(Level.FINE, "Interception Occuring : {0}", out.getClass().getCanonicalName());
			out.intercept();
		}
		LOG.finer("Interception of Site Call Complete");
		return invocation.proceed();
	}

}
