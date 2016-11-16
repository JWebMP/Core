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
package za.co.mmagon.jwebswing.components.jqxWidgets.themes;

import za.co.mmagon.jwebswing.htmlbuilder.css.themes.Theme;

/**
 * This Class
 *
 * @author GedMarc
 * @since 22 Dec 2015
 */
public enum JQXWidgetThemes
{
    Android(new AndroidTheme()),
    Arctic(new ArcticTheme()),
    Black(new BlackTheme()),
    Blackberry(new BlackberryTheme()),
    BootStrap(new BootStrapTheme()),
    Classic(new ClassicTheme()),
    DarkBlue(new DarkBlueTheme()),
    EnergyBlue(new EnergyBlueTheme()),
    Fresh(new FreshTheme()),
    HighContrast(new HighContrastTheme()),
    MetroDark(new MetroDarkTheme()),
    Metro(new MetroTheme()),
    Mobile(new MobileTheme()),
    Office(new OfficeTheme()),
    Orange(new OrangeTheme()),
    ShinyBlack(new ShinyBlackTheme()),
    Summer(new SummerTheme()),
    Web(new WebTheme()),
    WindowsPhone(new WindowsPhoneTheme());

    private Theme theme;

    private JQXWidgetThemes(Theme theme)
    {
        this.theme = theme;
    }

    public Theme getTheme()
    {
        return theme;
    }

    @Override
    public String toString()
    {
        return super.toString().toLowerCase();
    }

}
