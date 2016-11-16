package za.co.mmagon.jwebswing.htmlbuilder.effects;

import za.co.mmagon.jwebswing.generics.Direction;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptPartType;

/**
 * This is the universal easing animation object JavaScript part
 * <p>
 * @since 2014 07 29
 * @version 1.0
 * @author MMagon
 *
 * <p>
 */
public class JWAnimationEffectsPart extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    private EasingEffects easing;
    private Integer duration;
    private Direction direction;

    public JWAnimationEffectsPart()
    {
    }

    /**
     * Construct a new animation effects part using the supplies parameters
     * <p>
     * @param easing    The actual animation to apply
     * @param duration  The duration in ms to apply
     * @param direction The direction in which to apply it
     */
    public JWAnimationEffectsPart(EasingEffects easing, Integer duration, Direction direction)
    {
        this.easing = easing;
        this.duration = duration;
        this.direction = direction;
    }

    /**
     * Construct a new animation effects part using the supplies parameters
     * <p>
     * @param easing The actual animation to apply
     */
    public JWAnimationEffectsPart(EasingEffects easing)
    {
        this.easing = easing;
    }

    /**
     * Construct a new animation effects part using the supplies parameters
     * <p>
     * @param easing   The actual animation to apply
     * @param duration The duration in ms to apply
     */
    public JWAnimationEffectsPart(EasingEffects easing, Integer duration)
    {
        this.easing = easing;
        this.duration = duration;
    }

    /**
     * Returns the animation effect applied
     * <p>
     * @return
     */
    public EasingEffects getEasing()
    {
        return easing;
    }

    /**
     * Sets the animation effect to apply
     * <p>
     * @param easing
     */
    public void setEasing(EasingEffects easing)
    {
        this.easing = easing;
    }

    /**
     * Gets the duration in ms applied
     * <p>
     * @return
     */
    public Integer getDuration()
    {
        return duration;
    }

    /**
     * Sets the duration in ms to apply
     * <p>
     * @param duration
     */
    public void setDuration(Integer duration)
    {
        this.duration = duration;
    }

    /**
     * Gets the direction for the animation to perform
     * <p>
     * @return
     */
    public Direction getDirection()
    {
        return direction;
    }

    /**
     * Sets the direction of the animation to perform
     * <p>
     * @param direction
     */
    public void setDirection(Direction direction)
    {
        this.direction = direction;
    }

    @Override
    public JavascriptPartType getJavascriptType()
    {
        return JavascriptPartType.Javascript;
    }

}
