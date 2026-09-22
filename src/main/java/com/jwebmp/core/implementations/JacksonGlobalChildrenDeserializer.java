package com.jwebmp.core.implementations;

import com.jwebmp.core.base.html.interfaces.GlobalChildren;
import com.jwebmp.core.base.interfaces.IComponentBase;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ValueDeserializer;

/**
 * Restores a hierarchy child from the concrete class recorded in its component JSON.
 */
public class JacksonGlobalChildrenDeserializer extends ValueDeserializer<GlobalChildren>
{
    @Override
    public GlobalChildren deserialize(JsonParser parser, DeserializationContext context) throws JacksonException
    {
        JsonNode node = parser.readValueAsTree();
        return (GlobalChildren) IComponentBase.from(node.toString());
    }
}
