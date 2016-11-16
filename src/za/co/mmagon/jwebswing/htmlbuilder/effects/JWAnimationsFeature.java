package za.co.mmagon.jwebswing.htmlbuilder.effects;

import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.servlets.interfaces.IFeature;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author Marc Magon
 */
public class JWAnimationsFeature extends Feature<JavaScriptPart, JWAnimationsFeature> implements IFeature
{

    private EasingEffects openingEffect;
    private EasingEffects closingEffect;
    private int movementSpeed = 2500;

    /**
     * Creates an animation with a closing and opening effect at the movement speed in milliseconds
     *
     * @param openingEffect The effect to use on opening
     * @param closingEffect The effect to use on closing
     * @param movementSpeed The speed in ms
     */
    public JWAnimationsFeature(EasingEffects openingEffect, EasingEffects closingEffect, int movementSpeed)
    {
        super("animations");
        this.openingEffect = openingEffect;
        this.closingEffect = closingEffect;
        this.movementSpeed = movementSpeed;
        getJavascriptReferences().add(new JWAnimationsEasingJavascriptReference());
    }

    /**
     * Creates an animation with a closing and opening effect at 2500 milliseconds
     *
     * @param openingEffect The effect to use on opening
     * @param closingEffect The effect to use on closing
     *
     */
    public JWAnimationsFeature(EasingEffects openingEffect, EasingEffects closingEffect)
    {
        this(openingEffect, closingEffect, 2500);
    }

    /**
     * Creates an animation with a closing and opening effect at 2500 milliseconds
     *
     * @param effect Adds an effect to closing and opening with 2500 milliseconds
     *
     */
    public JWAnimationsFeature(EasingEffects effect)
    {
        this(effect, effect, 2500);
    }

    public EasingEffects getOpeningEffect()
    {
        return openingEffect;
    }

    public void setOpeningEffect(EasingEffects openingEffect)
    {
        this.openingEffect = openingEffect;
    }

    public EasingEffects getClosingEffect()
    {
        return closingEffect;
    }

    public void setClosingEffect(EasingEffects closingEffect)
    {
        this.closingEffect = closingEffect;
    }

    public int getMovementSpeed()
    {
        return movementSpeed;
    }

    public void setMovementSpeed(int movementSpeed)
    {
        this.movementSpeed = movementSpeed;
    }
}
