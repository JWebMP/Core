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
package com.jwebmp.core.base.servlets;

import com.google.inject.Singleton;
import com.jwebmp.core.Page;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.ajax.*;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.core.base.servlets.options.AngularDataServletInitData;
import com.jwebmp.core.exceptions.InvalidRequestException;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.core.htmlbuilder.javascript.events.enumerations.EventTypes;
import com.jwebmp.core.utilities.StaticStrings;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.logger.LogFactory;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.sql.Date;
import java.time.ZonedDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.jwebmp.guicedinjection.GuiceContext.*;

/**
 * Handles angular data binding calls, registers variables for access. Can handle population, use event binding for call back.
 *
 * @author GedMarc
 * @since 20160607
 */
@Singleton
public class AngularDataServlet
		extends JWDefaultServlet
{
	private static final Logger LOG = LogFactory.getInstance()
	                                            .getLogger("AngularDataServlet");
	private static final long serialVersionUID = 1L;

	@Override
	public void perform()
	{
		HttpServletRequest request = GuiceContext.get(HttpServletRequest.class);
		LOG.log(Level.FINER, "[SessionID]-[{0}];[Connection]-[Data Call Connection Established]", request.getSession()
		                                                                                                 .getId());
		String componentId = "";
		StringBuilder jb;
		AngularDataServletInitData<?> initData;
		try
		{
			jb = new StringBuilder(IOUtils.toString(request.getInputStream(), "UTF-8"));
			initData = new JavaScriptPart<>().From(jb.toString(), AngularDataServletInitData.class);
			if (initData == null)
			{
				throw new InvalidRequestException("Could not extract the initial data from the information sent in");
			}
		}
		catch (Exception e)
		{
			Page p = getErrorPageHtml(e);
			writeOutput(new StringBuilder(p.toString(0)), StaticStrings.HTML_HEADER_DEFAULT_CONTENT_TYPE, StaticStrings.UTF8_CHARSET);
			return;
		}
		if (jb.length() > 0)
		{
			getInstance(SessionStorageProperties.class).setLocalStorage(initData.getLocalStorage());
			getInstance(SessionStorageProperties.class).setSessionStorage(initData.getSessionStorage());
			componentId = initData.getParameters()
			                      .get("objectId");
		}

		AjaxCall ajaxCall = getInstance(AjaxCall.class);
		ajaxCall.setParameters(initData.getParameters());
		ajaxCall.setComponentId(componentId);
		ajaxCall.setDatetime(Date.from(ZonedDateTime.now()
		                                            .toInstant()));
		ajaxCall.setEventType(EventTypes.data);
		if (componentId == null || componentId.isEmpty())
		{
			LOG.log(Level.FINER, "[SessionID]-[{0}];[Security]-[Component ID Incorrect]", request.getSession()
			                                                                                     .getId());
		}

		Page page = GuiceContext.inject()
		                        .getInstance(Page.class);
		ComponentHierarchyBase triggerComponent = null;
		if (ComponentTypes.Body.getComponentTag()
		                       .equals(ajaxCall.getComponentId()))
		{
			triggerComponent = page.getBody();
		}
		else
		{
			try
			{
				Class<? extends ComponentHierarchyBase> component = (Class<? extends ComponentHierarchyBase>) Class.forName(ajaxCall.getComponentId());
				triggerComponent = GuiceContext.get(component);
			}
			catch (Exception e)
			{
				Page p = getErrorPageHtml(e);
				writeOutput(new StringBuilder(p.toString(0)), StaticStrings.HTML_HEADER_DEFAULT_CONTENT_TYPE, StaticStrings.UTF8_CHARSET);
				return;
			}
		}
		ajaxCall.setComponent(triggerComponent);
		AjaxResponse<?> ajaxResponse = GuiceContext.inject()
		                                           .getInstance(AjaxResponse.class);
		try
		{
			intercept();
			page.onConnect(ajaxCall, ajaxResponse);
		}
		catch (Exception e)
		{
			ajaxResponse.addReaction(
					new AjaxResponseReaction("Error Performing Angular Data Request", ExceptionUtils.getStackTrace(e), ReactionType.DialogDisplay, AjaxResponseType.Danger));
			LOG.log(Level.SEVERE, "Unable to perform the data request", e);
		}

		ajaxResponse.getComponents()
		            .forEach(ComponentHierarchyBase::preConfigure);
		writeOutput(new StringBuilder(ajaxResponse.toString()), "application/json;charset=UTF-8", Charset.forName("UTF-8"));
	}
}
