/*
 * Copyright (C) 2026 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 */
package com.jwebmp.test.core.base;

import com.guicedee.modules.services.jsonrepresentation.JsonRenderException;
import com.jwebmp.core.base.html.Button;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.Paragraph;
import com.jwebmp.core.base.interfaces.IComponentBase;
import com.jwebmp.core.base.servlets.interfaces.IComponent;
import com.jwebmp.test.BaseTestClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Defines the supported JSON reconstruction contract for concrete HTML components.
 */
public class ComponentJsonRoundTripTest extends BaseTestClass
{
    @Test
    public void roundTripsComponentStateAndADeepMixedHierarchy()
    {
        Div source = new Div();
        source.setID("root");
        source.setText("Before children");
        source.addAttribute("data-purpose", "round-trip");
        source.addClass("card");
        source.addStyle("display", "block");
        source.getProperties().put("origin", "test");

        Div nested = new Div();
        nested.setID("nested");
        nested.add(new Paragraph<>("Nested paragraph"));
        source.add(nested);
        source.add(new Button<>("Save"));

        IComponent<?> result = IComponentBase.from(source.toJson());

        Assertions.assertInstanceOf(Div.class, result);
        Div restored = (Div) result;
        Assertions.assertEquals("root", restored.getID());
        Assertions.assertEquals("Before children", restored.getText());
        Assertions.assertEquals("round-trip", restored.getAttributes().get("data-purpose"));
        Assertions.assertTrue(restored.getClasses().contains("card"));
        Assertions.assertEquals("block", restored.getStyles().get("display"));
        Assertions.assertEquals("test", restored.getProperties().get("origin"));

        Assertions.assertEquals(2, restored.getChildren().size());
        Assertions.assertInstanceOf(Div.class, restored.getChildren().get(0));
        Assertions.assertInstanceOf(Button.class, restored.getChildren().get(1));

        Div restoredNested = (Div) restored.getChildren().get(0);
        Assertions.assertEquals("nested", restoredNested.getID());
        Assertions.assertEquals(1, restoredNested.getChildren().size());
        Assertions.assertInstanceOf(Paragraph.class, restoredNested.getChildren().getFirst());
        Assertions.assertEquals("Nested paragraph", ((Paragraph<?>) restoredNested.getChildren().getFirst()).getText());
    }

    @Test
    public void rejectsJsonWithoutAConcreteComponentClass()
    {
        Assertions.assertThrows(JsonRenderException.class, () -> IComponentBase.from("{}"));
    }

    @Test
    public void rejectsUnknownOrMalformedComponentJson()
    {
        Assertions.assertThrows(JsonRenderException.class,
                                () -> IComponentBase.from("{\"componentClass\":\"example.missing.Component\"}"));
        Assertions.assertThrows(JsonRenderException.class, () -> IComponentBase.from("not json"));
    }
}
