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
package com.jwebmp.base.servlets;

import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.servlet.RequestScoped;
import com.jwebmp.Page;
import com.jwebmp.annotations.AjaxCallInterception;
import com.jwebmp.annotations.SiteInterception;
import com.jwebmp.base.ajax.AjaxCall;
import com.jwebmp.base.ajax.AjaxEventValue;
import com.jwebmp.base.client.Browsers;
import com.jwebmp.base.html.Body;
import com.jwebmp.base.html.PreFormattedText;
import com.jwebmp.exceptions.InvalidRequestException;
import com.jwebmp.exceptions.MissingComponentException;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.htmlbuilder.javascript.events.enumerations.EventTypes;
import com.jwebmp.logger.LogFactory;
import com.jwebmp.utilities.StaticStrings;
import com.jwebmp.utilities.TextUtilities;
import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.jwebmp.utilities.StaticStrings.*;

/**
 * Provides default methods for authentication authorization etc
 *
 * @author GedMarc
 * @version 1.0
 * @since Nov 14, 2016
 */
public abstract class JWDefaultServlet
		extends HttpServlet
{

	/**
	 * The Servlet base logger
	 */
	private static final Logger log = LogFactory.getInstance()
	                                            .getLogger("ServletBase");
	/**
	 * Version 1
	 */
	private static final long serialVersionUID = 1L;

	private static String allowOrigin = "*";

	/**
	 * Construct a new default servlett
	 */
	public JWDefaultServlet()
	{
		//Nothing needed
	}

	/**
	 * Sets the stream allow origins
	 *
	 * @return
	 */
	public static String getAllowOrigin()
	{
		return allowOrigin;
	}

	/**
	 * Sets the streams allow origins
	 *
	 * @param allowOrigin
	 */
	public static void setAllowOrigin(@NotNull String allowOrigin)
	{
		JWDefaultServlet.allowOrigin = allowOrigin;
	}

	/**
	 * Validates the given call for the servlet
	 *
	 * @param ajaxCall
	 * 		optional parameter to validate on more fields
	 *
	 * @return
	 */
	public boolean validateCall(AjaxCall ajaxCall) throws InvalidRequestException
	{
		HttpServletRequest request = GuiceContext.getInstance(HttpServletRequest.class);
		if (ajaxCall.getComponentId() == null)
		{
			log.log(Level.SEVERE, "[SessionID]-[{0}];[Security]-[Component ID Not Found]", request.getSession()
			                                                                                      .getId());
			throw new InvalidRequestException("There is no Component ID in this call.");
		}

		String componentId = ajaxCall.getComponentId();
		if (componentId == null || componentId.isEmpty())
		{
			log.log(Level.FINER, "[SessionID]-[{0}];[Security]-[Component ID Incorrect]", request.getSession()
			                                                                                     .getId());
			//	throw new InvalidRequestException("Component ID Was Incorrect.");
		}
		return true;
	}

	/**
	 * Validates if the page is found and correct
	 *
	 * @return
	 *
	 * @throws com.jwebmp.exceptions.MissingComponentException
	 */
	public boolean validatePage() throws MissingComponentException
	{
		Page page = GuiceContext.inject()
		                        .getInstance(Page.class);
		if (page == null)
		{
			throw new MissingComponentException(
					"Page has not been bound yet. Please use a binder to map Page to the required page object. Also consider using a @Provides method to apply custom logic. See https://github.com/google/guice/wiki/ProvidesMethods ");
		}
		return true;
	}

	/**
	 * Validates the request if it from a legitimate source
	 *
	 * @param ajaxCall
	 *
	 * @return
	 *
	 * @throws InvalidRequestException
	 */
	public boolean validateRequest(AjaxCall ajaxCall) throws InvalidRequestException
	{
		HttpServletRequest request = GuiceContext.getInstance(HttpServletRequest.class);
		Date datetime = ajaxCall.getDatetime();
		if (datetime == null)
		{
			log.log(Level.SEVERE, "[SessionID]-[{0}];[Security]-[Date Time Incorrect]", request.getSession()
			                                                                                   .getId());
			throw new InvalidRequestException("Invalid Date Time Value");
		}
		EventTypes eventType = ajaxCall.getEventType();
		if (eventType == null)
		{
			log.log(Level.SEVERE, "[SessionID]-[{0}];[Security]-[Event Type Incorrect]", request.getSession()
			                                                                                    .getId());
			throw new InvalidRequestException("Invalid Event Type");
		}
		EventTypes eventTypeFrom = ajaxCall.getEventTypeFrom();
		if (eventTypeFrom == null)
		{
			log.log(Level.SEVERE, "[SessionID]-[{0}];[Security]-[Event From Incorrect]", request.getSession()
			                                                                                    .getId());
			throw new InvalidRequestException("Invalid Event Type From");
		}

		AjaxEventValue value = ajaxCall.getValue();

		if (value == null)
		{
			log.log(Level.SEVERE, "[SessionID]-[{0}];[Security]-[Value Is Missing]", request.getSession()
			                                                                                .getId());
			throw new InvalidRequestException("Invalid Event Value");
		}

		return true;
	}

	/**
	 * Generates the Page HTML
	 *
	 * @return
	 */
	protected StringBuilder getPageHTML()
	{
		StringBuilder html;
		html = new StringBuilder(getPageFromGuice().toString(true));
		return html;
	}

	/**
	 * Finds the page for the current URL
	 *
	 * @return
	 */
	protected Page getPageFromGuice()
	{
		return GuiceContext.inject()
		                   .getInstance(Page.class);
	}

	/**
	 * Return the Mobile Page HTML
	 *
	 * @param session
	 *
	 * @return
	 */
	@Provides
	@Named("MobilePage")
	@RequestScoped
	protected StringBuilder getPageMobileHTML(HttpSession session)
	{
		log.log(Level.FINE, "Started Rendering Mobile HTML");
		StringBuilder html;
		html = new StringBuilder(getPageFromGuice().toString(true));
		return html;
	}

	/**
	 * Does a default security check on the request
	 *
	 * @param req
	 * @param resp
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	{
		try
		{
			processRequest(req, resp);
			perform();
		}
		catch (Exception e)
		{
			log.log(Level.SEVERE, "Unable to Do Get", e);
		}
	}

	/**
	 * Processes requests for the WebSwing Servlet.
	 *
	 * @param request
	 * 		The Default Servlet request
	 * @param response
	 * 		The Default Servlet response
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			readRequestVariables(request);
			readBrowserInformation(request);
		}
		catch (MissingComponentException mce)
		{
			log.log(Level.SEVERE, "No Page For Servlet", mce);
			Page p = new Page();
			p.getBody()
			 .add("No Page or Body Configured for the JWebSwingServlet. [getPage()] returned nothing");
			writeOutput(new StringBuilder(p.toString(0)), HTML_HEADER_DEFAULT_CONTENT_TYPE, UTF8_CHARSET);
		}
		catch (Exception t)
		{
			log.log(Level.SEVERE, "Unable to render page", t);
			response.setContentType(StaticStrings.HTML_HEADER_DEFAULT_CONTENT_TYPE);
			writeOutput(new StringBuilder(getErrorPageHtml(t).toString(0)), HTML_HEADER_DEFAULT_CONTENT_TYPE, UTF8_CHARSET);
		}
	}

	/**
	 * When to perform any commands
	 */
	public abstract void perform();

	/**
	 * Reads the variables into the HTTP session
	 *
	 * @param request
	 *
	 * @throws com.jwebmp.exceptions.MissingComponentException
	 */
	protected void readRequestVariables(HttpServletRequest request) throws MissingComponentException
	{
		Page currentPage = getPageFromGuice();
		HttpSession session = GuiceContext.inject()
		                                  .getInstance(HttpSession.class);
		if (currentPage == null)
		{
			throw new MissingComponentException("[No Page]-[getPage() returning null in servlet class]");
		}
		if (session.isNew())
		{
			log.log(Level.FINER, "[SessionID]-[{0}];[Name]-[User Login];[Action]-[Session Page Added];", request.getSession()
			                                                                                                    .getId());
		}
	}

	/**
	 * Reads the user agent header into the browser object and places it for the page to render
	 *
	 * @param request
	 */
	protected void readBrowserInformation(HttpServletRequest request)
	{
		String headerInformation = request.getHeader("User-Agent");
		ReadableUserAgent agent = GuiceContext.inject()
		                                      .getInstance(UserAgentStringParser.class)
		                                      .parse(headerInformation);
		getPageFromGuice().setUserAgent(agent);
		Browsers b;
		if (agent.getVersionNumber()
		         .getMajor()
		         .isEmpty() && agent.getVersionNumber()
		                            .getMinor()
		                            .isEmpty())
		{
			b = Browsers.getBrowserFromNameAndVersion("Edge", 13);
		}
		else
		{
			b = Browsers.getBrowserFromNameAndVersion(agent.getName(), Double.parseDouble(agent.getVersionNumber()
			                                                                                   .getMajor() + StaticStrings.STRING_DOT + agent.getVersionNumber()
			                                                                                                                                 .getMinor()));
		}
		getPageFromGuice().setBrowser(b);

		if (agent.getVersionNumber()
		         .getMajor() == null || agent.getVersionNumber()
		                                     .getMajor()
		                                     .isEmpty())
		{
			log.log(Level.INFO, "[SessionID]-[{0}];[Browser]-[{1}];[Version]-[{2}];[Operating System]-[{3}];[Device Category]-[{4}];[Device]-[{5}];[CSS]-[{6}];[HTML]-[{7}];",
			        new Object[]{request.getSession().getId(), b.getBrowserGroup().toString(), b.getBrowserVersion(), agent.getOperatingSystem().getName(), agent.getDeviceCategory().getCategory(), agent.getDeviceCategory().getName(), b.getCapableCSSVersion(), b.getHtmlVersion()});
		}
		else
		{
			log.log(Level.INFO, "[SessionID]-[{0}];[Browser]-[{1}];[Version]-[{2}.{3}];[Operating System]-[{4}];[Device Category]-[{5}];[Device]-[{6}];[CSS]-[{7}];[HTML]-[{8}];",
			        new Object[]{request.getSession().getId(), agent.getName(), agent.getVersionNumber().getMajor(), agent.getVersionNumber().getMinor(), agent.getOperatingSystem().getName(), agent.getDeviceCategory().getCategory(), agent.getDeviceCategory().getName(), b.getCapableCSSVersion(), b.getHtmlVersion()});
		}
	}

	/**
	 * Writes the output to the request
	 *
	 * @param output
	 */
	public void writeOutput(StringBuilder output, String contentType, Charset charSet)
	{
		HttpServletResponse response = GuiceContext.getInstance(HttpServletResponse.class);
		try (PrintWriter out = response.getWriter())
		{
			Date dataTransferDate = new Date();
			response.setContentType(contentType);
			response.setCharacterEncoding(charSet == null ? Charset.forName("UTF-8")
			                                                       .toString() : charSet.displayName());
			response.setHeader(StaticStrings.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER_NAME, allowOrigin);
			response.setHeader(StaticStrings.ACCESS_CONTROL_ALLOW_CREDENTIALS_HEADER_NAME, "true");
			response.setHeader(StaticStrings.ACCESS_CONTROL_ALLOW_METHODS_HEADER_NAME, "GET, POST");
			response.setHeader(StaticStrings.ACCESS_CONTROL_ALLOW_HEADERS_HEADER_NAME, "Content-Type, Accept");
			out.write(output.toString());

			long transferTime = new Date().getTime() - dataTransferDate.getTime();
			log.log(Level.FINER, "[Network Reply Data Size]-[" + output.length() + "];");
			log.log(Level.FINER, "[Network Reply]-[" + output + "];[Time]-[" + transferTime + "];");
		}
		catch (IOException io)
		{
			log.log(Level.SEVERE, "Unable to send response to client", io);
		}
	}

	/**
	 * In the event of any error return this page.
	 *
	 * @param t
	 * 		The exception thrown
	 *
	 * @return The rendered HTML.
	 */
	protected Page getErrorPageHtml(Throwable t)
	{
		Page p = new Page();
		p.getPageFields()
		 .setTitle("Exception occured in application");
		p.getPageFields()
		 .setAuthor("Marc Magon");
		p.getPageFields()
		 .setDescription("JWebSwing Error Generated Page");
		p.getPageFields()
		 .setGenerator("JWebSwing - https://sourceforge.net/projects/jwebswing/");
		Body b = p.getBody();
		b.add("The following error was encountered during render<br/><hr/>");
		b.add(new PreFormattedText(TextUtilities.stackTraceToString(t)));
		return p;
	}

	/**
	 * Does a default security check on the request
	 *
	 * @param req
	 * @param resp
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	{
		try
		{
			validate(req);
			processRequest(req, resp);
			perform();
		}
		catch (Exception e)
		{
			log.log(Level.SEVERE, "Security Exception in Validation", e);
		}
	}

	/**
	 * Validates the session
	 *
	 * @param request
	 * 		The physical request
	 *
	 * @throws javax.servlet.ServletException
	 * 		When any security check fails
	 */
	public void validate(HttpServletRequest request) throws ServletException
	{
		HttpSession session = request.getSession();
		String sessionID = session.getId();
		if (sessionID == null)
		{
			log.log(Level.SEVERE, "Session Doesn't Exist", new ServletException("There is no session for a data pull"));
			throw new ServletException("There is no session for a data pull");
		}
	}

	@SiteInterception
	@AjaxCallInterception
	protected void intercept()
	{
		/**
		 * Intercepted with the annotations
		 */
	}
}
