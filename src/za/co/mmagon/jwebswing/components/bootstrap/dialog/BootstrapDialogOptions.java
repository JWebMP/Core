/*
 Copyright (C) 2015 GedMarc
 *
 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.
 *
 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.
 *
 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package za.co.mmagon.jwebswing.components.bootstrap.dialog;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptPartType;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class BootstrapDialogOptions extends JavaScriptPart
{

    private BootstrapDialogTypes type;// BootstrapDialogType.TYPE_PRIMARY,
    private BootstrapDialogSizes size;//: BootstrapDialog.SIZE_NORMAL,
    private String cssClass;
    @JsonIgnore
    private ComponentHierarchyBase title;//: null,
    @JsonIgnore
    private ComponentHierarchyBase message;//: null,
    private Boolean nl2br;//: true,
    private Boolean closable;//: true,
    private Boolean closeByBackdrop;//: true,
    private Boolean closeByKeyboard;//: true,
    private String closeIcon;//: '&#215;',
    private String spinicon;//: BootstrapDialog.ICON_SPINNER,
    private Boolean autodestroy;//: true,
    private Boolean draggable;//: false,
    private Boolean animate;//: true,
    private String description;//: '',
    private Integer tabindex;//: -1
    private String data;
    private Boolean autoDestroy;

    public BootstrapDialogOptions()
    {

    }

    /**
     * Give your dialog a specific look,
     * BootstrapDialog.TYPE_DEFAULT or type-default
     * BootstrapDialog.TYPE_INFO or type-info
     * BootstrapDialog.TYPE_PRIMARY or type-primary (default)
     * BootstrapDialog.TYPE_SUCCESS or type-success
     * BootstrapDialog.TYPE_WARNING or type-warning
     * BootstrapDialog.TYPE_DANGER or type-danger
     *
     * @return
     */
    public BootstrapDialogTypes getType()
    {
        return type;
    }

    /**
     * Give your dialog a specific look,
     * BootstrapDialog.TYPE_DEFAULT or type-default
     * BootstrapDialog.TYPE_INFO or type-info
     * BootstrapDialog.TYPE_PRIMARY or type-primary (default)
     * BootstrapDialog.TYPE_SUCCESS or type-success
     * BootstrapDialog.TYPE_WARNING or type-warning
     * BootstrapDialog.TYPE_DANGER or type-danger
     *
     * @param type
     */
    public void setType(BootstrapDialogTypes type)
    {
        this.type = type;
    }

    /**
     * BootstrapDialog.SIZE_NORMAL or size-normal (default)
     * BootstrapDialog.SIZE_WIDE or size-wide
     * BootstrapDialog.SIZE_LARGE or size-large
     *
     * @return
     */
    public BootstrapDialogSizes getSize()
    {
        return size;
    }

    /**
     * BootstrapDialog.SIZE_NORMAL or size-normal (default)
     * BootstrapDialog.SIZE_WIDE or size-wide
     * BootstrapDialog.SIZE_LARGE or size-large
     *
     * @param size
     */
    public void setSize(BootstrapDialogSizes size)
    {
        this.size = size;
    }

    /**
     * Additional CSS classes that will be added to your dialog.
     *
     * @return
     */
    public String getCssClass()
    {
        return cssClass;
    }

    /**
     * Additional CSS classes that will be added to your dialog.
     *
     * @param cssClass
     */
    public void setCssClass(String cssClass)
    {
        this.cssClass = cssClass;
    }

    /**
     * Components HTML
     *
     * @return
     */
    public ComponentHierarchyBase getTitle()
    {
        return title;
    }

    @JsonProperty("title")
    private String getTitleHTML()
    {
        return this.title == null ? "" : this.title.toString(true);
    }

    /**
     * Sets the components HTML to render
     *
     * @param title
     */
    public void setTitle(ComponentHierarchyBase title)
    {
        this.title = title;
    }

    /**
     * Gets the message component
     *
     * @return
     */
    public ComponentHierarchyBase getMessage()
    {
        return message;
    }

    @JsonProperty("message")
    private String getMessageHTML()
    {
        return this.message == null ? "" : this.message.toString(true);
    }

    /**
     * Sets the message component
     *
     * @param message
     */
    public void setMessage(ComponentHierarchyBase message)
    {
        this.message = message;
    }

    /**
     * Automatically convert line breaking character to &lt;br /&gt; if it's set to true, everything keeps original if it's false.
     *
     * @return
     */
    public Boolean getNl2br()
    {
        return nl2br;
    }

    /**
     * Automatically convert line breaking character to &lt;br /&gt; if it's set to true, everything keeps original if it's false.
     *
     * @param nl2br
     */
    public void setNl2br(Boolean nl2br)
    {
        this.nl2br = nl2br;
    }

    /**
     * When set to true, you can close the dialog by:
     * <p>
     * Clicking the close icon in dialog header.
     * Clicking outside the dialog.
     * ESC key.
     *
     * @return
     */
    public Boolean getClosable()
    {
        return closable;
    }

    /**
     * When set to true, you can close the dialog by:
     * <p>
     * Clicking the close icon in dialog header.
     * Clicking outside the dialog.
     * ESC key.
     *
     * @param closable
     */
    public void setClosable(Boolean closable)
    {
        this.closable = closable;
    }

    /**
     * Whether or not to close by the backdrop
     * @return 
     */
    public Boolean getCloseByBackdrop()
    {
        return closeByBackdrop;
    }

    /**
     * Sets to close by the backdrop or not
     * @param closeByBackdrop 
     */
    public void setCloseByBackdrop(Boolean closeByBackdrop)
    {
        this.closeByBackdrop = closeByBackdrop;
    }

    /**
     * Sets to close by keyboard press
     * @return 
     */
    public Boolean getCloseByKeyboard()
    {
        return closeByKeyboard;
    }

    /**
     * Sets close by keyboard
     * @param closeByKeyboard 
     */
    public void setCloseByKeyboard(Boolean closeByKeyboard)
    {
        this.closeByKeyboard = closeByKeyboard;
    }

    /**
     * Sets the close icon
     * @return 
     */
    public String getCloseIcon()
    {
        return closeIcon;
    }

    /**
     * Sets the close icon
     * @param closeIcon 
     */
    public void setCloseIcon(String closeIcon)
    {
        this.closeIcon = closeIcon;
    }

    /**
     * Sets the spin icon
     * @return 
     */
    public String getSpinicon()
    {
        return spinicon;
    }

    /**
     * Sets the spin icon
     * @param spinicon 
     */
    public void setSpinicon(String spinicon)
    {
        this.spinicon = spinicon;
    }

    /**
     * Whether or not to auto destroy the dialog
     * @return 
     */
    public Boolean getAutodestroy()
    {
        return autodestroy;
    }

    /**
     * Whether or not to auto destroy
     * @param autodestroy 
     */
    public void setAutodestroy(Boolean autodestroy)
    {
        this.autodestroy = autodestroy;
    }

    /**
     * Sets if the dialog is drag-able
     * @return 
     */
    public Boolean getDraggable()
    {
        return draggable;
    }

    /**
     * Sets if the dialog is drag-able
     * @param draggable 
     */
    public void setDraggable(Boolean draggable)
    {
        this.draggable = draggable;
    }

    /**
     * Sets if the dialog must animate
     * @return 
     */
    public Boolean getAnimate()
    {
        return animate;
    }

    /**
     * Sets if the dialog must animate
     * @param animate 
     */
    public void setAnimate(Boolean animate)
    {
        this.animate = animate;
    }

    /**
     * Sets the aria description
     * @return 
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Sets the dialog description or aria description
     * @param description 
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Gets the tab index
     * @return 
     */
    public Integer getTabindex()
    {
        return tabindex;
    }

    /**
     * Sets the tab index
     * @param tabindex 
     */
    public void setTabindex(Integer tabindex)
    {
        this.tabindex = tabindex;
    }

    /**
     * Sets any data being passed into the dialog
     * @return 
     */
    public String getData()
    {
        return data;
    }

    /**
     * Sets any data being passed into the dialog
     * @param data 
     */
    public void setData(String data)
    {
        this.data = data;
    }

    /**
     * Gets auto destroy
     * @return 
     */
    public Boolean getAutoDestroy()
    {
        return autoDestroy;
    }

    /**
     * Sets auto destroy
     * @param autoDestroy 
     */
    public void setAutoDestroy(Boolean autoDestroy)
    {
        this.autoDestroy = autoDestroy;
    }

    @Override
    public JavascriptPartType getJavascriptType()
    {
        return JavascriptPartType.Javascript;
    }

}
