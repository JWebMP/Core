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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.client.Browsers;
import za.co.mmagon.jwebswing.base.client.HTMLVersions;
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.base.interfaces.ComponentHTMLBase;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.base.servlets.enumarations.DevelopmentEnvironments;

/**
 * The base HTML Component.<p>
 * <p>
 * Reference via the page.<p>
 * <p>
 * Definition and Usage<p>
 * <p>
 * The &lt;html;&gt; tag tells the browser that this is an HTML document.<p>
 * <p>
 * The &lt;html;&gt; tag represents the root of an HTML document.<p>
 * <p>
 * The &lt;html;&gt; tag is the container for all other HTML elements (except for the &lt;!DOCTYPE&gt; tag)
 * .<p>
 * <p>
 * Browser Support Element &lt;html;&gt; Yes Yes Yes Yes Yes<p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * HTML5 has added a new attribute: manifest. Differences Between HTML and XHTML<p>
 * <p>
 * The xmlns attribute is required in XHTML, but is invalid in HTML.<p>
 * <p>
 * However, the HTML validator at http://w3.org does not complain when the xmlns attribute is missing in an XHTML document. ,
 * <p>
 * <p>
 * This is because the namespace "xmlns=http://www.w3.org/1999/xhtml" is<p>
 * <p>
 * default, and will be added to the &lt;html;&gt; tag even if you do not include it.<p>
 * <p>
 * @author Marc Magon
 * @param <J>
 *
 * @since right from the start, 2007 with radio on live
 */
public abstract class Html<J extends Html>
        extends ComponentHTMLBase<HTMLFeatures, NoEvents, J>
        implements NoIDTag, NoClassAttribute
{

    private static final long serialVersionUID = 1L;

    @JsonProperty("RunningEnvironment")
    private DevelopmentEnvironments runningEnvironment = DevelopmentEnvironments.Development;
    /**
     * The head object
     */
    private final Head head;
    /**
     * The body object
     */
    private Body body;
    /**
     * The HTML Version the page
     */
    private HTMLVersions htmlVersion;

    /*
     * The current browser of the render
     */
    @JsonIgnore
    private Browsers browser;

    /**
     * Constructs a new HTML Tag with I.E. 10 support
     */
    public Html()
    {
        this(Browsers.Edge);
    }

    /**
     * Constructs a new HTML Tag with a HTML Version. This supplies the most wanted HTML Version, and CSS Support. When measured the HTML Version
     * <p>
     * @param browser The minimum browser to support. Please don't choose IE5.5, or even 7 for that matter, You're making life difficult.
     */
    public Html(Browsers browser)
    {
        super(ComponentTypes.Html);
        this.htmlVersion = browser.getHtmlVersion();
        head = new Head();
    }

    /**
     * Renders the DocType for the HTML
     * <p>
     * @return The associated DocType for the HTML Document
     */
    @Override
    protected StringBuilder renderBeforeTag()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(getBrowser().getHtmlVersion().getDtd()).append(getNewLine());
        return sb;
    }

    /**
     * Returns a valid HTML Version
     * <p>
     * @return Browser
     */
    public HTMLVersions getHtmlVersion()
    {
        return htmlVersion;
    }

    /**
     * Returns the currently set running environment
     * <p>
     * @return The current Environment.
     */
    public DevelopmentEnvironments getRunningEnvironment()
    {
        return runningEnvironment;
    }

    /**
     * Sets the global running environment value
     * <p>
     * @param runningEnvironmentSetting The running environment value
     */
    public void setRunningEnvironment(DevelopmentEnvironments runningEnvironmentSetting)
    {
        runningEnvironment = runningEnvironmentSetting;
    }

    /**
     * Returns the head object on the HTML Tag
     *
     * @return
     */
    public Head getHead()
    {
        return head;
    }

    /*
     * Returns the body object on the HTML Tag
     */
    public Body getBody()
    {
        if (body == null)
        {
            body = new Body(Page.class.cast(this));
        }
        return body;
    }

    /**
     * Sets the body for this class
     *
     * @param body
     */
    public void setBody(Body body)
    {
        if (this.body != null)
        {
        }
        this.body = body;
    }

    /**
     * Returns the current browser or FireFox
     *
     * @return
     */
    public Browsers getBrowser()
    {
        if (browser == null)
        {
            browser = Browsers.Firefox19;
        }
        return browser;
    }

    /**
     * Returns the current browser or FireFox
     *
     * @param browser
     */
    public void setBrowser(Browsers browser)
    {
        this.browser = browser;
    }
}
