package za.co.mmagon.jwebswing.components.jqImageMap.imagemap;

import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.features.gradients.JWGradientsFeature;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.children.ImageMapFeatures;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * Adds a legend below a heat map
 *
 * @since 2013/11/27 03:06
 * @version 1.0
 * @author MMagon
 *
 *
 */
public class JQMapLegendFeature extends Feature<JavaScriptPart, JQMapLegendFeature> implements ImageMapFeatures
{

    private JWGradientsFeature gradientsFeature;// = new JWGradientsFeature();
    private Div layoutDiv = new Div();

    //private Div firstHalf = new Div();
    //private Div secondHalf = new Div();
    public JQMapLegendFeature(JQImageMap imageMap, JWGradientsFeature gradientFeature)
    {
        super("JWMapLegendFeature");
        this.gradientsFeature = gradientFeature;
        layoutDiv.addAttribute(GlobalAttributes.Style, "width:100%; height: 20px; margin-top: 10px; margin-left: 10px; margin-right:10px");
        //layoutDiv.add(secondHalf);
        //firstHalf.addAttribute(GlobalAttributes.Style, "width:100%; height: 20px; margin-top: 10px; margin-left: 10px; margin-right:10px");
        //secondHalf.addAttribute(GlobalAttributes.Style, "width:100%; height: 20px; margin-top: 10px; margin-left: 10px; margin-right:10px");
        this.gradientsFeature.setComponentToApply(getLayoutDiv());
    }

    public JWGradientsFeature getGradientsFeature()
    {
        return gradientsFeature;
    }

    public void setGradientsFeature(JWGradientsFeature gradientsFeature)
    {
        this.gradientsFeature = gradientsFeature;
    }

    public Div getLayoutDiv()
    {
        return layoutDiv;
    }

    public void setLayoutDiv(Div layoutDiv)
    {
        this.layoutDiv = layoutDiv;
    }

}
