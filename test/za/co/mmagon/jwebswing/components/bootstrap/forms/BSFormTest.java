/*
 * Copyright (C) 2017 GedMarc
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
package za.co.mmagon.jwebswing.components.bootstrap.forms;

import org.junit.Test;
import za.co.mmagon.BaseTestClass;
import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.components.bootstrap.forms.controls.*;
import za.co.mmagon.jwebswing.components.bootstrap.forms.groups.BSFormGroup;
import za.co.mmagon.jwebswing.components.bootstrap.forms.groups.sets.*;

/**
 *
 * @author GedMarc
 */
public class BSFormTest extends BaseTestClass
{

    public BSFormTest()
    {
    }

    @Test
    public void testEmailForm()
    {
        BSForm form = new BSForm();
        form.setID("form");
        BSFormEmailInput emailForm = new BSFormEmailInput();
        emailForm.addAttribute("placeholder", "Email Entry");
        emailForm.setID("emailExample");
        BSFormGroup group = new BSFormGroup(new Label("label"), emailForm, "Help Text");
        group.setID("group");
        form.add(group);
        System.out.println(form.toString(true));
    }

    @Test
    public void testPasswordEntryForm()
    {
        BSForm form = new BSForm();
        form.setID("form");
        BSFormPasswordInput emailForm = new BSFormPasswordInput();
        emailForm.addAttribute("placeholder", "password Entry");
        emailForm.setID("emailExample");
        BSFormGroup group = new BSFormGroup(new Label("label"), emailForm, "Help Text");
        group.setID("group");
        form.add(group);
        System.out.println(form.toString(true));
    }

    @Test
    public void testSelectEntryForm()
    {
        BSForm form = new BSForm();
        form.setID("form");
        BSFormSelectInput emailForm = new BSFormSelectInput();
        emailForm.add(new Option("Option 1"));
        emailForm.addAttribute("placeholder", "password Entry");
        emailForm.setID("emailExample");
        BSFormGroup group = new BSFormGroup(new Label("label"), emailForm, "Help Text");
        group.setID("group");
        form.add(group);
        System.out.println(form.toString(true));
    }

    @Test
    public void testSelectMultipleEntryForm()
    {
        BSForm form = new BSForm();
        form.setID("form");
        BSFormSelectInput emailForm = new BSFormSelectInput(true);
        emailForm.add(new Option("Option 1"));
        emailForm.addAttribute("placeholder", "password Entry");
        emailForm.setID("emailExample");
        BSFormGroup group = new BSFormGroup(new Label("label"), emailForm, "Help Text");
        group.setID("group");
        form.add(group);
        System.out.println(form.toString(true));
    }

    @Test
    public void testTextArea()
    {
        BSForm form = new BSForm();
        form.setID("form");
        BSFormTextAreaInput emailForm = new BSFormTextAreaInput(3);
        emailForm.setID("emailExample");
        BSFormGroup group = new BSFormGroup(new Label("label"), emailForm, "Help Text");
        group.setID("group");
        form.add(group);
        System.out.println(form.toString(true));
    }

    @Test
    public void testFileInput()
    {
        BSForm form = new BSForm();
        form.setID("form");
        BSFormFileInput emailForm = new BSFormFileInput();
        emailForm.setID("emailExample");
        BSFormGroup group = new BSFormGroup(new Label("label"), emailForm, "Help Text");
        group.setID("group");
        form.add(group);
        System.out.println(form.toString(true));
    }

    @Test
    public void testFieldSet()
    {
        BSForm form = new BSForm();
        form.setID("form");
        BSFormSet fieldSet = new BSFormSet();
        form.add(fieldSet);

        BSFormSetLegend legend = new BSFormSetLegend("legend text");
        fieldSet.add(legend);

        BSFormCheckGroup radioGroup = new BSFormCheckGroup(new Label("radioGroup"), new BSFormRadioInput("group 1"), "help text", "value");
        fieldSet.add(radioGroup);

        BSFormCheckboxInput check = new BSFormCheckboxInput("checkbox");
        BSFormCheckGroup checkGroup = new BSFormCheckGroup(new Label("checkboxGroup"), check, "help text", "value");
        fieldSet.add(checkGroup);

        System.out.println(form.toString(true));

    }

    @Test
    public void testInputColour()
    {
        BSFormColourInput input = new BSFormColourInput();
        input.setID("input");
        input.toString(true);
        BSFormGroup group = new BSFormGroup(new Label("input"), input, null);
        group.setID("group");
        System.out.println(group.toString(true));
    }

    @Test
    public void testInputCDate()
    {
        BSFormDateInput input = new BSFormDateInput();
        input.setID("input");
        input.toString(true);
        BSFormGroup group = new BSFormGroup(new Label("input"), input, null);
        group.setID("group");

        System.out.println(group.toString(true));
    }

    @Test
    public void testAngular()
    {
        BSForm form = new BSForm();
        BSFormDateInput input = new BSFormDateInput();
        input.setID("input");
        input.toString(true);
        BSFormGroup group = new BSFormGroup(new Label("input"), input, null);
        group.setID("group");
        group.setAngularValidation(true);

        group.setPatternMessage(new Div("test pattern message"));
        group.setRequiredMessage(new Div("test required message"));
        group.setMinMessage(new Div("test min message"));
        group.setMaxMessage(new Div("test max message"));

        form.add(group);
        System.out.println(form.toString(true));
    }
}
