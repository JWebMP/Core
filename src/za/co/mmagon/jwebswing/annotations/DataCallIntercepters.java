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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.aopalliance.intercept.MethodInvocation;
import za.co.mmagon.jwebswing.interception.DataCallIntercepter;
import za.co.mmagon.logger.LogFactory;

/**
 *
 * @author Marc Magon
 * @since 05 Apr 2017
 */
public class DataCallIntercepters implements org.aopalliance.intercept.MethodInterceptor
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
        LOG.fine("Intercepting Data Calls");
        GuiceContext.reflect().getSubTypesOf(DataCallIntercepter.class).forEach(siClass ->
        {
            DataCallIntercepter si = GuiceContext.inject().getInstance(siClass);
            LOG.log(Level.FINE, "Interception Occuring : {0}", siClass.getCanonicalName());
            si.intercept();
        });
        LOG.fine("Interception of Data Calls complete");
        return invocation.proceed();
    }

}
