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

package com.jwebmp.core.base.ajax;

import com.jwebmp.core.base.html.DivSimple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AjaxResponseTest
{
	@Test
	public void testResponse()
	{
		AjaxResponse<?> ar = new AjaxResponse<>();
		ar.setSuccess(false);
		ar.addReaction(new AjaxResponseReaction<>("Title", "Data", ReactionType.DialogDisplay, AjaxResponseType.Warning));
		System.out.println(ar);
		Assertions.assertEquals(
				"{\n" + "  \"success\" : false,\n" + "  \"reactions\" : [ {\n" + "    \"actionTimeout\" : 0,\n" + "    \"reactionTitle\" : \"Title\",\n" + "    \"reactionMessage\" : \"Data\",\n" + "    \"reactionType\" : \"DialogDisplay\",\n" + "    \"type\" : \"Warning\"\n" + "  } ]\n" + "}",
				ar.toString());
	}

	@Test
	public void testResponseFull()
	{
		AjaxResponse<?> ar = new AjaxResponse<>();
		ar.setSuccess(false);
		ar.addReaction(new AjaxResponseReaction<>("Title", "Data", ReactionType.DialogDisplay, AjaxResponseType.Warning));

		//ar.addComponent(new DivSimple<>().setID("id"));
		ar.getLocalStorage()
		  .put("local", "storage");
		ar.getSessionStorage()
		  .put("session", "storage");

	//	ar.addDto("Dto", new AjaxResponse<>());
		//	ar.

		System.out.println(ar);
		Assertions.assertEquals(
				"{\n" + "  \"localStorage\" : {\n" + "    \"local\" : \"storage\"\n" + "  },\n" + "  \"sessionStorage\" : {\n" + "    \"session\" : \"storage\"\n" + "  },\n" + "  \"success\" : false,\n" + "  \"variables\" : [ {\n" + "    \"variableName\" : \"Dto\",\n" + "    \"variable\" : {\n" + "      \"success\" : true\n" + "    }\n" + "  } ],\n" + "  \"reactions\" : [ {\n" + "    \"actionTimeout\" : 0,\n" + "    \"reactionTitle\" : \"Title\",\n" + "    \"reactionMessage\" : \"Data\",\n" + "    \"reactionType\" : \"DialogDisplay\",\n" + "    \"type\" : \"Warning\"\n" + "  } ],\n" + "  \"components\" : [ {\n" + "    \"html\" : \"<div id=\\\"id\\\"></div>\",\n" + "    \"id\" : \"id\",\n" + "    \"insertType\" : \"Replace\"\n" + "  } ]\n" + "}",
				ar.toString());
	}
}
