package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;
import za.co.mmagon.jwebswing.base.html.interfaces.ContainerType;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.children.AreaChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.BodyChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.ListItemChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.MapChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.generics.ParagraphChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.components.bootstrap.progressbar.bar.BSProgressBarDisplayChildren;
import za.co.mmagon.jwebswing.components.jqueryUI.dialog.JQUIDialogChildren;

/**
 * Definition and Usage<p>
 * <p>
 * The &gt;span&lt; tag is used to group inline-elements in a document.<p>
 * <p>
 * The &gt;span&lt; tag provides no visual change by itself.<p>
 * <p>
 * The &gt;span&lt; tag provides a way to add a hook to a part of a text or a part of a document.<p>
 * Browser Support<p>
 * Element
 * <p>
 * &gt;span&lt; Yes Yes Yes Yes Yes<p>
 * Tips and Notes<p>
 * <p>
 * Tip: When a text is hooked in a &gt;span&lt; element, you can style it with CSS, or manipulate it with JavaScript.<p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * NONE.<p>
 * <p>
 * @author Marc Magon
 * @since forever
 * @param <C> The children allowed
 * @param <A> The attributes allowed
 * @param <J> The component itself for cloning
 */
public class Span<C extends GlobalChildren, A extends Enum & AttributeDefinitions, J extends Component>
        extends Component<C, A, GlobalFeatures, GlobalEvents, J>
        implements BodyChildren, MapChildren, AreaChildren, ContainerType, JQUIDialogChildren, ParagraphChildren,BSProgressBarDisplayChildren,
                                                                                                                 ListItemChildren
{

    /**
     * Constructs a new instance of a Span item
     */
    public Span()
    {
        super(ComponentTypes.Span);
    }

    public Span(String text)
    {
        super(ComponentTypes.Span);
        setText(text);
    }
}
