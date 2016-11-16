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
package za.co.mmagon.jwebswing.components.jqMetro.metro;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.components.jqMetro.metro.enumerations.TileAccentThemes;
import za.co.mmagon.jwebswing.components.jqMetro.metro.enumerations.TileCount;

/**
 * The implementation of JQuery Metro  JS http://www.drewgreenwell.com/projects/metrojs
 * 
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class JQMetroTiles extends Div<JQMetroChildren, JQMetroAttributes, JQMetroFeatures, JQMetroEvents, JQMetroTiles>
{

    private static final long serialVersionUID = 1L;

    private JQMetroFeature feature;

    /**
     * Constructs a default tile group of blue and four
     */
    public JQMetroTiles()
    {
        this(TileAccentThemes.Blue, TileCount.four);
    }
    
    /**
     * Construct a new tile group with themes and tile counts
     * @param theme The theme
     * @param tileCount The tile count
     */
    public JQMetroTiles(TileAccentThemes theme, TileCount tileCount)
    {
        addClass("tiles");
        addClass("tile-group");

        setTheme(theme);
        setTileCount(tileCount);

        addFeature(getFeature()); 
    }

    /**
     * Returns the Metro JQuery Feature
     * @return 
     */
    protected final JQMetroFeature getFeature()
    { 
       if (feature == null)
        {
            feature = new JQMetroFeature(this);
        }
        return feature;
    }

    /**
     * Returns the options
     * @return 
     */
    @Override
    public JQMetroOptions getOptions()
    {
        return getFeature().getOptions();
    }

    /**
     * Removes any applied colour themes
     */
    private void removeExistingThemes()
    {
        for (TileAccentThemes theme : TileAccentThemes.values())
        {
            removeClass(theme.toString());
        }
    }
    
    /**
     * Remove existing tiles
     */
    private void removeExistingTileCounts()
    {
        for (TileCount tileCount : TileCount.values())
        {
            removeClass(tileCount.toString());
        }
    }
    
    /**
     * Sets the current tile accent theme
     * @param theme 
     */
    public final void setTheme(TileAccentThemes theme)
    {
        removeExistingThemes();
        addClass(theme.toString());
    }
    
    /**
     * Sets the current tile count
     * @param theme 
     */
    public final void setTileCount(TileCount theme)
    {
        removeExistingTileCounts();
        addClass(theme.toString());
    }
    
}
