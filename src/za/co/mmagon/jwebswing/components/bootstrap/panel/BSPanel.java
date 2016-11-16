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
package za.co.mmagon.jwebswing.components.bootstrap.panel;

import java.util.Iterator;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.Button;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.Link;
import za.co.mmagon.jwebswing.base.html.attributes.ButtonAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.components.bootstrap.BootstrapClasses;

/**
 * An implementation of the bootstrap panel layout.
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class BSPanel extends Div<GlobalChildren, BSPanelAttributes, BSPanelFeatures, BSPanelEvents, BSPanel>
{

    private static final long serialVersionUID = 1L;
    private BSPanelFeature feature;

    /**
     * The Panel Header Button Bar
     */
    private Div panelHeaderButtonBar;

    /**
     * The panel header
     */
    private Div panelHeader;
    /*
    The panel body
     */
    private Div panelBody;

    /**
     * Specifies if the footer must render as a link, or as a div
     */
    private boolean footerIsLink;

    /**
     * The panel footer
     */
    private Component panelFooter;
    /**
     * The theme associated
     */
    private BSPanelThemes theme;

    /**
     * Construct a new controlled instance of the sb2 panel
     * @param theme 
     */
    public BSPanel(BSPanelThemes theme)
    {
        addClass("panel");
        setTheme(theme);
    }

    @Override
    public void preConfigure()
    {
        if (!isConfigured())
        {
            getChildren().clear();
            getChildren().add(this.panelHeader);
            getChildren().add(this.panelBody);
            getChildren().add(this.panelFooter);

            if (this.panelFooter != null)
            {
                if (footerIsLink)
                {
                    for (Iterator it = panelFooter.getChildren().iterator(); it.hasNext();)
                    {
                        ComponentHierarchyBase comp = (ComponentHierarchyBase) it.next();
                        comp.addClass("panel-footer");
                    }
                }
            }
        }
        super.preConfigure();
    }

    public final BSPanelFeature getFeature()
    {
        if (feature == null)
        {
            feature = new BSPanelFeature(this);
        }
        return feature;
    }

    @Override
    public BSPanelOptions getOptions()
    {
        return getFeature().getOptions();
    }

    /**
     * Gets the panel header
     *
     * @return
     */
    public Div getPanelHeader()
    {
        if (panelHeader == null)
        {
            setPanelHeader(new Div());
        }

        return panelHeader;
    }

    /**
     * Sets and adds the panel body
     *
     * @return
     */
    public Div getPanelBody()
    {
        if (panelBody == null)
        {
            setPanelBody(new Div());
        }
        return panelBody;
    }

    /**
     * Gets the panel footer as a link. Class cast exception may occur if you have set the footer to a custom component
     *
     * @return
     */
    public Component getPanelFooter()
    {
        if (panelFooter == null)
        {
            setPanelFooter(new Link("#"));
            return this.panelFooter;
        }
        return panelFooter;
    }
    /**
     * Returns the current theme attached, default is the default
     *
     * @return
     */
    public BSPanelThemes getTheme()
    {
        if (theme == null)
        {
            theme = BSPanelThemes.Default;
        }
        return theme;
    }

    /**
     * Sets the panel header
     *
     * @param panelHeader
     */
    public void setPanelHeader(Div panelHeader)
    {
        this.panelHeader = panelHeader;
        if (this.panelHeader != null)
        {
            this.panelHeader.addClass("panel-heading");
        }
    }

    /**
     * Sets the panel body
     *
     * @param panelBody
     */
    public void setPanelBody(Div panelBody)
    {
        getChildren().remove(this.panelBody);
        this.panelBody = panelBody;
        if (this.panelBody != null)
        {
            this.panelBody.addClass("panel-body");
        }
    }

    /**
     * Sets the panel footer as a link with formatting
     *
     * @param panelFooter
     */
    public void setPanelFooter(Link panelFooter)
    {
        this.panelFooter = panelFooter;
        if (this.panelFooter != null)
        {
            //this.panelFooter.addClass("panel-footer");
        }
        this.footerIsLink = true;
    }

    /**
     * Sets the panel footer as a regular div
     *
     * @param panelFooter
     */
    public void setPanelFooter(Div panelFooter)
    {
        this.panelFooter = panelFooter;
        if (this.panelFooter != null)
        {
            this.panelFooter.addClass("panel-footer");
        }
        this.footerIsLink = false;
    }

    /**
     * Sets the theme to the given settings
     *
     * @param theme
     */
    public final void setTheme(BSPanelThemes theme)
    {
        if (this.theme != null)
        {
            removeClass(this.theme.getClassText());
        }
        this.theme = theme;
        addClass(theme.getClassText());
    }

    /**
     * Returns the Panel Headers Button Bar
     *
     * @return
     */
    public Div getPanelHeaderButtonBar()
    {
        if (panelHeaderButtonBar == null)
        {
            setPanelHeaderButtonBar(new Div());
        }
        return panelHeaderButtonBar;
    }

    /**
     * Sets the panel header button bar to the assigned Div
     *
     * @param panelHeaderButtonBar
     */
    public void setPanelHeaderButtonBar(Div panelHeaderButtonBar)
    {
        this.panelHeaderButtonBar = panelHeaderButtonBar;
        if (panelHeaderButtonBar != null)
        {
            panelHeaderButtonBar.addClass(BootstrapClasses.Btn_Group);
            panelHeaderButtonBar.addClass(BootstrapClasses.Pull_Right);
            getPanelHeader().add(panelHeaderButtonBar);
        }
    }
    
    /**
     * Adds a button to the drop down header
     * @param dropDownIcon
     * @param dropDownContent 
     */
    public void addDropDownToHeaderButtonBar(ComponentHierarchyBase dropDownIcon, ComponentHierarchyBase dropDownContent)
    {
        Button b = new Button();
        b.addClass("btn btn-default btn-xs dropdown-toggle");
        b.add(dropDownIcon);
        b.addAttribute(ButtonAttributes.Type, "button");
        b.addAttribute(ButtonAttributes.Data_Toggle, "dropdown");
        
        dropDownContent.setTag("ul");
        dropDownContent.addClass("dropdown-menu slidedown");
         
        getPanelHeaderButtonBar().add(b);
        getPanelHeaderButtonBar().add(dropDownContent);
    }
    
    
}
