package za.co.mmagon.jwebswing.components.dynamicsourcecode;

import java.util.HashMap;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.ListItem;
import za.co.mmagon.jwebswing.base.html.Option;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.attributes.OptionAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.components.google.sourceprettify.JQSourceCodePrettify;
import za.co.mmagon.jwebswing.components.google.sourceprettify.SourceCodePrettifyThemes;
import za.co.mmagon.jwebswing.components.jqxwidgets.dropdownlist.JQXDropDownListSelectMenu;
import za.co.mmagon.jwebswing.components.jqxwidgets.panel.JQXPanel;
import za.co.mmagon.jwebswing.components.jqxwidgets.panel.JQXPanelFeature;
import za.co.mmagon.jwebswing.components.jqxwidgets.panel.JQXPanelSizeModes;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.displays.Overflows;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSSImpl;
import za.co.mmagon.jwebswing.htmlbuilder.css.text.TextAlignments;

/**
 *
 * @author GedMarc
 * @since 27 Apr 2015
 */
public class DynamicSourceCodeScreen extends Div<GlobalChildren, NoAttributes, GlobalFeatures, GlobalEvents, Component>
{

    private static final long serialVersionUID = 1L;
    private final HashMap<String, Class> screensToGenerate = new HashMap<>();
    @CSS(Text_Align = TextAlignments.Center)
    private final JQXPanel buttonPanel = new JQXPanel();
    private final JQSourceCodePrettify sourceDisplay = new JQSourceCodePrettify();
    
    
    

    JQXPanelFeature feat = new JQXPanelFeature(sourceDisplay);

    public DynamicSourceCodeScreen()
    {
        setID("sourceScreen");
        getCss().setWidth(MeasurementCSSImpl.hundredPercent);
        getCss().setHeight(MeasurementCSSImpl.hundredPercent);
        getCss().setOverflow(Overflows.Hidden);
        buttonPanel.setID("actualSource");
        buttonPanel.getOptions().setHeight(60);
        buttonPanel.getCss().setHeight(60);
        buttonPanel.getOptions().setWidth(MeasurementCSSImpl.hundredPercent);
        buttonPanel.getCss().setMarginTop(new MeasurementCSSImpl(2));
        buttonPanel.addClass("sourceCodeButton");

        sourceDisplay.setID("sourceCode");
        sourceDisplay.setSourceCodePrettifyTheme(SourceCodePrettifyThemes.Sons_Of_Obsidian);
        addFeature(new DynamicSourceCodeFeature(this));

        sourceDisplay.getCss().setHeight(MeasurementCSSImpl.hundredPercent);

        sourceDisplay.getCss().setOverflow(Overflows.Scroll);

        //sourceDisplay.addFeature(feat);
        //displayPanel.getOptions().setAutoUpdate(true);
        feat.getOptions().setSizeMode(JQXPanelSizeModes.fixed);
        feat.getOptions().setWidth(MeasurementCSSImpl.hundredPercent);
        feat.getOptions().setHeight(MeasurementCSSImpl.ninetyThreePercent);

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
