package za.co.mmagon.jwebswing.components.dynamicsourcecode;

import java.util.*;
import za.co.mmagon.jwebswing.*;
import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.base.html.attributes.*;
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.events.*;
import za.co.mmagon.jwebswing.components.google.sourceprettify.*;
import za.co.mmagon.jwebswing.components.jqxwidgets.dropdownlist.*;
import za.co.mmagon.jwebswing.components.jqxwidgets.panel.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.displays.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.text.*;

/**
 *
 * @author GedMarc
 * @since 27 Apr 2015
 */
public class DynamicSourceCodeScreen extends Div<GlobalChildren, NoAttributes, GlobalFeatures, GlobalEvents, Component>
{

    private static final long serialVersionUID = 1L;
    private final HashMap<String, Class> screensToGenerate = new HashMap<>();
    @TextCSS(TextAlign = TextAlignments.Center)
    private final JQXPanel buttonPanel = new JQXPanel();
    private final JQSourceCodePrettify sourceDisplay = new JQSourceCodePrettify();

    JQXPanelFeature feat = new JQXPanelFeature(sourceDisplay);

    public DynamicSourceCodeScreen()
    {
        setID("sourceScreen");
        getCss().getDimensions().setWidth(MeasurementPercentages.hundredPercent);
        getCss().getDimensions().setHeight(MeasurementPercentages.hundredPercent);
        getCss().getDisplay().setOverflow(Overflows.Hidden);
        buttonPanel.setID("actualSource");
        buttonPanel.getOptions().setHeight(60);
        buttonPanel.getCss().getDimensions().setHeight(60);
        buttonPanel.getOptions().setWidth(MeasurementPercentages.hundredPercent);
        buttonPanel.getCss().getMargins().setMarginTop(new MeasurementCSSImpl(2));
        buttonPanel.addClass("sourceCodeButton");

        sourceDisplay.setID("sourceCode");
        sourceDisplay.setSourceCodePrettifyTheme(SourceCodePrettifyThemes.Sons_Of_Obsidian);
        addFeature(new DynamicSourceCodeFeature(this));

        sourceDisplay.getCss().getDimensions().setHeight(MeasurementPercentages.hundredPercent);
        sourceDisplay.getCss().getDisplay().setOverflow(Overflows.Scroll);
        sourceDisplay.addFeature(feat);

        feat.getOptions().setSizeMode(JQXPanelSizeModes.fixed);
        feat.getOptions().setWidth(MeasurementPercentages.hundredPercent);
        feat.getOptions().setHeight(MeasurementPercentages.ninetyThreePercent);

        za.co.mmagon.jwebswing.utilities.ComponentUtils.removeAllMargins(sourceDisplay);

        add(buttonPanel);
        add(sourceDisplay);
    }

    private JQXDropDownListSelectMenu getThemeSelector()
    {
        JQXDropDownListSelectMenu selectMenu = new JQXDropDownListSelectMenu();
        selectMenu.setID("prettySelect");
        selectMenu.getOptions().setWidth(160);
        SourceCodePrettifyThemes[] themes = SourceCodePrettifyThemes.values();
        for (SourceCodePrettifyThemes theme : themes)
        {

            Option opt = new Option(theme.name().replace('_', ' '));
            opt.addAttribute(OptionAttributes.Value, theme.getCssReference());
            selectMenu.add(opt);

            ListItem li = new ListItem(theme.name().replace('_', ' '));
            li.addAttribute(GlobalAttributes.Value, theme.getCssReference());
        };

        return selectMenu;
    }

    public void addButton(String name, Class comp)
    {
        screensToGenerate.put(name, comp);
    }
}
