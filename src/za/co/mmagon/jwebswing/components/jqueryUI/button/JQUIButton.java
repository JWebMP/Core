package za.co.mmagon.jwebswing.components.jqueryUI.button;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.ButtonAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineBeforeClosingTag;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineForRawText;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.components.jqueryLayout.layout.interfaces.JWLayoutDivChildren;
import za.co.mmagon.jwebswing.components.jqueryUI.accordion.JQUIAccordionChildren;
import za.co.mmagon.jwebswing.components.jqueryUI.radiobutton.JQUIRadioButtonGroupChildren;

/**
 * This class implements the JQuery UI implementation of a normal button
 *
 * @author MMagon
 * @since 09 Mar 2013
 * @version 1.0
 *
 * Update 2014/07/09 - Added attribute for identification in JQuery. Minimizing the JavaScript being sent through.
 */
public class JQUIButton extends Component<JQUIButtonChildren, ButtonAttributes, JQUIButtonFeatures, JQUIButtonEvents, JQUIButton>
        implements GlobalChildren, NoNewLineBeforeClosingTag, NoNewLineForRawText, JQUIRadioButtonGroupChildren, JQUIAccordionChildren, JWLayoutDivChildren
{

    private static final long serialVersionUID = 1L;

    private JQUIButtonFeature feature;

    /**
     * Constructs a new JWButton
     */
    public JQUIButton()
    {
        this(null);
    }

    /**
     * Constructs a new Button of type button
     *
     * @param text
     */
    public JQUIButton(String text)
    {
        super(ComponentTypes.Button);
        setText(text);
        getFeature();
    }

    /**
     * Returns the button options from the feature
     *
     * @return
     */
    public JQUIButtonOptions getOptions()
    {
        return getFeature().getOptions();
    }

    /**
     * Returns the feature associated with this object
     *
     * @return
     */
    public final JQUIButtonFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQUIButtonFeature(this);
            addFeature(feature);
        }
        return feature;
    }

}
