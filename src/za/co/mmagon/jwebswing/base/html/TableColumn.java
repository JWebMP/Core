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
package za.co.mmagon.jwebswing.base.html;

import java.util.logging.Level;
import java.util.logging.Logger;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.TableColumnAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.TableColumnGroupChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.logger.LogFactory;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;col&gt; tag specifies column properties for each column within a colgroup element.<p>
 * <p>
 * The &lt;col&gt; tag is useful for applying styles to entire columns, instead of repeating the styles for each cell, for each row.<p>
 * <p>
 * Browser Support Element &lt;col&gt; Yes Yes Yes Yes Yes<p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * Most of the attributes in HTML 4.01 are not supported in HTML5. Differences Between HTML and XHTML<p>
 * <p>
 * In HTML the &lt;col&gt; tag has no end tag.<p>
 * <p>
 * In XHTML, the &lt;col&gt; tag must be properly closed.<p>
 * <p>
 * @author GedMarc
 * @param <J>
 *
 * @since 2014/12/20
 */
public class TableColumn<J extends TableColumn>
        extends Component<NoChildren, TableColumnAttributes, GlobalFeatures, GlobalEvents, J>
        implements TableColumnGroupChildren
{

    private static final Logger log = LogFactory.getInstance().getLogger("TableColumn");
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new table column
     */
    public TableColumn()
    {
        super(ComponentTypes.TableColumn);
    }

    /**
     * Differences Between HTML and XHTML
     * <p>
     * In HTML the base tag has no end tag.
     * <p>
     * In XHTML the base tag must be properly closed.
     */
    @Override
    public void preConfigure()
    {
        super.preConfigure();
        try
        {
            if (getPage().getHtmlVersion().name().startsWith("X"))
            {
                setInlineClosingTag(true);
            }
        }
        catch (Exception e)
        {
            log.log(Level.FINE, "Unable to determine whether XHTML or HTML. Will still render correctly, just not W3 Compliant.", e);
        }
    }

}
