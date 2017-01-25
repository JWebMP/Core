/*
 * Copyright (C) 2015 Marc Magon
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
package za.co.mmagon.jwebswing.components.bootstrap.forms.groups;

import java.util.logging.Level;
import java.util.logging.Logger;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.ComponentHTMLBootstrapBase;
import za.co.mmagon.jwebswing.base.angular.AngularAttributes;
import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.base.html.attributes.InputTypes;
import za.co.mmagon.jwebswing.components.bootstrap.componentoptions.BSComponentDefaultOptions;
import za.co.mmagon.jwebswing.components.bootstrap.forms.BSForm;
import za.co.mmagon.jwebswing.components.bootstrap.forms.BSFormChildren;
import za.co.mmagon.jwebswing.components.bootstrap.forms.controls.BSFormSelectInput;
import za.co.mmagon.jwebswing.components.bootstrap.forms.controls.BSInput;
import za.co.mmagon.jwebswing.components.bootstrap.forms.groups.sets.BSFormInputGroup;
import za.co.mmagon.logger.LogFactory;

/**
 * An implementation of
 * <p>
 * @author Marc Magon
 * @param <T> Is a component and a valid form group child
 *
 * @since 17 Jan 2017
 * @version 1.0
 */
public class BSFormGroup<T extends ComponentHTMLBootstrapBase & BSFormGroupChildren> extends Div<BSFormGroupChildren, BSFormGroupAttributes, BSFormGroupFeatures, BSFormGroupEvents, BSFormGroup>
        implements BSFormChildren
{

    private static final Logger log = LogFactory.getLog("BSFormGroup");
    private static final long serialVersionUID = 1L;
    /**
     * The class name applied to the group when there is an error
     */
    public static String ERROR_CLASS = "has-error";
    /**
     * The class name applied to the group when there is a warning
     */
    public static String WARNING_CLASS = "has-warning";
    /**
     * The class anme applied to the group when there is success
     */
    public static String SUCCESS_CLASS = "has-success";

    /**
     * The associated feature
     */
    private BSFormGroupFeature feature;
    /**
     * The label
     */
    private Label label;
    /**
     * The label help text
     */
    private SmallText helpText;
    /**
     * The input component for the form group
     */
    private Component inputComponent;
    /**
     * If this group is shown as a row
     */
    private boolean asRow;
    /**
     * If this group is shown as inline
     */
    private boolean inline;
    /**
     * If angular validation is enabled
     */
    private boolean angularValidation;
    /**
     * The actual required message
     */
    private T requiredMessage;
    /**
     * The actual pattern message
     */
    private T patternMessage;
    /**
     * The minimum error message
     */
    private T minMessage;
    /**
     * The maximum error message
     */
    private T maxMessage;

    /**
     * Constructs a new instance
     *
     * @param label
     * @param inputComponent
     * @param helpText
     */
    public BSFormGroup(Label label, BSInput inputComponent, String helpText)
    {
        this.label = label;
        this.inputComponent = inputComponent;
        this.helpText = new SmallText(helpText);
        addClass(BSComponentFormGroupOptions.Form_Group);
    }

    /**
     * Constructs a new instance
     *
     * @param label
     * @param inputComponent
     * @param helpText
     */
    public BSFormGroup(Label label, BSFormSelectInput inputComponent, String helpText)
    {
        this.label = label;
        this.inputComponent = inputComponent;
        this.helpText = new SmallText(helpText);
        addClass(BSComponentFormGroupOptions.Form_Group);
    }

    /**
     * Constructs a new instance
     *
     * @param label
     * @param inputComponent
     * @param helpText
     */
    public BSFormGroup(Label label, TextArea inputComponent, String helpText)
    {
        this.label = label;
        this.inputComponent = inputComponent;
        this.helpText = new SmallText(helpText);
        addClass(BSComponentFormGroupOptions.Form_Group);
    }

    /**
     * Constructs a new instance
     *
     * @param label
     * @param inputComponent
     * @param helpText
     */
    public BSFormGroup(Label label, BSFormInputGroup inputComponent, String helpText)
    {
        this.label = label;
        this.inputComponent = inputComponent;
        this.helpText = new SmallText(helpText);
        addClass(BSComponentFormGroupOptions.Form_Group);
    }

    /**
     * Returns the feature if any is required
     *
     * @return
     */
    public final BSFormGroupFeature getFeature()
    {
        if (feature == null)
        {
            feature = new BSFormGroupFeature(this);
        }
        return feature;
    }

    /**
     * Returns the options if any is required
     *
     * @return
     */
    @Override
    public BSFormGroupOptions getOptions()
    {
        return getFeature().getOptions();
    }

    /**
     * Returns a label. There must always be a label
     *
     * @return
     */
    public Label getLabel()
    {
        if (label == null)
        {
            setLabel(new Label("Component Label"));
            label.addClass("sr-only");
        }
        return label;
    }

    /**
     * Sets the label to the given label
     *
     * @param label
     */
    public void setLabel(Label label)
    {
        this.label = label;
    }

    /**
     * Return the help text
     *
     * @return
     */
    public SmallText getHelpText()
    {
        if (helpText == null)
        {
            helpText = new SmallText();
        }
        return helpText;
    }

    /**
     * Sets the help text
     *
     * @param helpText
     */
    public void setHelpText(SmallText helpText)
    {
        this.helpText = helpText;
    }

    /**
     * Returns the input component
     *
     * @return
     */
    public Component getInputComponent()
    {
        if (inputComponent == null)
        {
            setInputComponent(new BSInput(InputTypes.Text));
        }
        return inputComponent;
    }

    /**
     * Sets the input component
     *
     * @param inputComponent
     */
    public void setInputComponent(BSInput inputComponent)
    {
        this.inputComponent = inputComponent;
    }

    /**
     * Sets the input component
     *
     * @param inputComponent
     */
    public void setInputComponent(BSFormSelectInput inputComponent)
    {
        this.inputComponent = inputComponent;
    }

    /**
     * Adds all the necessary items
     */
    @Override
    public void preConfigure()
    {
        if (!isConfigured())
        {
            if (isAsRow())
            {
                addClass("row");
                getLabel().addClass("col-2");
                getLabel().addClass("col-form-label");
                getInputComponent().addClass("col-10");
            }

            if (getLabel().getParent() == null)
            {
                getLabel().setForInputComponent(getInputComponent());
                add(getLabel());
            }

            if (getInputComponent().getParent() == null)
            {
                add((BSFormGroupChildren) getInputComponent());
            }

            getInputComponent().addAttribute(GlobalAttributes.Aria_Describedby, getHelpText().getID());
            if (!isInline())
            {
                getHelpText().addClass(BSComponentFormGroupOptions.Form_Text);
            }
            getHelpText().addClass(BSComponentDefaultOptions.Text_Muted);
            add(getHelpText());

            if (isAngularValidation())
            {
                getPage().getOptions().setAngularEnabled(true);
                BSForm referencedForm;
                if (BSForm.class.isAssignableFrom(getParent().getClass()))
                {
                    referencedForm = (BSForm) getParent();
                }
                else if (BSForm.class.isAssignableFrom(getParent().getParent().getClass()))
                {
                    referencedForm = (BSForm) getParent().getParent();
                }
                else
                {
                    log.log(Level.SEVERE, "Unable to map angular, hierarchy doesn't seem to be built right. Expecting a BSForm as a parent or parents-parent (fieldsets)");
                    referencedForm = new BSForm();
                    referencedForm.setID("InvalidForm");
                }

                referencedForm.addAttribute("novalidate", (String) null);
                referencedForm.setTag("ng-form");

                String formName = referencedForm.getID();
                String fieldName = "" + getInputComponent().getID() + "";

                addAttribute(AngularAttributes.ngInit, "formField = " + formName + "['" + fieldName + "'];");

                addAttribute(AngularAttributes.ngClass, "{'" + ERROR_CLASS + "':'formField.$invalid && !formField.$pristine',"
                        + "'" + SUCCESS_CLASS + "':'formField.$valid'"
                        + "}");

                if (getRequiredMessage() != null)
                {
                    getRequiredMessage().addAttribute(AngularAttributes.ngShow, "" + formName + "[" + fieldName + "].$error.required && !" + formName + "[" + fieldName + "].$pristine");
                    if (!isInline())
                    {
                        getRequiredMessage().addClass(BSComponentFormGroupOptions.Form_Text);
                        getRequiredMessage().addClass(BSComponentFormGroupOptions.Form_Control_Feedback);
                    }
                    getChildren().add(getRequiredMessage());
                }

                if (getPatternMessage() != null)
                {
                    getPatternMessage().addAttribute(AngularAttributes.ngShow, "" + formName + "[" + fieldName + "].$error.pattern && !" + formName + "[" + fieldName + "].$pristine");
                    if (!isInline())
                    {
                        getPatternMessage().addClass(BSComponentFormGroupOptions.Form_Text);
                        getPatternMessage().addClass(BSComponentFormGroupOptions.Form_Control_Feedback);
                    }
                    getChildren().add(getPatternMessage());
                }

                if (getMinMessage() != null)
                {
                    getMinMessage().addAttribute(AngularAttributes.ngShow, "" + formName + "[" + fieldName + "].$error.min && !" + formName + "[" + fieldName + "].$pristine");
                    if (!isInline())
                    {
                        getMinMessage().addClass(BSComponentFormGroupOptions.Form_Text);
                        getMinMessage().addClass(BSComponentFormGroupOptions.Form_Control_Feedback);
                    }
                    getChildren().add(getMinMessage());
                }

                if (getMaxMessage() != null)
                {
                    getMaxMessage().addAttribute(AngularAttributes.ngShow, "" + formName + "[" + fieldName + "].$error.max && !" + formName + "[" + fieldName + "].$pristine");
                    if (!isInline())
                    {
                        getMaxMessage().addClass(BSComponentFormGroupOptions.Form_Text);
                        getMaxMessage().addClass(BSComponentFormGroupOptions.Form_Control_Feedback);
                    }
                    getChildren().add(getMaxMessage());
                }
            }
        }
        super.preConfigure();
    }

    /**
     * If this form group must render as a row
     *
     * @return
     */
    public boolean isAsRow()
    {
        return asRow;
    }

    /**
     * If this group must render as a row
     *
     * @param asRow
     */
    public void setAsRow(boolean asRow)
    {
        this.asRow = asRow;
    }

    /**
     * If this group must render as inline
     *
     * @return
     */
    public boolean isInline()
    {
        return inline;
    }

    /**
     * If this group must render as inline
     *
     * @param inline
     */
    public void setInline(boolean inline)
    {
        this.inline = inline;
    }

    /**
     * Sets if this form group has validation attached
     *
     * @return
     */
    public boolean isAngularValidation()
    {
        return angularValidation;
    }

    /**
     * Sets if this form group has validation attached
     *
     * @param angularValidation
     *
     * @return
     */
    public BSFormGroup setAngularValidation(boolean angularValidation)
    {
        this.angularValidation = angularValidation;
        return this;
    }

    /**
     * Returns the component to be shown when there is a required error
     *
     * @return
     */
    public T getRequiredMessage()
    {
        return requiredMessage;
    }

    /**
     * Sets the component to be shown when there is a required error
     *
     * @param requiredMessage
     *
     * @return
     */
    public BSFormGroup setRequiredMessage(T requiredMessage)
    {
        this.requiredMessage = requiredMessage;
        return this;
    }

    /**
     * Sets the component to be shown when there is a pattern error
     *
     * @return
     */
    public T getPatternMessage()
    {
        return patternMessage;
    }

    /**
     * Sets the component to display when there is a pattern message
     *
     * @param patternMessage
     *
     * @return
     */
    public BSFormGroup setPatternMessage(T patternMessage)
    {
        this.patternMessage = patternMessage;
        return this;
    }

    /**
     * Returns the minimum reached message component
     *
     * @return
     */
    public T getMinMessage()
    {
        return minMessage;
    }

    /**
     * Sets the minimum reached message
     *
     * @param minMessage
     *
     * @return
     */
    public BSFormGroup setMinMessage(T minMessage)
    {
        this.minMessage = minMessage;
        return this;
    }

    /**
     * Sets the maximum reached message error
     *
     * @return
     */
    public T getMaxMessage()
    {
        return maxMessage;
    }

    /**
     * Sets the maximum reached message error
     *
     * @param maxMessage
     *
     * @return
     */
    public BSFormGroup setMaxMessage(T maxMessage)
    {
        this.maxMessage = maxMessage;
        return this;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 79 * hash + (this.getID().hashCode());
        return hash;
    }

}
