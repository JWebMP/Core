/*
 * Copyright (C) 2015 Marc Magon
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
package za.co.mmagon.jwebswing.components.bootstrap.breadcrumbs;

import za.co.mmagon.jwebswing.base.html.List;

/**
 * Breadcrumb
 * <p>
 * Indicate the current page’s location within a navigational hierarchy. Separators are automatically added in CSS through ::before and content.
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class BSBreadcrumbs extends List<BSBreadcrumbsChildren, BSBreadcrumbsAttributes, BSBreadcrumbs>
{

    private static final long serialVersionUID = 1L;
    private BSBreadcrumbsFeature feature;

    /**
     * Breadcrumbs
     * <p>
     * Indicate the current page’s location within a navigational hierarchy. Separators are automatically added in CSS through ::before and content.
     */
    public BSBreadcrumbs()
    {
        addFeature(getFeature());
        addClass(BSComponentBreadcrumbOptions.Breadcrumb);
    }

    /**
     * Returns the feature associated
     *
     * @return
     */
    public final BSBreadcrumbsFeature getFeature()
    {
        if (feature == null)
        {
            feature = new BSBreadcrumbsFeature(this);
        }
        return feature;
    }

    /**
     * Returns the options associated
     *
     * @return
     */
    @Override
    public BSBreadcrumbsOptions getOptions()
    {
        return getFeature().getOptions();
    }

    @Override
    public void preConfigure()
    {
        if (!isConfigured())
        {
            getChildren().forEach((next) ->
            {
                next.removeClass(BSComponentBreadcrumbOptions.Active.toString());
            });
            getChildren().get(getChildren().size() - 1).addClass(BSComponentBreadcrumbOptions.Active.toString());
        }
        super.preConfigure();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 79 * hash + (this.getID().hashCode());
        return hash;
    }
}
