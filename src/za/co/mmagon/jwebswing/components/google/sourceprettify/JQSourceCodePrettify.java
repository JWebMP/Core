package za.co.mmagon.jwebswing.components.google.sourceprettify;

import java.io.*;
import java.util.logging.*;
import za.co.mmagon.*;
import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.references.*;

/**
 *
 * Implements the Google Code Prettify JavaScript
 *
 * @since 2014 09 28
 * @version 1.0
 * @author MMagon
 *
 *
 */
public class JQSourceCodePrettify extends PreFormattedText implements GlobalChildren
{

    private static final org.apache.log4j.Logger log = LoggerFactory.getInstance().makeNewLoggerInstance("SourceCodePrettify");
    private static final String rootSource = "c:/";
    private static final long serialVersionUID = 1L;

    private SourceCodeLanguages sourceCodeLanguage = SourceCodeLanguages.Java;
    private SourceCodePrettifyThemes sourceCodePrettifyTheme = SourceCodePrettifyThemes.Default;

    private final JQSourceCodePrettifyFeature feature = new JQSourceCodePrettifyFeature(this);

    /**
     * Constructs a new Source Code Prettify
     */
    public JQSourceCodePrettify()
    {
        addFeature(feature);
    }

    /**
     * Constructs the HTML required for prettify to work
     *
     * @return
     */
    @Override
    protected StringBuilder renderBeforeTag()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(getCurrentTabIndentString()).append("<?prettify lang=").append(getSourceCodeLanguage().name().toLowerCase()).append(" linenums=true?>").append(getNewLine());
        return sb;
    }

    /**
     * Gets the source code language in use
     *
     * @return
     */
    public SourceCodeLanguages getSourceCodeLanguage()
    {
        return sourceCodeLanguage;
    }

    /**
     * Sets the language programming for
     *
     * @param sourceCodeLanguage
     */
    public void setSourceCodeLanguage(SourceCodeLanguages sourceCodeLanguage)
    {
        this.sourceCodeLanguage = sourceCodeLanguage;
    }

    /**
     * Returns the current theme in place. Default is Sons of Obsidion
     *
     * @return
     */
    public SourceCodePrettifyThemes getSourceCodePrettifyTheme()
    {
        return sourceCodePrettifyTheme;
    }

    /**
     * Sets this source code display to a prettify theme
     *
     * @param sourceCodePrettifyTheme
     */
    public void setSourceCodePrettifyTheme(SourceCodePrettifyThemes sourceCodePrettifyTheme)
    {
        this.sourceCodePrettifyTheme = sourceCodePrettifyTheme;
        if (sourceCodePrettifyTheme != null)
        {
            feature.getCssReferences().add(new CSSReference("prettifyTheme", 1.0, sourceCodePrettifyTheme.getCssReference()));
        }
    }

    /**
     * Sets the displaying theme that this feature will use
     *
     * @param theme The theme to use
     */
    public final void setTheme(SourceCodePrettifyThemes theme)
    {
        this.sourceCodePrettifyTheme = theme;
        if (this.sourceCodePrettifyTheme != null)
        {
            getCssReferences().add(new CSSReference(theme.name(), 1.0, theme.getCssReference(), theme.getCssReference()));
        }
    }

    /**
     * Takes a physical file to a string for display
     *
     * @param classToRender
     * @return
     */
    public StringBuilder fileToString(Class classToRender)
    {
        String fileName = rootSource + classToRender.getCanonicalName().replace('.', '\\').replace("/", "\\") + ".java" + "?format=raw";
        File file = new File(fileName);
        if (!file.exists())
        {
            Logger.getLogger("fileToString").log(Level.SEVERE, "Couldn''t find java file [{0}]", fileName);
            // return new StringBuilder("Couldn't find java file [" + fileName + "]");
        }

        StringBuilder sb = new StringBuilder();
        try
        {
            try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr))
            {
                String line = br.readLine();
                while (line != null)
                {
                    if (!line.startsWith("import"))
                    {
                        sb.append(line).append("\n");
                    }
                    line = br.readLine();
                }
                fr.close();
                br.close();
            }

        }
        catch (FileNotFoundException ex)
        {
            log.error("File Not Found ", ex);
        }
        catch (IOException ex)
        {
            log.error("IO Error reading file", ex);
        }

        return sb;
    }

}
