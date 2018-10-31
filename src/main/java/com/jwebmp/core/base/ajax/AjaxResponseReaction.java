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
package com.jwebmp.core.base.ajax;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Denotes a specific reaction to occur at the client
 *
 * @author GedMarc
 * @since 27 Apr 2016
 */
@SuppressWarnings({"unused", "MissingClassJavaDoc"})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AjaxResponseReaction<J extends AjaxResponseReaction<J>>
		extends JavaScriptPart<J>

{

	/**
	 * Field serialVersionUID
	 */

	/**
	 * The title of the reaction
	 */
	@JsonProperty("reactionTitle")
	private String reactionTitle;
	/**
	 * The message of the reaction
	 */
	@JsonProperty("reactionMessage")
	private String reactionData;
	/**
	 * The actual reaction
	 */
	@JsonProperty("reactionType")
	private ReactionType reactionType;

	/**
	 * Field responseType
	 */
	@JsonProperty("type")
	private AjaxResponseType responseType;
	/**
	 * Any applicable options
	 */
	private JavaScriptPart<?> options;

	/**
	 * Action timeout for request
	 */
	private int actionTimeout;

	/**
	 * Constructs a response reaction
	 */
	public AjaxResponseReaction()
	{
		this(null);
	}

	/**
	 * Constructs a reaction with the given message as a dialog
	 *
	 * @param reactionData
	 * 		The data if necessary (usually is)
	 */
	public AjaxResponseReaction(String reactionData)
	{
		this(null, reactionData);
	}

	/**
	 * Constructs a reaction with the given title and message
	 *
	 * @param reactionTitle
	 * 		The title if necessary
	 * @param reactionData
	 * 		The data if necessary (usually is)
	 */
	public AjaxResponseReaction(String reactionTitle, String reactionData)
	{
		this(reactionTitle, reactionData, null);
	}

	/**
	 * Constructs a reaction with the given parameters
	 *
	 * @param reactionTitle
	 * 		The title if necessary
	 * @param reactionData
	 * 		The data if necessary (usually is)
	 * @param reactionType
	 * 		The specific response type (info, danger, warning etc)
	 */
	public AjaxResponseReaction(String reactionTitle, String reactionData, ReactionType reactionType)
	{
		this(reactionTitle, reactionData, reactionType, null);
	}

	/**
	 * Constructs a reaction with the given parameters
	 *
	 * @param reactionTitle
	 * 		The title if necessary
	 * @param reactionData
	 * 		The data if necessary (usually is)
	 * @param reactionType
	 * 		The specific reaction type (dialog, redirect etc)
	 * @param responseType
	 * 		The specific response type (info, danger, warning etc)
	 */
	public AjaxResponseReaction(String reactionTitle, String reactionData, ReactionType reactionType, AjaxResponseType responseType)
	{
		this(reactionTitle, reactionData, reactionType, responseType, null);
	}

	/**
	 * Constructs a reaction with the given parameters
	 *
	 * @param reactionTitle
	 * 		The title if necessary
	 * @param reactionData
	 * 		The data if necessary (usually is)
	 * @param reactionType
	 * 		The specific reaction type (dialog, redirect etc)
	 * @param responseType
	 * 		The specific response type (info, danger, warning etc)
	 * @param options
	 * 		Apply options, usually BootstrapDialogOptions for dialog displays
	 */
	public AjaxResponseReaction(String reactionTitle, String reactionData, ReactionType reactionType, AjaxResponseType responseType, JavaScriptPart<?> options)
	{
		setReactionTitle(reactionTitle);
		setReactionData(reactionData);
		setReactionType(reactionType);
		setResponseType(responseType);
		setOptions(options);
	}

	/**
	 * Constructs a reaction with the given message
	 *
	 * @param reactionData
	 * 		The data if necessary (usually is)
	 * @param reactionType
	 * 		The specific reaction type (dialog, redirect etc)
	 */
	public AjaxResponseReaction(String reactionData, ReactionType reactionType)
	{
		this(null, reactionData, reactionType);
	}

	/**
	 * Constructs a redirection response after the specific seconds
	 *
	 * @param reactionData
	 * 		The URL to point to
	 * @param actionTimeout
	 * 		After how long to do it in milliseconds
	 */
	@SuppressWarnings("")
	public AjaxResponseReaction(String reactionData, int actionTimeout)
	{
		this(null, reactionData, ReactionType.RedirectUrl, null);
		setActionTimeout(actionTimeout);
	}

	/**
	 * Returns the given reaction title
	 *
	 * @return The reactions title
	 */
	public String getReactionTitle()
	{
		return reactionTitle;
	}

	/**
	 * Sets the given reaction title
	 *
	 * @param reactionTitle
	 * 		The reactions title
	 *
	 * @return This object
	 */
	public AjaxResponseReaction setReactionTitle(String reactionTitle)
	{
		this.reactionTitle = reactionTitle;
		return this;
	}

	/**
	 * Gets the reaction message
	 *
	 * @return the reaction data
	 */
	public String getReactionData()
	{
		return reactionData;
	}

	/**
	 * *
	 * Sets the given reaction message
	 *
	 * @param reactionData
	 * 		Sets the data for the reaction
	 *
	 * @return This object
	 */
	public AjaxResponseReaction setReactionData(String reactionData)
	{
		this.reactionData = reactionData;
		return this;
	}

	/**
	 * Gets the reaction type
	 *
	 * @return The assigned reaction type
	 */
	public ReactionType getReactionType()
	{
		return reactionType;
	}

	/**
	 * Sets the reaction type
	 *
	 * @param reactionType
	 * 		Ses the reaction type or defaults to dialog display
	 *
	 * @return This object
	 */
	public AjaxResponseReaction setReactionType(ReactionType reactionType)
	{
		this.reactionType = reactionType == null ? ReactionType.DialogDisplay : reactionType;
		return this;
	}

	/**
	 * Gets the response type for the reaction
	 *
	 * @return The assigned response type
	 */
	public AjaxResponseType getResponseType()
	{
		return responseType;
	}

	/**
	 * Sets the response type for the reaction
	 *
	 * @param responseType
	 * 		Sets the response type or info by default
	 *
	 * @return This object
	 */
	public AjaxResponseReaction setResponseType(AjaxResponseType responseType)
	{
		this.responseType = responseType == null ? AjaxResponseType.Info : responseType;
		return this;
	}

	/**
	 * Apply a timeout before a navigation reaction occurs
	 *
	 * @return The timeout for the action to occur
	 */
	public int getActionTimeout()
	{
		return actionTimeout;
	}

	/**
	 * Apply a timeout before a navigation reaction occurs
	 *
	 * @param actionTimeout
	 * 		The timeout for the action to occur
	 *
	 * @return This object
	 */
	@SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
	public AjaxResponseReaction setActionTimeout(int actionTimeout)
	{
		this.actionTimeout = actionTimeout;
		return this;
	}

	/**
	 * Assigns options to the response
	 *
	 * @return Any assigned options as a java script part (json)
	 */
	public JavaScriptPart<?> getOptions()
	{
		return options;
	}

	/**
	 * Sets the options of the response
	 *
	 * @param options
	 * 		The assigned options as a java script part (json)
	 *
	 * @return This object
	 */
	public AjaxResponseReaction setOptions(JavaScriptPart<?> options)
	{
		this.options = options;
		return this;
	}
}
