/*
 * Copyright (C) 2017 GedMarc
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
package za.co.mmagon.jwebswing.components.bootstrap.cards;

import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.Link;

/**
 * In the same way, links are added and placed next to each other by adding .card-link to an a tag.
 *
 * @author GedMarc
 * @since 01 Jan 2017
 * @version 1.0
 *
 */
public class BSCardLink extends Link
{

    private static final long serialVersionUID = 1L;

    /**
     * In the same way, links are added and placed next to each other by adding .card-link to a &lt;a&gt; tag.
     */
    public BSCardLink()
    {
        addClass(BSComponentCardOptions.Card_Link);
    }

    /**
     * In the same way, links are added and placed next to each other by adding .card-link to a &lt;a&gt; tag.
     *
     * @param directToAddress
     */
    public BSCardLink(String directToAddress)
    {
        super(directToAddress);
        addClass(BSComponentCardOptions.Card_Link);
    }

    /**
     * In the same way, links are added and placed next to each other by adding .card-link to a &lt;a&gt; tag.
     *
     * @param directToAddress
     * @param targetFrameName
     */
    public BSCardLink(String directToAddress, String targetFrameName)
    {
        super(directToAddress, targetFrameName);
        addClass(BSComponentCardOptions.Card_Link);
    }

    /**
     * In the same way, links are added and placed next to each other by adding .card-link to a &lt;a&gt; tag.
     *
     * @param directToAddress
     * @param targetFrameName
     * @param text
     */
    public BSCardLink(String directToAddress, String targetFrameName, String text)
    {
        super(directToAddress, targetFrameName, text);
        addClass(BSComponentCardOptions.Card_Link);
    }

    /**
     * In the same way, links are added and placed next to each other by adding .card-link to a &lt;a&gt; tag.
     *
     * @param directToAddress
     * @param targetFrameName
     * @param component
     */
    public BSCardLink(String directToAddress, String targetFrameName, ComponentHierarchyBase component)
    {
        super(directToAddress, targetFrameName, component);
        addClass(BSComponentCardOptions.Card_Link);
    }

}
