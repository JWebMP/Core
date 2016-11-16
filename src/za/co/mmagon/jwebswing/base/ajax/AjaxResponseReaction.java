/*
 * Copyright (C) 2016 ged_m
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
    private String reactionTitle;
    /**
     * The message of the reaction
     */
    private String reactionMessage;
    /**
     * The actual reaction
     */
    private ReactionType reactionType = ReactionType.DialogDisplay;
    /*
     * The level type of the reaction
     */
    @JsonProperty("type")
    private AjaxResponseType responseType = AjaxResponseType.Info;

    /**
     * Action timeout for request
     */
    private int actionTimeout;

    /**
     * Constructs a response reaction
     */
    public AjaxResponseReaction()
    {
    }

    /**
     * Constructs a reaction with the given message
     *
     * @param reactionMessage
     */
    public AjaxResponseReaction(String reactionMessage)
    {
        this.reactionMessage = reactionMessage;
    }

    /**
     * Constructs a reaction with the given parameters
     *
     * @param reactionTitle
     * @param reactionMessage
     * @param reactionType
     */
    public AjaxResponseReaction(String reactionTitle, String reactionMessage, ReactionType reactionType)
    {
        this.reactionTitle = reactionTitle;
        this.reactionMessage = reactionMessage;
        this.reactionType = reactionType;
    }

    /**
     * Constructs a reaction with the given title and message
     *
     * @param reactionTitle
     * @param reactionMessage
     */
    public AjaxResponseReaction(String reactionTitle, String reactionMessage)
    {
        this.reactionTitle = reactionTitle;
        this.reactionMessage = reactionMessage;
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
     */
    public void setReactionTitle(String reactionTitle)
    {
        this.reactionTitle = reactionTitle;
    }

    /**
     * Gets the reaction message
     *
     * @return
     */
    public String getReactionMessage()
    {
        return reactionMessage;
    }

    /**
     * *
     * Sets the given reaction message
     *
     * @param reactionMessage
     */
    public void setReactionMessage(String reactionMessage)
    {
        this.reactionMessage = reactionMessage;
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
     */
    public void setReactionType(ReactionType reactionType)
    {
        this.reactionType = reactionType;
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
     */
    public void setResponseType(AjaxResponseType responseType)
    {
        this.responseType = responseType;
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
     */
    public void setActionTimeout(int actionTimeout)
    {
        this.actionTimeout = actionTimeout;
    }

}
