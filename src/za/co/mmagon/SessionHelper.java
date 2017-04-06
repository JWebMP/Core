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
package za.co.mmagon;

import com.armineasy.injection.GuiceContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Marc Magon
 * @since 05 Apr 2017
 */
public class SessionHelper
{

    /*
     * Constructs a new SessionHelper
     */
    private SessionHelper()
    {
        //Nothing needed
    }

    /**
     * Returns the full server address, without the final section
     *
     * @return
     */
    public static String getServerPath()
    {
        if (!GuiceContext.isBuildingInjector())
        {
            HttpServletRequest request = GuiceContext.inject().getInstance(HttpServletRequest.class);
            StringBuffer buff = request.getRequestURL();
            String address = buff.substring(0, buff.lastIndexOf("/") + 1);
            return address;
        }
        return "";
    }

    /**
     * Returns the last section of the url, to be matched with page configurator url
     *
     * @return
     */
    public static String getServletUrl()
    {
        if (!GuiceContext.isBuildingInjector())
        {
            HttpServletRequest request = GuiceContext.inject().getInstance(HttpServletRequest.class);
            String buff = request.getServletPath();
            return buff.isEmpty() ? "/" : buff;
        }
        return "/";
    }
}
