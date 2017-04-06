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

/**
 *
 * @author Marc Magon
 * @since 05 Apr 2017
 */
public class SiteIntercepters implements org.aopalliance.intercept.MethodInterceptor
{

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
        System.out.println("Intercepting Page Call");
        GuiceContext.reflect().getSubTypesOf(SiteIntercepter.class).forEach(siClass ->
        {
            SiteIntercepter si = GuiceContext.inject().getInstance(siClass);
            System.out.println("Interception Occuring : " + siClass.getCanonicalName());
            si.onSiteLoad(invocation);
        });
        System.out.println("Interception complete");
        return invocation.proceed();
    }

}
