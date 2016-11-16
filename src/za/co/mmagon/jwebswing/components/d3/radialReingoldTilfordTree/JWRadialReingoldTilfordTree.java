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
package za.co.mmagon.jwebswing.components.d3.radialReingoldTilfordTree;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.components.d3.reingoldTilfordTree.JWReingoldTilfordTreeOptions;

/**
 * The implementation of the radial Reingold Tilford Tree.
 * <p>
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class JWRadialReingoldTilfordTree
        extends Div<NoChildren, NoAttributes, JWRadialReingoldTilfordTreeFeature, NoEvents, JWRadialReingoldTilfordTree>
{

    private static final long serialVersionUID = 1L;
    private JWRadialReingoldTilfordTreeFeature feature;

    /**
     * Constructs a new Tilford Tree
     */
    public JWRadialReingoldTilfordTree()
    {
        super();
        feature = new JWRadialReingoldTilfordTreeFeature(this);
        addFeature(feature);
    }

    public JWReingoldTilfordTreeOptions getOptions()
    {
        return getFeature().getOptions();
    }

    public JWRadialReingoldTilfordTreeFeature getFeature()
    {
        return feature;
    }

    public void setFeature(JWRadialReingoldTilfordTreeFeature feature)
    {
        this.feature = feature;
    }

}
