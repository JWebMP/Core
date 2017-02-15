/*
 * Copyright (C) 2017 Marc Magon
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
package za.co.mmagon.jwebswing.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.HashMap;
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.interfaces.IComponentStyleBase;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSImpl;
import za.co.mmagon.jwebswing.htmlbuilder.css.composer.CSSComposer;
import za.co.mmagon.jwebswing.htmlbuilder.css.enumarations.CSSTypes;

/**
 * The CSS Portion of the Component.
 *
 * @author GedMarc
 * @param <C> All allowed children
 * @param <A> All attributes for this component
 * @param <F> All features allowed for this component
 * @param <E> All events allowed for this component
 * @param <J> Always this class
 *
 * @since 24 Apr 2016
 */
public class ComponentStyleBase<C extends GlobalChildren, A extends Enum & AttributeDefinitions, F extends GlobalFeatures, E extends GlobalEvents, J extends ComponentStyleBase>
        extends ComponentHierarchyBase<C, A, F, E, J> implements IComponentStyleBase<J>
{

    private static final long serialVersionUID = 1L;

    /**
     * The CSS Object for all styling
     */
    private CSSImpl css;
    /**
     * The Hover CSS Object
     */
    private CSSImpl hoverCss;
    /**
     * The Active CSS Object
     */
    private CSSImpl activeCss;
    /**
     * The Link CSS Object
     */
    private CSSImpl linkCss;
    /**
     * The visited CSS Object
     */
    private CSSImpl visitedCss;
    /**
     * The CSS Class name if required
     */
    private String cssName;

    /**
     * Container for all the CSS Types
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private HashMap<CSSTypes, CSSImpl> cssTypeHashMap;

    /**
     * Constructs a tag with styling options enabled
     *
     * @param componentType
     */
    public ComponentStyleBase(ComponentTypes componentType)
    {
        super(componentType);
    }

    /**
     * Returns a ComponentStyleBase component of this
     *
     * @return
     */
    public IComponentStyleBase asStyleBase()
    {
        return (ComponentStyleBase) this;
    }

    /**
     * Returns the current HashMap of all CSS Entries for the component
     *
     * @return
     */
    @Override
    public HashMap<CSSTypes, CSSImpl> getCssTypeHashMap()
    {
        if (cssTypeHashMap == null)
        {
            cssTypeHashMap = new HashMap<>();
        }
        return cssTypeHashMap;
    }

    /**
     * Gets the CSS Object used for styling
     *
     * @return
     */
    @Override
    public CSSImpl getCss()
    {
        if (css == null)
        {
            css = new CSSImpl();
            getCssTypeHashMap().put(CSSTypes.None, css);
        }
        return css;
    }

    /**
     * Sets the CSS Object used for styling
     *
     * @param css
     */
    @Override
    public void setCss(CSSImpl css)
    {
        this.css = css;
    }

    /**
     * Renders the component CSS at the specified tab count with the &lt;style&gt; tag
     * <p>
     * @param tabCount Tab indentation for the SQL
     * <p>
     * @return The Component CSS
     */
    @Override
    public StringBuilder renderCss(int tabCount)
    {
        return renderCss(tabCount, true, false, false);
    }

    /**
     * Renders the component CSS at the specified tab count with the &lt;style&gt; tag This includes everything from this classes CSS, to the CSS for each field. It will also populate the lower level
     * child CSS for fields in this class
     * <p>
     * @param tabCount           Tab indentation for the SQL
     * @param renderOpening      Whether or not to render the opening XML tag for a CSS style
     * @param renderInQuotations Sets whether to render the CSS Fields in Quotations
     * @param isAjaxCall         Sets whether the CSS is being called from an AJAX call
     * <p>
     * @return The Component CSS
     */
    @Override
    public StringBuilder renderCss(int tabCount, boolean renderOpening, boolean renderInQuotations, boolean isAjaxCall)
    {
        if (!isInitialized())
        {
            init();
        }
        if (!isConfigured())
        {
            preConfigure();
        }
        CSSComposer comp = new CSSComposer();
        comp.addComponent(this, true);
        return new StringBuilder(comp.toString());
    }

    /**
     * Returns the currently assigned CSS Name
     *
     * @return
     */
    @Override
    public String getCssName()
    {
        return cssName;
    }

    /**
     * Sets the currently assigned CSS Name
     *
     * @param cssName
     */
    @Override
    public void setCssName(String cssName)
    {
        this.cssName = cssName;
    }

    /**
     * Gets the hover format CSS
     *
     * @return
     */
    @Override
    public CSSImpl getHoverCss()
    {
        if (hoverCss == null)
        {
            hoverCss = new CSSImpl();
            getCssTypeHashMap().put(CSSTypes.Hover, hoverCss);
        }
        return hoverCss;
    }

    /**
     * Sets the hover format CSS
     *
     * @param hoverCss
     */
    @Override
    public void setHoverCss(CSSImpl hoverCss)
    {

        this.hoverCss = hoverCss;
    }

    /**
     * Gets the active CSS
     *
     * @return
     */
    @Override
    public CSSImpl getActiveCss()
    {
        if (activeCss == null)
        {
            activeCss = new CSSImpl();
            getCssTypeHashMap().put(CSSTypes.Active, activeCss);
        }
        return activeCss;
    }

    /**
     * Sets the active CSS
     *
     * @param activeCss
     */
    @Override
    public void setActiveCss(CSSImpl activeCss)
    {
        this.activeCss = activeCss;
    }

    /**
     * Gets the link CSS
     *
     * @return
     */
    @Override
    public CSSImpl getLinkCss()
    {
        if (linkCss == null)
        {
            linkCss = new CSSImpl();
            getCssTypeHashMap().put(CSSTypes.Link, linkCss);
        }
        return linkCss;
    }

    /**
     * Sets the Link CSS
     *
     * @param linkCss
     */
    @Override
    public void setLinkCss(CSSImpl linkCss)
    {
        this.linkCss = linkCss;
    }

    /**
     * Gets the Visited CSS
     *
     * @return
     */
    @Override
    public CSSImpl getVisitedCss()
    {
        if (visitedCss == null)
        {
            visitedCss = new CSSImpl();
            getCssTypeHashMap().put(CSSTypes.Visited, visitedCss);
        }
        return visitedCss;
    }

    /**
     * Sets the Visited CSS
     *
     * @param visitedCss
     */
    @Override
    public void setVisitedCss(CSSImpl visitedCss)
    {
        this.visitedCss = visitedCss;
    }

    /**
     * Adds a CSS object to the component with the given type
     *
     * @param type
     * @param cssItem
     */
    @Override
    public void addCSSEntry(CSSTypes type, CSSImpl cssItem)
    {
        getCssTypeHashMap().put(type, cssItem);
    }

    /**
     * Removes a CSS item for the component
     *
     * @param cssType
     */
    @Override
    public void removeCSSEntry(CSSTypes cssType)
    {
        getCssTypeHashMap().remove(cssType);
    }

    /**
     * Updates the ID of all the CSS Objects
     *
     * @param id The ID to update with
     *
     * @return Me
     */
    @Override
    public J setID(String id)
    {
        J me = super.setID(id);
        getCssTypeHashMap().entrySet().stream().map((entry) ->
        {
            CSSTypes key = entry.getKey();
            return entry;
        }).forEachOrdered((entry) ->
        {
            CSSImpl value = entry.getValue();
        });
        return me;
    }

}
