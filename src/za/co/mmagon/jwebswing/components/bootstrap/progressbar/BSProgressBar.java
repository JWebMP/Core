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
package za.co.mmagon.jwebswing.components.bootstrap.progressbar;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.components.bootstrap.progressbar.bar.BSProgressBarDisplay;

/**
 * An implementation of the jsTree project.
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class BSProgressBar extends Div<BSProgressBarChildren, BSProgressBarAttributes, BSProgressBarFeatures, BSProgressBarEvents, BSProgressBar>
{

    private static final long serialVersionUID = 1L;
    private BSProgressBarFeature feature;
    
    /**
     * Whether or not the progress bar is striped
     */
    private boolean striped;
    /**
     * Whether or not this progress bar should display as active
     */
    private boolean active;

    /**
     * The actual progress bar
     */
    private BSProgressBarDisplay progressBar;
    /**
     * Creates a new instance of a progress bar
     * @param striped If the progress bar is striped or not
     */
    public BSProgressBar(boolean striped)
    {
        this(striped,false);
    }

    /**
     * Creates a new instance of a progress bar
     * @param striped If the progress bar is striped or not
     * @param active if the progress bar is active or not
     */
    public BSProgressBar(boolean striped, boolean active)
    {
        this(striped,active,null);
    }
    
    /**
     * Creates a new instance of a progress bar
     * @param striped If the progress bar is striped or not
     * @param active if the progress bar is active or not
     * @param progressBar  The actual progress bar
     */
    public BSProgressBar(boolean striped, boolean active, BSProgressBarDisplay progressBar)
    {
        addClass("progress");
        setStriped(striped);
        setActive(active);
        setProgressBar(null);
    }
    
    public final BSProgressBarFeature getFeature()
    {
        if (feature == null)
        {
            feature = new BSProgressBarFeature(this);
        }
        return feature;
    }

    @Override
    public BSProgressBarOptions getOptions()
    {
        return getFeature().getOptions();
    }

    /**
     * Sets if this component is striped or not
     * @return 
     */
    public boolean isStriped()
    {
        return striped;
    }

    /**
     * Sets if this components is striped or not
     * @param striped 
     */
    public final void setStriped(boolean striped)
    {
        this.striped = striped;
        if(striped)
        {
            addClass("progress-striped");
        }
        else
        {
            removeClass("progress-striped");
        }
    }

    /**
     * Returns if this progress bar should return as active
     * @return 
     */
    public boolean isActive()
    {
        return active;
    }

    /**
     * Sets if this component should return as active
     * @param active 
     */
    public final void setActive(boolean active)
    {
        this.active = active;
        if(active)
        {
            addClass("active");
        }
        else
        {
            removeClass("active");
        }
    }

    /**
     * Returns the actual progress bar
     * @return 
     */
    public BSProgressBarDisplay getProgressBar()
    {
        if(progressBar == null)
        {
            progressBar = new BSProgressBarDisplay();
            setProgressBar(progressBar);
        }
        return progressBar;
    }

    /**
     * Sets the actual progress bar
     * @param progressBar 
     */
    public final void setProgressBar(BSProgressBarDisplay progressBar)
    {
        getChildren().remove(this.progressBar);
        this.progressBar = progressBar;
        if(progressBar != null)
        {
            getChildren().add(progressBar);
        }
    }
}
