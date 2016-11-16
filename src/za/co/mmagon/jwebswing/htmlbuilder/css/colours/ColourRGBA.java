package za.co.mmagon.jwebswing.htmlbuilder.css.colours;

import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSAnnotationType;

/**
 *
 * @author Marc Magon
 */
@CSSAnnotationType
public @interface ColourRGBA
{

    public int Red() default 0;

    public int Green() default 0;

    public int Blue() default 0;

    public int Alpha() default 0;
}
