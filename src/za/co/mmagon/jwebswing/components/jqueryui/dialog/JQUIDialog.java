package za.co.mmagon.jwebswing.components.jqueryui.dialog;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;

/**
 * A JQuery UI Panel with all bells
 *
 * @author Marc Magon
 */
public class JQUIDialog extends Div<JQUIDialogChildren, NoAttributes, JQUIDialogFeatures, JQUIDialogEvents, JQUIDialog>
{

    private static final long serialVersionUID = 1L;

    private final JQUIDialogFeature jwDialogFeature;
    private JQUIDialogOptions options;

    /**
     * Constructs a new JQuery Dialog with the given title as an attribute
     * <p>
     * @param title The title to build with
     */
    public JQUIDialog(String title)
    {
        jwDialogFeature = new JQUIDialogFeature(this);
        addFeature(jwDialogFeature);
        addAttribute(GlobalAttributes.Title, title);
    }

    /**
     * Instantiates the options on call
     * <p>
     * @return
     */
    public JQUIDialogOptions getOptions()
    {
        if (options == null)
        {
            options = new JQUIDialogOptions();
        }
        return options;
    }
}
