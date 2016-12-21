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
package za.co.mmagon.jwebswing.components.d3.reingoldtilfordtree;

import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.base.html.attributes.*;
import za.co.mmagon.jwebswing.base.html.interfaces.children.*;
import za.co.mmagon.jwebswing.base.html.interfaces.events.*;
import za.co.mmagon.jwebswing.components.d3.radialreingoldtilfordtree.*;

/**
 * An interactive version of the Reingold–Tilford Tree
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class JWReingoldTilfordTree extends Div<NoChildren, NoAttributes, JWReingoldTilfordTreeFeature, NoEvents, JWRadialReingoldTilfordTree>
{

    private static final long serialVersionUID = 1L;
    private JWReingoldTilfordTreeFeature feature;
    private JWReingoldTilfordTreeOptions options;

    public JWReingoldTilfordTree()
    {
        feature = new JWReingoldTilfordTreeFeature(this);
        addFeature(feature);

    }

    public JWReingoldTilfordTreeOptions getOptions()
    {
        return getFeature().getOptions();
    }

    public JWReingoldTilfordTreeFeature getFeature()
    {
        return feature;
    }

    public void setFeature(JWReingoldTilfordTreeFeature feature)
    {
        this.feature = feature;
    }

}
