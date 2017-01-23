package za.co.mmagon.jwebswing.components.jqimagemap.imagemap;

import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.Area;
import za.co.mmagon.jwebswing.components.jqueryui.position.Position;
import za.co.mmagon.jwebswing.components.jqueryui.position.PositionLocationHorizontal;
import za.co.mmagon.jwebswing.components.jqueryui.position.PositionLocationVertical;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * Allows a selection on an area to open up a new Image Map
 *
 * @since 2013/11/25
 * @version 1.0
 * @author mmagon
 *
 *
 */
public class JQImageMapDrillFeature extends Feature<JavaScriptPart, JQImageMapDrillFeature>
{

    private Area sourceArea;
    private JQImageMap mapToOpen;

    /**
     * Adds on a new Image Map ComponentFeatureBase
     *
     * @param sourceArea The area which the click event is being added to
     * @param mapToOpen  The Image Map to Open
     */
    public JQImageMapDrillFeature(Area sourceArea, JQImageMap mapToOpen)
    {
        super("ImageMap Drill Feature");
        this.sourceArea = sourceArea;
        this.mapToOpen = mapToOpen;
    }

    /**
     *
     * @return
     */
    public Area getSourceArea()
    {
        return sourceArea;
    }

    /**
     *
     * @param sourceArea
     */
    public void setSourceArea(Area sourceArea)
    {
        this.sourceArea = sourceArea;
    }

    public JQImageMap getMapToOpen()
    {
        return mapToOpen;
    }

    public void setMapToOpen(JQImageMap mapToOpen)
    {
        this.mapToOpen = mapToOpen;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        Position position = new Position(PositionLocationHorizontal.Left, PositionLocationVertical.center, PositionLocationHorizontal.Right, PositionLocationVertical.center, sourceArea);
        addQuery("$('#" + sourceArea.getID() + "').click(function(){$('#" + mapToOpen.getID() + "').show().position(" + position.toString() + ");});");
        addQuery("$('#" + sourceArea.getID() + "').blur(function(){$('#" + mapToOpen.getID() + "').hide();});");

    }
}
