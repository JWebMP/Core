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
package com.jwebmp.test.core.base;

import com.jwebmp.test.BaseTestClass;
import com.jwebmp.core.base.ComponentBase;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.Paragraph;
import com.jwebmp.core.base.interfaces.IComponentBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.core.base.servlets.interfaces.IComponent;
import com.guicedee.modules.services.jsonrepresentation.IJsonRepresentation;
import com.guicedee.modules.services.jsonrepresentation.JsonRenderException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.JsonNode;

/**
 * @author ged_m
 */
public class ComponentBaseTest
		extends BaseTestClass
{

	public ComponentBaseTest()
	{
	}

	@Test
	public void testShell()
	{
		ComponentBase shell = new ComponentBase(ComponentTypes.Abbreviation);
		shell.setID("ID");
		System.out.println(shell);
		assertBaseJson(shell, "ID", false, null);
	}

	@Test
	public void testShellRawText()
	{
		ComponentBase shell = new ComponentBase(ComponentTypes.Abbreviation);
		shell.setID("ID");
		shell.setText("This is raw text");
		System.out.println(shell);
		assertBaseJson(shell, "ID", false, "This is raw text");
	}

	@Test
	public void testShellTiny()
	{
		ComponentBase shell = new ComponentBase(ComponentTypes.Abbreviation);
		shell.setTiny(true);
		shell.setID("ID");
		System.out.println(shell);
		assertBaseJson(shell, "ID", true, null);
	}

	@Test
	public void testClone()
	{
		ComponentBase shell = new ComponentBase(ComponentTypes.Abbreviation);
		shell.setID("shell");
		ComponentBase shell2 = shell.cloneComponent();
		shell2.setID("shell2");
		System.out.println(shell);
		System.out.println(shell2);
		assertBaseJson(shell, "shell", false, null);
		assertBaseJson(shell2, "shell2", false, null);
	}

	@Test
	public void testProperties()
	{
		ComponentBase shell = new ComponentBase(ComponentTypes.Abbreviation);
		shell.setID("shell");
		shell.getProperties()
		     .put("Property1", "Value 1");
		System.out.println(shell);

		assertBaseJson(shell, "shell", false, null);
		Assertions.assertEquals("Value 1", json(shell).get("properties").get("Property1").asText());
	}

	@Test
	public void fromJsonCreatesTheDeclaredComponent()
	{
		Div source = new Div();
		source.setID("component-from-json");
		source.setText("Round trip component");
		source.getProperties().put("source", "ComponentBaseTest");
		source.add(new Paragraph<>("Nested child"));

		IComponent<?> result = IComponentBase.from(source.toJson());

		Assertions.assertInstanceOf(Div.class, result);
		Div<?, ?, ?, ?, ?> component = (Div<?, ?, ?, ?, ?>) result;
		Assertions.assertEquals("component-from-json", component.getID());
		Assertions.assertEquals("Round trip component", component.getText());
		Assertions.assertEquals("ComponentBaseTest", component.getProperties().get("source"));
		Assertions.assertEquals(1, component.getChildren().size());
		Assertions.assertInstanceOf(Paragraph.class, component.getChildren().getFirst());
	}

	@Test
	public void fromJsonRejectsClassesThatAreNotComponents()
	{
		String json = "{\"componentClass\":\"java.lang.String\"}";

		Assertions.assertThrows(JsonRenderException.class, () -> IComponentBase.from(json));
	}

	private void assertBaseJson(ComponentBase<?> component, String id, boolean tiny, String text)
	{
		JsonNode json = json(component);
		Assertions.assertEquals(id, json.get("id").asText());
		Assertions.assertEquals("abbreviation", json.get("componentType").asText());
		Assertions.assertEquals(tiny, json.get("tiny").asBoolean());
		Assertions.assertTrue(json.get("configured").asBoolean());
		Assertions.assertTrue(json.get("initialized").asBoolean());
		Assertions.assertFalse(json.get("touched").asBoolean());
		Assertions.assertEquals(ComponentBase.class.getCanonicalName(), json.get("componentClass").asText());
		if (text == null)
		{
			Assertions.assertNull(json.get("text"));
		}
		else
		{
			Assertions.assertEquals(text, json.get("text").asText());
		}
	}

	private JsonNode json(ComponentBase<?> component)
	{
		try
		{
			return IJsonRepresentation.getObjectMapper().readTree(component.toJson());
		}
		catch (Exception e)
		{
			throw new AssertionError("Component JSON must be valid", e);
		}
	}
}
