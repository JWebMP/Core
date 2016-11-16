/*
 * Copyright (C) 2016 ged_m
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
package za.co.mmagon;

import com.google.inject.Singleton;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Caches everything until 2020
 * @author GedMarc
 */
@Singleton
public class CacheControlFilter implements Filter
{
    
    /**
     * Sets the cache control headers 
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException 
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException
    {
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setHeader("Expires", "Tue, 03 Jul 2020 06:00:00 GMT");
        resp.setHeader("Cache-Control", "public, max-age=2546787");

        HttpServletRequest req = (HttpServletRequest) request;
        chain.doFilter(request, response);
    }

    /**
     * Doesn't do much, or anything
     * @param fc
     * @throws ServletException 
     */
    @Override
    public void init(FilterConfig fc) throws ServletException
    {

    }

    
    @Override
    public void destroy()
    {

    }

}
