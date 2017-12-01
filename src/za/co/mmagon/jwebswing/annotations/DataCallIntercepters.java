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
import za.co.mmagon.jwebswing.interception.DataCallIntercepter;
import za.co.mmagon.jwebswing.interception.DefaultIntercepter;
import za.co.mmagon.logger.LogFactory;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Marc Magon
 * @since 05 Apr 2017
 */
class DataCallIntercepters implements org.aopalliance.intercept.MethodInterceptor
{

	private static final Logger LOG = LogFactory.getLog(DataCallIntercepters.class.getName());

	/*
	 * Constructs a new SiteIntercepters
	 */
	public DataCallIntercepters()
	{
		//Nothing needed
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable
	{
		LOG.finer("Intercepting Data Calls");
		Set<Class<? extends DataCallIntercepter>> res = GuiceContext.reflect().getSubTypesOf(DataCallIntercepter.class);
		List<DataCallIntercepter> outs = new ArrayList<>();
		for (Class<? extends DataCallIntercepter> re : res)
		{
			if (re.isInterface())
			{
				continue;
			}
			outs.add(GuiceContext.getInstance(re));
		}
		Collections.sort(outs, Comparator.comparing(DefaultIntercepter::sortOrder));
		for (DataCallIntercepter out : outs)
		{
			LOG.log(Level.FINER, "Interception Occuring : {0}", out.getClass().getCanonicalName());
			GuiceContext.getInstance(out.getClass()).intercept();
		}
		LOG.finer("Interception of Data Calls complete");
		return invocation.proceed();
	}

}
