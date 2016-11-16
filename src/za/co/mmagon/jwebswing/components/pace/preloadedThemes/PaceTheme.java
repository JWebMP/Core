/*
 * Copyright (C) 2016 GedMarc
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
package za.co.mmagon.jwebswing.components.pace.preloadedThemes;

import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.servlets.enumarations.RequirementsPriority;
import za.co.mmagon.jwebswing.components.pace.PaceThemeColour;

/**
 * Specifies a valid pace theme
 *
 * @author GedMarc
 */
public enum PaceTheme
{
    Barbershop(new CSSReference("CSSPaceBarberShop", 1.02, "bower_components/PACE/themes/xxXXxx/pace-theme-barber-shop.css", "https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/themes/xxXXxx/pace-theme-barber-shop.css")),
    BigCounter(new CSSReference("CSSPaceBigCounter", 1.02, "bower_components/PACE/themes/xxXXxx/pace-theme-big-counter.css", "https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/themes/xxXXxx/pace-theme-big-counter.css")),
    Bounce(new CSSReference("CSSPaceBounce", 1.02, "bower_components/PACE/themes/xxXXxx/pace-theme-bounce.css", "https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/themes/xxXXxx/pace-theme-bounce.css")),
    CenterAtom(new CSSReference("CSSPaceCenterAtom", 1.02, "bower_components/PACE/themes/xxXXxx/pace-theme-center-atom.css", "https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/themes/xxXXxx/pace-theme-center-atom.css")),
    CenterCircle(new CSSReference("CSSPaceCenterCircle", 1.02, "bower_components/PACE/themes/xxXXxx/pace-theme-center-circle.css", "https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/themes/xxXXxx/pace-theme-center-circle.css")),
    CenterRader(new CSSReference("CSSPaceCenterRader", 1.02, "bower_components/PACE/themes/xxXXxx/pace-theme-center-rader.css", "https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/themes/xxXXxx/pace-theme-center-radar.css")),
    CenterSimple(new CSSReference("CSSPaceCenterSimple", 1.02, "bower_components/PACE/themes/xxXXxx/pace-theme-center-simple.css", "https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/themes/xxXXxx/pace-theme-center-simple.css")),
    CornerIndicator(new CSSReference("CSSPaceCornerIndicator", 1.02, "bower_components/PACE/themes/xxXXxx/pace-theme-cornerIndicator.css", "https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/themes/xxXXxx/pace-theme-corner-indicator.css")),
    FillLeft(new CSSReference("CSSPaceFillLeft", 1.02, "bower_components/PACE/themes/xxXXxx/pace-theme-fill-left.css", "https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/themes/xxXXxx/pace-theme-fill-left.css")),
    Flash(new CSSReference("CSSPaceFlash", 1.02, "bower_components/PACE/themes/xxXXxx/pace-theme-flash.css", "https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/themes/xxXXxx/pace-theme-flash.css")),
    FlatTop(new CSSReference("CSSPaceFlatTop", 1.02, "bower_components/PACE/themes/xxXXxx/pace-theme-flat-top.css", "https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/themes/xxXXxx/pace-theme-flat-top.css")),
    LoadingProgressBar(new CSSReference("CSSPaceLoadingProgressBar", 1.02, "bower_components/PACE/themes/xxXXxx/pace-theme-loading-bar.css", "https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/themes/xxXXxx/pace-theme-loading-bar.css")),
    MacOSX(new CSSReference("CSSPaceMacOSX", 1.02, "bower_components/PACE/themes/xxXXxx/pace-theme-macosx.css", "https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/themes/xxXXxx/pace-theme-mac-osx.css")),
    Minimal(new CSSReference("CSSPaceMinimal", 1.02, "bower_components/PACE/themes/xxXXxx/pace-theme-minimal.css", "https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/themes/xxXXxx/pace-theme-minimal.css"));

    private CSSReference CSSReference;
    private PaceThemeColour themeColour = PaceThemeColour.Red;

    /**
     * Gets a pace theme
     *
     * @param CSSReference
     */
    private PaceTheme(CSSReference CSSReference)
    {
        this.CSSReference = CSSReference;
        this.CSSReference.setPriority(RequirementsPriority.First);
        this.CSSReference.setCanMinifyAtRemote(false);
        CSSReference.setSortOrder(0);
    }

    /**
     * Returns the CSS Reference for pace and the theme
     *
     * @return
     */
    public CSSReference getCSSReference()
    {
        CSSReference.setRemoteReference(CSSReference.getRemoteReference().replaceAll("xxXXxx", themeColour.toString()));
        CSSReference.setLocalReference(CSSReference.getLocalReference().replaceAll("xxXXxx", themeColour.toString()));
        return CSSReference;
    }

    /**
     * Sets the CSS Reference for the pace theme
     *
     * @param CSSReference
     */
    public void setCSSReference(CSSReference CSSReference)
    {
        this.CSSReference = CSSReference;
    }

    /**
     * Gets the pace theme colour applied
     *
     * @return
     */
    public PaceThemeColour getThemeColour()
    {
        return themeColour;
    }

    /**
     * Sets the pace theme colour applied
     *
     * @param themeColour
     */
    public void setThemeColour(PaceThemeColour themeColour)
    {
        this.themeColour = themeColour;
    }

}
