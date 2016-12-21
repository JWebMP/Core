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

import za.co.mmagon.jwebswing.*;
import za.co.mmagon.jwebswing.components.d3.*;
import za.co.mmagon.jwebswing.components.d3.radialreingoldtilfordtree.*;

/**
 * The implementation of the Radial ComponentFeatureBase
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class JWReingoldTilfordTreeFeature extends Feature<JWReingoldTilfordTreeOptions, JWReingoldTilfordTreeFeature>
{

    private static final long serialVersionUID = 1L;
    private JWReingoldTilfordTreeOptions options = new JWReingoldTilfordTreeOptions();
    private final JWReingoldTilfordTree myTree;

    public JWReingoldTilfordTreeFeature(JWReingoldTilfordTree tree)
    {
        super("JWReingoldTilfordTreeFeature");
        this.myTree = tree;
        getJavascriptReferences().add(D3JavascriptReferencePool.D3DrawingLibrary.getReference());
        getJavascriptReferences().add(JQD3ReferencePool.ReingoldTilfodTree.getJavaScriptReference());
        getCssReferences().add(JQD3ReferencePool.ReingoldTilfodTree.getCssReference());
    }

    @Override
    public void assignFunctionsToComponent()
    {
        addQuery(myTree.getJQueryID() + "reingoldTree(" + getOptions() + ");");
    }

    /**
     * Gets the options for this set
     * <p>
     * @return
     */
    @Override
    public JWReingoldTilfordTreeOptions getOptions()
    {
        if (options == null)
        {
            options = new JWReingoldTilfordTreeOptions();
        }
        return options;
    }

    /**
     * Set to a new round of data
     * <p>
     * @param options
     */
    public void setOptions(JWReingoldTilfordTreeOptions options)
    {
        this.options = options;
    }
}
