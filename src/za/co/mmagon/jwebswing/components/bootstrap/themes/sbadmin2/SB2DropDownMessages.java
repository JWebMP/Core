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
package za.co.mmagon.jwebswing.components.bootstrap.themes.sbadmin2;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.components.bootstrap.componentoptions.BSComponentDefaultOptions;
import za.co.mmagon.jwebswing.components.bootstrap.componentoptions.BSComponentColoursOptions;
import za.co.mmagon.jwebswing.components.moment.Moment;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * A shortcut class to building drop down message types
 *
 * @author GedMarc
 * @since Oct 4, 2016
 * @version 1.0
 *
 */
public class SB2DropDownMessages extends SB2DropDown
{

    private static final long serialVersionUID = 1L;

    private ArrayList<SB2DropDownMessage> messages;

    @Override
    public void preConfigure()
    {
        if (!isConfigured())
        {
            messages.stream().map((message)
                    -> 
                    {
                        ListItem li = new ListItem();
                        Link link = new Link("#");
                        Div topSection = new Div();
                        Moment date = new Moment(message.getDate(), ComponentTypes.Span);
                        
                        date.addClass(BSComponentDefaultOptions.Pull_Right);
                        date.addClass(BSComponentColoursOptions.Text_Muted);
                        topSection.add(new Bold(message.getName()));
                        topSection.add(date);
                        
                        Div messageSection = new Div();
                        messageSection.add(message.getMessage());
                        li.add(link);
                        link.add(topSection);
                        link.add(messageSection);
                        return li;
            }).forEach((li)
                    -> 
                    {
                        getDropDownContents().add(li);
            });
        }
        super.preConfigure();
    }

    /**
     * Construct a new sb admin 2 dropdown formatted as messages
     */
    public SB2DropDownMessages()
    {
        this(null);
    }

    /**
     * Construct a new sb admin 2 dropdown formatted as messages
     *
     * @param messages
     */
    public SB2DropDownMessages(ArrayList<SB2DropDownMessage> messages)
    {
        this.messages = messages;
        getDropDownContents().addClass(SB2ThemeClasses.DropDown_Messages);
    }

    /**
     * Returns the current messages
     *
     * @return
     */
    public ArrayList<SB2DropDownMessage> getMessages()
    {
        if (messages == null)
        {
            messages = new ArrayList<>();
        }
        return messages;
    }

    /**
     * Sets the current messages array list
     *
     * @param messages
     */
    public void setMessages(ArrayList<SB2DropDownMessage> messages)
    {
        this.messages = messages;
    }

    /**
     * Read from a URL
     * 
     * @param content
     * @return
     * @throws IOException
     */
    public static SB2DropDownMessages fromUrl(URL content) throws IOException
    {
        ArrayList list2 = JavaScriptPart.FromToList(content, SB2DropDownMessage[].class);
        SB2DropDownMessages messages = new SB2DropDownMessages(list2);
        messages.preConfigure();
        return messages;
    }
}
