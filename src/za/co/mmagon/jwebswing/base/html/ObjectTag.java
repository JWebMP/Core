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

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.ObjectAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineForRawText;
import za.co.mmagon.jwebswing.base.html.interfaces.children.ObjectTagChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &gt;object&lt; tag defines an embedded object within an HTML document. Use this element to embed multimedia (like audio, video, Java applets, ActiveX, PDF, and Flash) in your web pages.<p>
 * <p>
 * You can also use the &gt;object&lt; tag to embed another webpage into your HTML document.<p>
 * <p>
 * You can use the &gt;param&lt; tag to pass parameters to plugins that have been embedded with the &gt;object&lt; tag.<p>
 * Browser Support<p>
 * Element
 * <p>
 * &gt;object&lt; Yes Yes Yes Yes Yes<p>
 * Tips and Notes<p>
 * <p>
 * Note: An &gt;object&lt; element must appear inside the &gt;body&lt; element. The text between the &gt;object&lt; and &gt;/object&lt; is an alternate text, for browsers that do not support this
 * tag.<p>
 * <p>
 * Tip: For images use the &gt;img&lt; tag instead of the &gt;object&lt; tag.<p>
 * <p>
 * Tip: At least one of the "data" or "type" attribute MUST be defined.<p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * Some HTML 4.01 attributes are not supported in HTML5.<p>
 * <p>
 * The "form" attribute is new in HTML5.<p>
 * <p>
 * In HTML5, objects can be used and submitted in forms.<p>
 * <p>
 * In HTML5, objects can no longer appear inside the &gt;head&lt; element of a document.<p>
 * @author GedMarc
 * @param <J>
 *
 * @since Feb 9, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class ObjectTag<J extends ObjectTag>
        extends Component<ObjectTagChildren, ObjectAttributes, GlobalFeatures, GlobalEvents, J>
        implements NoNewLineForRawText
{

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public ObjectTag()
    {
        super(ComponentTypes.Object);
    }
}
