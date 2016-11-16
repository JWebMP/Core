/*
 * Copyright (C) 2016 GedMarc
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

package za.co.mmagon.jwebswing.components.bootstrap.themes.sbadmin2.chat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.Image;
import za.co.mmagon.jwebswing.base.html.ListItem;
import za.co.mmagon.jwebswing.base.html.SmallText;
import za.co.mmagon.jwebswing.base.html.Span;
import za.co.mmagon.jwebswing.base.html.Strong;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.components.fontawesome.FontAwesome;
import za.co.mmagon.jwebswing.components.fontawesome.FontAwesomeIcons;
import za.co.mmagon.jwebswing.components.fontawesome.FontAwesomeProperties;
import za.co.mmagon.jwebswing.components.bootstrap.BootstrapClasses;
import za.co.mmagon.jwebswing.components.bootstrap.themes.sbadmin2.SB2ThemeClasses;
import za.co.mmagon.jwebswing.components.moment.Moment;

/**
 * A SB2 chat message that is aligned to the left
 * 
 * @author GedMarc
 * @since Oct 17, 2016
 * @version 1.0
 * 
 */
public class SB2ChatLeftMessage extends ListItem implements ISB2ChatMessage
{

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private Span messageImageSpan; 
    @JsonIgnore
    private Image messageImage;
    @JsonIgnore
    private Div chatBody;
    @JsonIgnore
    private Div chatBodyHeader;
    
    /**
     * A Chat message that is left aligned
     */
    public SB2ChatLeftMessage ()
    {
        addClass(BootstrapClasses.Left);
        addClass(BootstrapClasses.Clearfix);
    }

    @Override
    public void preConfigure()
    {
        if(!isConfigured())
        {
            getMessageImageSpan().add(getMessageImage());
            add(getMessageImageSpan());
            
            Strong headerStrong = new Strong(headerText);
            headerStrong.addClass(BootstrapClasses.Primary_Font);
            
            getChatBodyHeader().add(headerStrong);
            SmallText st = new SmallText();
            Moment m = new Moment(messageDate,ComponentTypes.Span);
            st.addClass(BootstrapClasses.Pull_Right);
            st.addClass(BootstrapClasses.Text_Muted);
            FontAwesome clockIcon = FontAwesome.icon(FontAwesomeIcons.clock_o, FontAwesomeProperties.fw);
            
            st.add(clockIcon);
            st.add(m);
            
            getChatBodyHeader().add(st);
            
            //getChatBody().add(getChatBodyHeader());
            getChatBody().add(message);
            
            add(getChatBody());
        }
        
        super.preConfigure();
    }
    
    /**
     * The actual header text
     */
    public String headerText;
    /**
     * The date for the message
     */
    public Date messageDate;
    /**
     * The actual message
     */
    public String message;

    /**
     * Returns this message image
     * @return 
     */
    public Image getMessageImage()
    {
        if(this.messageImage == null)
        {
            setMessageImage(new Image("http://placehold.it/50/55C1E7/fff"));
        }
        return messageImage;
    }

    /**
     * Sets the image for the message
     * @param messageImage 
     */
    public void setMessageImage(Image messageImage)
    {
        this.messageImage = messageImage;
        if(this.messageImage != null)
        {
            this.messageImage.addClass(BootstrapClasses.Img_Circle);
        }
    }

    /**
     * Returns the container span for the message image
     * @return 
     */
    public Span getMessageImageSpan()
    {
        if(messageImageSpan == null)
        {
            setMessageImageSpan(new Span());
        }
        return messageImageSpan;
    }

    /**
     * Sets the container span for the message image
     * @param messageImageSpan 
     */
    public void setMessageImageSpan(Span messageImageSpan)
    {
        this.messageImageSpan = messageImageSpan;
        if(this.messageImageSpan != null)
        {
            this.messageImageSpan.addClass(SB2ThemeClasses.Chat_Img);
            this.messageImageSpan.addClass(BootstrapClasses.Pull_Left);
        }
    }
    
    /**
     * Gets the text for the header
     * @return 
     */
    public String getHeaderText()
    {
        return headerText;
    }

    /**
     * Sets the text for the header
     * @param headerText 
     */
    public void setHeaderText(String headerText)
    {
        this.headerText = headerText;
    }

    /**
     * Returns the assigned message ate
     * @return 
     */
    public Date getMessageDate()
    {
        return messageDate;
    }

    /**
     * Sets the assigned message date
     * @param messageDate 
     */
    public void setMessageDate(Date messageDate)
    {
        this.messageDate = messageDate;
    }

    /**
     * Returns the message
     * @return 
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * Sets the message
     * @param message 
     */
    public void setMessage(String message)
    {
        this.message = message;
    }

    /**
     * Returns the given chat body
     * @return 
     */
    public Div getChatBody()
    {
        if(chatBody == null)
        {
            setChatBody(new Div());
        }
        return chatBody;
    }

    /**
     * Sets the given chat body
     * @param chatBody 
     */
    public void setChatBody(Div chatBody)
    {
        this.chatBody = chatBody;
        if(this.chatBody != null)
        {
            this.chatBody.addClass(SB2ThemeClasses.Chat_Body);
            this.chatBody.addClass(BootstrapClasses.Clearfix);
        }
    }
    /**
     * Returns the div that contains the body header
     * @return 
     */
    public Div getChatBodyHeader()
    {
        if(chatBodyHeader == null)
        {
            setChatBodyHeader(new Div());
        }
        return chatBodyHeader;
    }

    /**
     * Sets the chat body header
     * @param chatBodyHeader 
     */
    public void setChatBodyHeader(Div chatBodyHeader)
    {
        this.chatBodyHeader = chatBodyHeader;
        if(this.chatBodyHeader != null)
        {
            this.chatBodyHeader.addClass("header");
            getChatBody().add(this.chatBodyHeader);
        }
    }    
}
