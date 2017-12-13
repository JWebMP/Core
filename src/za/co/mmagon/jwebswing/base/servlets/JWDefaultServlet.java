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
package za.co.mmagon.jwebswing.base.servlets;

import za.co.mmagon.guiceinjection.GuiceContext;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxEventValue;
import za.co.mmagon.jwebswing.exceptions.InvalidRequestException;
import za.co.mmagon.jwebswing.exceptions.MissingComponentException;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.enumerations.EventTypes;
import za.co.mmagon.logger.LogFactory;

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

import static za.co.mmagon.jwebswing.utilities.StaticStrings.*;

/**
 * Provides default methods for authentication authorization etc
 *
 * @author GedMarc
 * @version 1.0
 * @since Nov 14, 2016
 */
public abstract class JWDefaultServlet extends HttpServlet
{

	/**
	 * The Servlet base logger
	 */
	private static final Logger log = LogFactory.getInstance().getLogger("ServletBase");
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
			response.setCharacterEncoding(charSet == null ? Charset.forName("UTF-8").toString() : charSet.displayName());

			response.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN_HEADER_NAME, allowOrigin);
			response.setHeader(ACCESS_CONTROL_ALLOW_CREDENTIALS_HEADER_NAME, "true");
			response.setHeader(ACCESS_CONTROL_ALLOW_METHODS_HEADER_NAME, "GET, POST");
			response.setHeader(ACCESS_CONTROL_ALLOW_HEADERS_HEADER_NAME, "Content-Type, Accept");
			out.write(output.toString());
			long transferTime = new Date().getTime() - dataTransferDate.getTime();
			log.log(Level.FINE, "[Network Reply Data Size]-[" + output.length() + "];");
			log.log(Level.FINE, "[Network Reply]-[" + output + "];[Time]-[" + transferTime + "];");
		}
		catch (IOException io)
		{
			log.log(Level.SEVERE, "Unable to send response to client", io);
		}
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
			log.log(Level.SEVERE, "[SessionID]-[{0}];[Security]-[Component ID Not Found]", request.getSession().getId());
			throw new InvalidRequestException("There is no Component ID in this call.");
		}

		String componentId = ajaxCall.getComponentId();
		if (componentId == null || componentId.isEmpty())
		{
			log.log(Level.FINER, "[SessionID]-[{0}];[Security]-[Component ID Incorrect]", request.getSession().getId());
			throw new InvalidRequestException("Component ID Was Incorrect.");
		}
		return true;
	}

	/**
	 * Validates if the page is found and correct
	 *
	 * @return
	 *
	 * @throws MissingComponentException
	 */
	public boolean validatePage() throws MissingComponentException
	{
		Page page = GuiceContext.inject().getInstance(Page.class);
		if (page == null)
		{
			throw new MissingComponentException("Page has not been bound yet. Please use a binder to map Page to the required page object. Also consider using a @Provides method to apply custom logic. See https://github.com/google/guice/wiki/ProvidesMethods ");
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
			log.log(Level.SEVERE, "[SessionID]-[{0}];[Security]-[Date Time Incorrect]", request.getSession().getId());
			throw new InvalidRequestException("Invalid Date Time Value");
		}
		EventTypes eventType = ajaxCall.getEventType();
		if (eventType == null)
		{
			log.log(Level.SEVERE, "[SessionID]-[{0}];[Security]-[Event Type Incorrect]", request.getSession().getId());
			throw new InvalidRequestException("Invalid Event Type");
		}
		EventTypes eventTypeFrom = ajaxCall.getEventTypeFrom();
		if (eventTypeFrom == null)
		{
			log.log(Level.SEVERE, "[SessionID]-[{0}];[Security]-[Event From Incorrect]", request.getSession().getId());
			throw new InvalidRequestException("Invalid Event Type From");
		}

		AjaxEventValue value = ajaxCall.getValue();

		if (value == null)
		{
			log.log(Level.SEVERE, "[SessionID]-[{0}];[Security]-[Value Is Missing]", request.getSession().getId());
			throw new InvalidRequestException("Invalid Event Value");
		}

		return true;
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
			validate(req);
		}
		catch (ServletException e)
		{
			log.log(Level.SEVERE, "Unable to Do Get", e);
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
	public void validate(HttpServletRequest request)
			throws ServletException
	{
		HttpSession session = request.getSession();
		String sessionID = session.getId();
		if (sessionID == null)
		{
			log.log(Level.SEVERE, "Session Doesn't Exist", new ServletException("There is no session for a data pull"));
			throw new ServletException("There is no session for a data pull");
		}
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
		}
		catch (ServletException e)
		{
			log.log(Level.SEVERE, "Security Exception in Validation", e);
		}
	}
}
