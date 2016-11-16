/*
 * Copyright (C) 2015 GedMarc
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
package za.co.mmagon.jwebswing.components.jqxWidgets.docking;

/**
 * This Class list the cookie options for the docing options
 *
 * @author GedMarc
 * @since 14 Dec 2015
 */
public class JQXCookieOptions
{

    private String domain;
    private Integer expires;

    public JQXCookieOptions()
    {
    }

    @Override
    public String toString()
    {
        return super.toString();
    }

    public String getDomain()
    {
        return domain;
    }

    public void setDomain(String domain)
    {
        this.domain = domain;
    }

    public Integer getExpires()
    {
        return expires;
    }

    public void setExpires(Integer expires)
    {
        this.expires = expires;
    }

}
