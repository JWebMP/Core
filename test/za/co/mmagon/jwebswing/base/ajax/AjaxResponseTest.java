package za.co.mmagon.jwebswing.base.ajax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.base.html.DivSimple;

public class AjaxResponseTest
{
	@Test
	public void testResponse()
	{
		AjaxResponse ar = new AjaxResponse();
		ar.setSuccess(false);
		ar.addReaction(new AjaxResponseReaction("Title", "Data", ReactionType.DialogDisplay, AjaxResponseType.Warning));
		System.out.println(ar);
		Assertions.assertEquals("{\n" +
				                        "  \"success\" : false,\n" +
				                        "  \"reactions\" : [ {\n" +
				                        "    \"actionTimeout\" : 0,\n" +
				                        "    \"reactionTitle\" : \"Title\",\n" +
				                        "    \"reactionMessage\" : \"Data\",\n" +
				                        "    \"reactionType\" : \"DialogDisplay\",\n" +
				                        "    \"type\" : \"Warning\"\n" +
				                        "  } ]\n" +
				                        "}", ar.toString());
	}

	@Test
	public void testResponseFull()
	{
		AjaxResponse ar = new AjaxResponse();
		ar.setSuccess(false);
		ar.addReaction(new AjaxResponseReaction("Title", "Data", ReactionType.DialogDisplay, AjaxResponseType.Warning));

		ar.addComponent(new DivSimple<>().setID("id"));
		ar.getLocalStorage().put("local", "storage");
		ar.getSessionStorage().put("session", "storage");

		ar.addDto("Dto", new AjaxResponse());
		//	ar.

		System.out.println(ar);
		Assertions.assertEquals("{\n" +
				                        "  \"localStorage\" : {\n" +
				                        "    \"local\" : \"storage\"\n" +
				                        "  },\n" +
				                        "  \"sessionStorage\" : {\n" +
				                        "    \"session\" : \"storage\"\n" +
				                        "  },\n" +
				                        "  \"success\" : false,\n" +
				                        "  \"variables\" : [ {\n" +
				                        "    \"variableName\" : \"Dto\",\n" +
				                        "    \"variable\" : {\n" +
				                        "      \"success\" : true\n" +
				                        "    }\n" +
				                        "  } ],\n" +
				                        "  \"reactions\" : [ {\n" +
				                        "    \"actionTimeout\" : 0,\n" +
				                        "    \"reactionTitle\" : \"Title\",\n" +
				                        "    \"reactionMessage\" : \"Data\",\n" +
				                        "    \"reactionType\" : \"DialogDisplay\",\n" +
				                        "    \"type\" : \"Warning\"\n" +
				                        "  } ],\n" +
				                        "  \"components\" : [ {\n" +
				                        "    \"html\" : \"<div id=\\\"id\\\"></div>\",\n" +
				                        "    \"id\" : \"id\",\n" +
				                        "    \"insertType\" : \"Replace\"\n" +
				                        "  } ]\n" +
				                        "}", ar.toString());
	}
}
