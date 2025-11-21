/*
 * Copyright (C) 2017 GedMarc
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
package com.jwebmp.core.base.html;

import com.jwebmp.core.Component;
import com.jwebmp.core.base.html.attributes.BodyAttributes;
import com.jwebmp.core.base.html.interfaces.ContainerType;
import com.jwebmp.core.base.html.interfaces.LayoutHandler;
import com.jwebmp.core.base.html.interfaces.children.BodyChildren;
import com.jwebmp.core.base.html.interfaces.children.BodyFeatures;
import com.jwebmp.core.base.html.interfaces.children.HtmlChildren;
import com.jwebmp.core.base.html.interfaces.children.PageChildren;
import com.jwebmp.core.base.html.interfaces.events.BodyEvents;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.core.services.IBody;
import com.jwebmp.core.services.IPage;
import jakarta.validation.constraints.NotNull;

/**
 * Browser Support<p>
 * <p>
 * Internet Explorer FireFox Opera Google Chrome Safari<p>
 * <p>
 * The body tag is supported in all major browsers.<p>
 * <p>
 * Definition and Usage<p>
 * <p>
 * The body tag defines the document's body.<p>
 * <p>
 * The body element contains all the contents of an HTML document, such as text,
 * <p>
 * hyperlinks, images, tables, lists, etc.<p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * All layout attributes is removed from HTML5.<p>
 * <p>
 * All layout attributes is deprecated in HTML 4.01
 * .<p>
 * <p>
 *
 * @param <F> Features Base
 * @param <J>
 * @author GedMarc
 * @version 1.0
 * @since 2013/11/20
 */
public class Body<F extends BodyFeatures, J extends Body<F, J>>
        extends Component<BodyChildren, BodyAttributes, F, BodyEvents, J>
        implements PageChildren, HtmlChildren, LayoutHandler, ContainerType, IBody<F, J> {

    /**
     * If this body has rendered the scripts on itself
     */
    private boolean renderedScripts;

    /**
     * Instantiates an empty body
     */
    public Body() {
        this(null);
    }

    /**
     * Constructs a new Body with the given Page input
     *
     * @param page
     */
    public Body(IPage<?> page) {
        super(ComponentTypes.Body);
        if (page != null) {
            setPage(page);
        }
        setID("body");

    }

    @SuppressWarnings("unchecked")
    @Override
    public @NotNull J setFullScreen() {
        addStyle("width:100%;height:100%;margin:0px;");
        getPage().addStyle("width:100%;height:100%;margin:0px;");
        return (J) this;
    }

    /**
     * If the scripts have been rendered
     *
     * @return
     */
    @Override
    public boolean isRenderedScripts() {
        return renderedScripts;
    }

    /**
     * If the scripts have been rendered
     *
     * @param renderedScripts
     * @return
     */
    @Override
    public @org.jspecify.annotations.NonNull J setRenderedScripts(boolean renderedScripts) {
        this.renderedScripts = renderedScripts;
        return (J) this;
    }
}
