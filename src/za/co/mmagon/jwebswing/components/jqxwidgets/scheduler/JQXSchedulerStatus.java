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
package za.co.mmagon.jwebswing.components.jqxwidgets.scheduler;

import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourHex;

/**
 * This Class
 *
 * @author GedMarc
 * @since 24 Dec 2015
 */
public class JQXSchedulerStatus
{

    private ColourHex free;//: "white",
    private ColourHex tentative;// tentative: "tentative",
    private ColourHex busy;//: "transparent",
    private ColourHex outOfOffice;//: "#800080"

    @Override
    public String toString()
    {
        return super.toString();
    }

    public ColourHex getFree()
    {
        return free;
    }

    public void setFree(ColourHex free)
    {
        this.free = free;
    }

    public ColourHex getTentative()
    {
        return tentative;
    }

    public void setTentative(ColourHex tentative)
    {
        this.tentative = tentative;
    }

    public ColourHex getBusy()
    {
        return busy;
    }

    public void setBusy(ColourHex busy)
    {
        this.busy = busy;
    }

    public ColourHex getOutOfOffice()
    {
        return outOfOffice;
    }

    public void setOutOfOffice(ColourHex outOfOffice)
    {
        this.outOfOffice = outOfOffice;
    }

}
