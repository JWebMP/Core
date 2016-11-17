package za.co.mmagon.jwebswing.components.jqueryui.themes;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSSImpl;
import za.co.mmagon.jwebswing.htmlbuilder.css.composer.CSSBlock;
import za.co.mmagon.jwebswing.htmlbuilder.css.fonts.FontFamilies;
import za.co.mmagon.jwebswing.htmlbuilder.css.fonts.FontWeights;

/**
 * 
 * @since 
 * @version
 * @author MMagon
 *
 * 
 */

public class ThemeCSSObject 
{
        
    
    public class FontSettingsBlock extends CSSBlock
    {
        private ArrayList<FontFamilies> fontFamilies = new ArrayList();
        private FontWeights fontWeight = FontWeights.Normal;
        private MeasurementCSSImpl fontSize = new MeasurementCSSImpl();

        public ArrayList<FontFamilies> getFontFamilies()
        {
            return fontFamilies;
        }

        public void setFontFamilies(ArrayList<FontFamilies> fontFamilies)
        {
            this.fontFamilies = fontFamilies;
        }

        public FontWeights getFontWeight()
        {
            return fontWeight;
        }

        public void setFontWeight(FontWeights fontWeight)
        {
            this.fontWeight = fontWeight;
        }

        public MeasurementCSSImpl getFontSize()
        {
            return fontSize;
        }

        public void setFontSize(MeasurementCSSImpl fontSize)
        {
            this.fontSize = fontSize;
        }
    }
    
    public class HeaderToolbarBlock extends CSSBlock
    {
        
    }
    
    public class ContentBlock extends CSSBlock
    {
        
    }
    
    public class ClickableDefaultStateBlock extends CSSBlock
    {
        
    }
    
    public class ClickableHoverStateBlock extends CSSBlock
    {
        
    }
    
    public class ClickableActiveStateBlock extends CSSBlock
    {
        
    }
    
    public class HighlightBlock extends CSSBlock
    {
        
    }
    
    public class ErrorBlock extends CSSBlock
    {
        
    }
    
    public class ModelScreenForOverlaysBlock extends CSSBlock
    {
        
    }
    
    public class DropShadowsBlock extends CSSBlock
    {
        
    }
    
}
