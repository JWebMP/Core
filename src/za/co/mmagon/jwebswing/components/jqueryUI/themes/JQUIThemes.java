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
package za.co.mmagon.jwebswing.components.jqueryUI.themes;

import za.co.mmagon.jwebswing.htmlbuilder.css.themes.Theme;

/**
 * This Class
 *
 * @author GedMarc
 * @since 22 Dec 2015
 */
public enum JQUIThemes
{
    BlackTie(new BlackTieTheme()),
    Blitzer(new BlizterTheme()),
    Cupertino(new CupertinoTheme()),
    DarkHive(new DarkHiveTheme()),
    DotLuv(new DotLuvTheme()),
    Eggplant(new EggplantTheme()),
    ExciteBike(new ExciteBikeTheme()),
    Flick(new FlickTheme()),
    HotSneak(new HotSneaksTheme()),
    Humanity(new HumanityTheme()),
    LeFrog(new LeFrogTheme()),
    Lightness(new LightnessTheme()),
    Overcast(new OvercastTheme()),
    PepperGrinder(new PepperGrinderTheme()),
    Redmond(new RedmondTheme()),
    Smoothness(new SmoothnessTheme()),
    SouthStreet(new SouthStreetTheme()),
    Start(new StartTheme()),
    Sunny(new SunnyTheme()),
    SwankyPurse(new SwankyPurseTheme()),
    Trontastic(new TrontasticTheme()),
    Vader(new VaderTheme()),;
    private Theme theme;

    private JQUIThemes(Theme theme)
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
