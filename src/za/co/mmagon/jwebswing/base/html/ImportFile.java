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
package za.co.mmagon.jwebswing.base.html;

import java.io.*;
import za.co.mmagon.FileTemplates;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.NoFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.children.BodyChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.generics.ParagraphChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Allows the importing of a file into a template
 *
 * @author GedMarc
 * @param <J>
 *
 * @since 06 Feb 2017
 *
 */
public class ImportFile<J extends ImportFile>
        extends Component<NoChildren, NoAttributes, NoFeatures, NoEvents, J>
        implements BodyChildren, ParagraphChildren
{

    private static final long serialVersionUID = 1L;
    /**
     * The actual name for the template
     */
    private final String templateName;

    /**
     * Constructs a new instance of an imported file via a stream
     *
     * @param templateName
     * @param inputStream
     *
     * @throws java.io.IOException
     */
    public ImportFile(String templateName, InputStream inputStream) throws IOException
    {
        super(ComponentTypes.Comment);
        this.templateName = templateName;
        setTag("");
        StringBuilder sb;
        try (InputStreamReader isr = new InputStreamReader(inputStream); BufferedReader br = new BufferedReader(isr))
        {
            sb = new StringBuilder();
            br.lines().forEach(line ->
            {
                sb.append(line);
            });
        }
        inputStream.close();
        FileTemplates.setTemplateScript(templateName, sb);
    }

    @Override
    protected StringBuilder renderHTML(int tabCount)
    {
        return FileTemplates.renderTemplateScripts(templateName);
    }

    /**
     * Returns the template name for this file
     *
     * @return
     */
    public String getTemplateName()
    {
        return templateName;
    }

}
