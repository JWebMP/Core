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
package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.base.client.HTMLVersions;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineForRawText;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.interfaces.ComponentHTMLBase;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * <p>
 * Definition and Usage<p>
 * <p>
 * The &gt;!DOCTYPE&lt; declaration must be the very first thing in your HTML<p>
 * document, before the &gt;html&lt; tag.<p>
 * <p>
 * The &gt;!DOCTYPE&lt; declaration is not an HTML tag; it is an instruction to<p>
 * the web browser about what version of HTML the page is written in.<p>
 * <p>
 * In HTML 4.01, the &gt;!DOCTYPE&lt; declaration refers to a DTD, because HTML<p>
 * 4.01 was based on SGML. The DTD specifies the rules for the markup language,
 * <p>
 * so that the browsers render the content<p>
 * correctly.<p>
 * <p>
 * HTML5 is not based on SGML, and therefore does not require a reference to a<p>
 * DTD.<p>
 * <p>
 * Tip: Always add the &gt;!DOCTYPE&lt; declaration to your HTML documents, so<p>
 * that the browser knows what type of document to expect.<p>
 * <p>
 * Browser Support Element<p>
 * &gt;!DOCTYPE&lt; Yes Yes Yes Yes Yes<p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * There are three different &gt;!DOCTYPE&lt; declarations in HTML 4.01. In<p>
 * HTML5 there is only one:
 * <p>
 *
 * @since 2014/10/26
 * @version 1.0
 * @author MMagon
 *
 *
 */
public class DocumentType
        extends ComponentHTMLBase<GlobalFeatures, GlobalEvents, DocumentType>
        implements NoNewLineForRawText
{

    private static final long serialVersionUID = 1L;

    private final HTMLVersions clientHtmlVersion;

    /**
     * Constructs a new document type for the HTML Component
     *
     * @param clientHtmlVersion The browser HTML version to render for, usually the clients. This gets set by the JWebSwing Servlet.
     */
    public DocumentType(HTMLVersions clientHtmlVersion)
    {
        super(ComponentTypes.Feature);
        this.clientHtmlVersion = clientHtmlVersion;
    }

    /**
     * Renders the DTD clause
     *
     * @return
     */
    @Override
    public String toString()
    {
        return (clientHtmlVersion.getDtd());
    }

    /**
     * Renders the DTD Clause
     *
     * @param outputHtml
     *
     * @return
     */
    @Override
    public String toString(boolean outputHtml)
    {
        return toString();
    }

    /**
     * Renders the DTD Clause
     *
     * @param tabCount
     *
     * @return
     */
    @Override
    public String toString(Integer tabCount)
    {
        return toString();
    }

    /**
     * Returns the connected client browser version
     * <p>
     * @return The HTML version that the client browser is running
     */
    public HTMLVersions getClientHtmlVersion()
    {
        return clientHtmlVersion;
    }

}
