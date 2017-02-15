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
package za.co.mmagon.jwebswing.base.ajax;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Denotes a specific reaction to occur at the client
 *
 * @author GedMarc
 * @since 27 Apr 2016
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AjaxResponseReaction
{

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
    /*
     * The level type of the reaction
     */
    @JsonProperty("type")
    private AjaxResponseType responseType;

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
     */
    public AjaxResponseReaction(String reactionData)
    {
        this(null, reactionData);
    }

    /**
     * Constructs a reaction with the given message
     *
     * @param reactionData
     * @param reactionType
     */
    public AjaxResponseReaction(String reactionData, ReactionType reactionType)
    {
        this(null, reactionData, reactionType);
    }

    /**
     * Constructs a reaction with the given parameters
     *
     * @param reactionTitle
     * @param reactionData
     * @param reactionType
     */
    public AjaxResponseReaction(String reactionTitle, String reactionData, ReactionType reactionType)
    {
        this(reactionTitle, reactionData, reactionType, null);
    }

    /**
     * Constructs a reaction with the given parameters
     *
     * @param reactionTitle The title if necessary
     * @param reactionData  The data if necessary (usually is)
     * @param reactionType  The specific reaction type (dialog, redirect etc)
     * @param responseType  The specific response type (info, danger, warning etc)
     */
    @SuppressWarnings("")
    public AjaxResponseReaction(String reactionTitle, String reactionData, ReactionType reactionType, AjaxResponseType responseType)
    {
        setReactionTitle(reactionTitle);
        setReactionData(reactionData);
        setReactionType(reactionType);
        setResponseType(responseType);
    }

    /**
     * Constructs a redirection response after the specific seconds
     *
     * @param reactionData  The URL to point to
     * @param actionTimeout After how long to do it in milliseconds
     */
    @SuppressWarnings("")
    public AjaxResponseReaction(String reactionData, int actionTimeout)
    {
        this(null, reactionData, ReactionType.RedirectUrl, null);
        setActionTimeout(actionTimeout);
    }

    /**
     * Constructs a reaction with the given title and message
     *
     * @param reactionTitle
     * @param reactionData
     */
    public AjaxResponseReaction(String reactionTitle, String reactionData)
    {
        this(reactionTitle, reactionData, null);
    }

    /**
     * Returns the given reaction title
     *
     * @return
     */
    public String getReactionTitle()
    {
        return reactionTitle;
    }

    /**
     * Sets the given reaction title
     *
     * @param reactionTitle
     *
     * @return
     */
    public AjaxResponseReaction setReactionTitle(String reactionTitle)
    {
        this.reactionTitle = reactionTitle;
        return this;
    }

    /**
     * Gets the reaction message
     *
     * @return
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
     *
     * @return
     */
    public AjaxResponseReaction setReactionData(String reactionData)
    {
        this.reactionData = reactionData;
        return this;
    }

    /**
     * Gets the reaction type
     *
     * @return
     */
    public ReactionType getReactionType()
    {
        return reactionType;
    }

    /**
     * Sets the reaction type
     *
     * @param reactionType
     *
     * @return
     */
    public AjaxResponseReaction setReactionType(ReactionType reactionType)
    {
        this.reactionType = reactionType == null ? ReactionType.DialogDisplay : reactionType;
        return this;
    }

    /**
     * Gets the response type for the reaction
     *
     * @return
     */
    public AjaxResponseType getResponseType()
    {
        return responseType;
    }

    /**
     * Sets the response type for the reaction
     *
     * @param responseType
     *
     * @return
     */
    public AjaxResponseReaction setResponseType(AjaxResponseType responseType)
    {
        this.responseType = responseType == null ? AjaxResponseType.Info : responseType;
        return this;
    }

    /**
     * Apply a timeout before a navigation reaction occurs
     *
     * @return
     */
    public int getActionTimeout()
    {
        return actionTimeout;
    }

    /**
     * Apply a timeout before a navigation reaction occurs
     *
     * @param actionTimeout
     *
     * @return
     */
    public AjaxResponseReaction setActionTimeout(int actionTimeout)
    {
        this.actionTimeout = actionTimeout;
        return this;
    }

}
