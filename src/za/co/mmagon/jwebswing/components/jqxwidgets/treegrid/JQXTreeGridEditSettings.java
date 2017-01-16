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
package za.co.mmagon.jwebswing.components.jqxwidgets.treegrid;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * This Class
 *
 * @author GedMarc
 * @since 25 Dec 2015
 */
public class JQXTreeGridEditSettings extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    private Boolean saveOnPageChange;
    private Boolean saveOnBlur;
    private Boolean saveOnSelectionChange;
    private Boolean cancelOnEsc;
    private Boolean saveOnEnter;
    private Boolean editSingleCell;
    private Boolean editOnDoubleClick;
    private Boolean editOnF2;

    public JQXTreeGridEditSettings()
    {
    }

    public Boolean getSaveOnPageChange()
    {
        return saveOnPageChange;
    }

    public void setSaveOnPageChange(Boolean saveOnPageChange)
    {
        this.saveOnPageChange = saveOnPageChange;
    }

    public Boolean getSaveOnBlur()
    {
        return saveOnBlur;
    }

    public void setSaveOnBlur(Boolean saveOnBlur)
    {
        this.saveOnBlur = saveOnBlur;
    }

    public Boolean getSaveOnSelectionChange()
    {
        return saveOnSelectionChange;
    }

    public void setSaveOnSelectionChange(Boolean saveOnSelectionChange)
    {
        this.saveOnSelectionChange = saveOnSelectionChange;
    }

    public Boolean getCancelOnEsc()
    {
        return cancelOnEsc;
    }

    public void setCancelOnEsc(Boolean cancelOnEsc)
    {
        this.cancelOnEsc = cancelOnEsc;
    }

    public Boolean getSaveOnEnter()
    {
        return saveOnEnter;
    }

    public void setSaveOnEnter(Boolean saveOnEnter)
    {
        this.saveOnEnter = saveOnEnter;
    }

    public Boolean getEditSingleCell()
    {
        return editSingleCell;
    }

    public void setEditSingleCell(Boolean editSingleCell)
    {
        this.editSingleCell = editSingleCell;
    }

    public Boolean getEditOnDoubleClick()
    {
        return editOnDoubleClick;
    }

    public void setEditOnDoubleClick(Boolean editOnDoubleClick)
    {
        this.editOnDoubleClick = editOnDoubleClick;
    }

    public Boolean getEditOnF2()
    {
        return editOnF2;
    }

    public void setEditOnF2(Boolean editOnF2)
    {
        this.editOnF2 = editOnF2;
    }

    @Override
    public String toString()
    {
        return super.toString();
    }

}
