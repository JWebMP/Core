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
package za.co.mmagon.jwebswing.components.bootstrap.close;

import za.co.mmagon.jwebswing.base.html.Button;
import za.co.mmagon.jwebswing.base.html.Span;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.components.bootstrap.componentoptions.BSComponentCloseIconOptions;

/**
 * Close icon
 * <p>
 * Use a generic close icon for dismissing content like modals and alerts. Be sure to include text for screen readers, as we’ve done with aria-label.
 *
 * @author GedMarc
 * @since 31 Dec 2016
 * @version 1.0
 *
 */
public class BSCloseIcon extends Button
{

    private static final long serialVersionUID = 1L;
    /**
     * The actual close icon
     */
    private Span closeIcon;
    /**
     * The actual text for the close icon
     */
    private String closeIconText = "&times;";

    /**
     * Constructs a new instance of the close icon
     * <p>
     */
    @SuppressWarnings("")
    public BSCloseIcon()
    {
        setAriaLabel("Close");
        addClass(BSComponentCloseIconOptions.Close);
        addAttribute(GlobalAttributes.Type, "button");
        getCloseIcon();
    }

    public BSCloseIcon setAriaLabel(String label)
    {
        addAttribute(GlobalAttributes.Aria_Label, label);
        return this;
    }

    /**
     * The physical close icon span display
     *
     * @return
     */
    public Span getCloseIcon()
    {
        if (this.closeIcon == null)
        {
            setCloseIcon(new Span(closeIconText));
        }
        return closeIcon;
    }

    /**
     * The physical close icon span
     *
     * @param closeIcon
     *
     * @return
     */
    public BSCloseIcon setCloseIcon(Span closeIcon)
    {
        if (this.closeIcon != null)
        {
            remove(this.closeIcon);
            this.closeIcon = null;
        }
        this.closeIcon = closeIcon;
        if (this.closeIcon != null)
        {
            add(this.closeIcon);
            this.closeIcon.addAttribute(GlobalAttributes.Aria_Hidden, "true");
        }
        return this;
    }

    /**
     * Return the text used for the close icon
     *
     * @return
     */
    public String getCloseIconText()
    {
        return closeIconText;
    }

    /**
     * Sets the close icon text for the span
     *
     * @param closeIconText
     */
    public void setCloseIconText(String closeIconText)
    {
        this.closeIconText = closeIconText;
        if (this.closeIconText != null)
        {
            getCloseIcon().setText(closeIconText);
        }
    }

    @Override
    public void init()
    {
        if (!isInitialized())
        {
            getPage().getOptions().setBootstrapEnabled(true);
        }
        super.init();
    }

}
