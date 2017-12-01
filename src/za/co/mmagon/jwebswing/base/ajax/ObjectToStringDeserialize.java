/*
 * Copyright (C) 2017 Marc Magon
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
package za.co.mmagon.jwebswing.base.ajax;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

import java.io.IOException;

/**
 * Deserializes a field returned in JSON as an object into a string
 *
 * @author GedMarc
 * @since Nov 9, 2016
 */
class ObjectToStringDeserialize extends JsonDeserializer<Object>
{
	/**
	 * An instant to serialize everything as tostring
	 */
	public ObjectToStringDeserialize()
	{
		//No config needed
	}

	@Override
	public Object deserialize(JsonParser jp, DeserializationContext dc) throws IOException
	{
		JsonNode node = jp.readValueAsTree();
		return new JavaScriptPart().objectAsString(node);
	}
}
