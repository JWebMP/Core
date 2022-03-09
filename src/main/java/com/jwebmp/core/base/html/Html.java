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

import com.fasterxml.jackson.annotation.*;
import com.jwebmp.core.*;
import com.jwebmp.core.base.client.*;
import com.jwebmp.core.base.html.attributes.*;
import com.jwebmp.core.base.html.interfaces.*;
import com.jwebmp.core.base.html.interfaces.events.*;
import com.jwebmp.core.base.servlets.enumarations.*;
import jakarta.validation.constraints.*;

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
 *
 * @param <J>
 * @author GedMarc
 * @since right from the start, 2007 with radio on live
 */
public abstract class Html<C extends GlobalChildren, J extends Html<C, J>>
		extends Component<C, NoAttributes, HTMLFeatures, NoEvents, J>
		implements NoIDTag, NoClassAttribute
{
	/**
	 * The head object
	 */
	private Head<?> head;
	@JsonProperty("RunningEnvironment")
	private DevelopmentEnvironments runningEnvironment = DevelopmentEnvironments.Development;
	/**
	 * The body object
	 */
	private Body<?, ?> body;
	/**
	 * The HTML Version the page
	 */
	@SuppressWarnings("FieldMayBeFinal")
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
	 * Constructs a new HTML Tag with a HTML Version. This supplies the most wanted HTML Version, and CSS Support. When measured the HTML
	 * Version
	 * <p>
	 *
	 * @param browser The minimum browser to support. Please don't choose IE5.5, or even 7 for that matter, You're making life difficult.
	 */
	public Html(Browsers browser)
	{
		super(ComponentTypes.Html);
		htmlVersion = browser.getHtmlVersion();
		head = new Head<>();
	}
	
	/**
	 * Renders the DocType for the HTML
	 * <p>
	 *
	 * @return The associated DocType for the HTML Document
	 */
	@Override
	protected StringBuilder renderBeforeTag()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(getBrowser().getHtmlVersion()
		                      .getDtd())
		  .append(getNewLine());
		return sb;
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
	
	@Override
	public int hashCode()
	{
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}
	
	/**
	 * Returns a valid HTML Version
	 * <p>
	 *
	 * @return Browser
	 */
	public HTMLVersions getHtmlVersion()
	{
		return htmlVersion;
	}
	
	/**
	 * Returns the currently set running environment
	 * <p>
	 *
	 * @return The current Environment.
	 */
	public DevelopmentEnvironments getRunningEnvironment()
	{
		return runningEnvironment;
	}
	
	/**
	 * Sets the global running environment value
	 * <p>
	 *
	 * @param runningEnvironmentSetting The running environment value
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setRunningEnvironment(DevelopmentEnvironments runningEnvironmentSetting)
	{
		runningEnvironment = runningEnvironmentSetting;
		return (J) this;
	}
	
	/**
	 * Returns the head object on the HTML Tag
	 *
	 * @return
	 */
	public Head<?> getHead()
	{
		return head;
	}
	
	/*
	 * Returns the body object on the HTML Tag
	 */
	public Body<?, ?> getBody()
	{
		if (body == null)
		{
			body = new Body<>((Page<?>) this);
		}
		return body;
	}
	
	/**
	 * Sets the body for this class
	 *
	 * @param body
	 */
	@SuppressWarnings("unchecked")
	public J setBody(Body<?, ?> body)
	{
		this.body = body;
		return (J) this;
	}
	
	/**
	 * Sets the header object for this html page
	 *
	 * @param head
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J setHead(Head<?> head)
	{
		this.head = head;
		return (J) this;
	}
	
	
}
