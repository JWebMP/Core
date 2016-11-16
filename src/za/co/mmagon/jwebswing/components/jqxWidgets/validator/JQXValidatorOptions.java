/*
 * Copyright (C) 2015 GedMarc
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
package za.co.mmagon.jwebswing.components.jqxWidgets.validator;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.htmlbuilder.effects.EasingEffects;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptFunction;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXValidatorOptions extends JavaScriptPart
{

    private Boolean arrow;// 	Boolean 	true
    private EasingEffects animation;// 	String 	'fade'
    private Integer animationDuration;// 	Number 	150
    private Boolean closeOnClick;// 	Boolean 	true
    private Boolean focus;// 	Boolean 	true
    private JQXValidtorHintTypes hintType;// 	String 	"tooltip"
    private JavascriptFunction onError;// 	Function 	null
    private JavascriptFunction onSuccess;// 	Function 	null
    private JQXValidatorPositions position;// 	String 	'right'
    private ArrayList<JQXValidatorRules> rules;// 	Array 	[]
    private Boolean rtl;// 	Boolean 	false

    public JQXValidatorOptions()
    {

    }

    public Boolean getArrow()
    {
        return arrow;
    }

    public void setArrow(Boolean arrow)
    {
        this.arrow = arrow;
    }

    public EasingEffects getAnimation()
    {
        return animation;
    }

    public void setAnimation(EasingEffects animation)
    {
        this.animation = animation;
    }

    public Integer getAnimationDuration()
    {
        return animationDuration;
    }

    public void setAnimationDuration(Integer animationDuration)
    {
        this.animationDuration = animationDuration;
    }

    public Boolean getCloseOnClick()
    {
        return closeOnClick;
    }

    public void setCloseOnClick(Boolean closeOnClick)
    {
        this.closeOnClick = closeOnClick;
    }

    public Boolean getFocus()
    {
        return focus;
    }

    public void setFocus(Boolean focus)
    {
        this.focus = focus;
    }

    public JQXValidtorHintTypes getHintType()
    {
        return hintType;
    }

    public void setHintType(JQXValidtorHintTypes hintType)
    {
        this.hintType = hintType;
    }

    public JavascriptFunction getOnError()
    {
        return onError;
    }

    public void setOnError(JavascriptFunction onError)
    {
        this.onError = onError;
    }

    public JavascriptFunction getOnSuccess()
    {
        return onSuccess;
    }

    public void setOnSuccess(JavascriptFunction onSuccess)
    {
        this.onSuccess = onSuccess;
    }

    public JQXValidatorPositions getPosition()
    {
        return position;
    }

    public void setPosition(JQXValidatorPositions position)
    {
        this.position = position;
    }

    public ArrayList<JQXValidatorRules> getRules()
    {
        return rules;
    }

    public void setRules(ArrayList<JQXValidatorRules> rules)
    {
        this.rules = rules;
    }

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

}
