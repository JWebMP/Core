package za.co.mmagon.jwebswing.htmlbuilder.css.composer;

import java.util.*;
import java.util.logging.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.enumarations.CSSTypes;
import za.co.mmagon.jwebswing.utilities.TextUtilities;
import za.co.mmagon.logger.LogFactory;

/**
 * A Block of CSS
 *
 * @author MMagon
 * @since 07 Apr 2013
 * @version 1.0
 */
public class CSSBlock
{

    private static final Logger LOG = LogFactory.getInstance().getLogger("CSSBlock");
    private ArrayList<String> linkedBlocks = new ArrayList();
    private CSSLines cssLines;
    private CSSTypes blockType;
    private CSSBlockIdentifier blockIdentifer;
    private static final CSSLineSorter SORTER = new CSSLineSorter();
    private String idOfBlock;

    /**
     * Creates a new ID (#) block of ID with no type
     *
     * @param blockID
     */
    public CSSBlock(String blockID)
    {
        if (blockID == null)
        {
            throw new UnsupportedOperationException("Block id is null");
        }
        if (blockID.contains(" "))
        {
            throw new UnsupportedOperationException("Cannot create an id with a space in it");
        }
        if (blockID.isEmpty())
        {
            throw new UnsupportedOperationException("Cannot create a block with no id");
        }
        this.idOfBlock = blockID;
        cssLines = new CSSLines();
        cssLines.setPrettyPrint(true);
        cssLines.setRenderBraces(true);
        cssLines.setRenderInQuotations(false);
        blockType = CSSTypes.None;
        blockIdentifer = CSSBlockIdentifier.Id;
    }

    /**
     * Creates a new In-Line block inside quotations
     */
    public CSSBlock()
    {
        this.idOfBlock = null;
        cssLines = new CSSLines();
        cssLines.setPrettyPrint(false);
        cssLines.setRenderBraces(false);
        cssLines.setRenderInQuotations(false);
        blockType = CSSTypes.None;
        blockIdentifer = CSSBlockIdentifier.Inline;
    }

    /**
     *
     * @param blockType      The block type, active or changed
     * @param blockIdentifer The block identifier
     * @param idOfBlock      the id of whatever to put this onto
     */
    public CSSBlock(CSSTypes blockType, CSSBlockIdentifier blockIdentifer, String idOfBlock)
    {
        this.blockType = blockType;
        this.idOfBlock = idOfBlock;

        cssLines = new CSSLines();
        cssLines.setPrettyPrint(true);
        cssLines.setRenderBraces(true);
        cssLines.setRenderInQuotations(false);
    }

    /**
     *
     * @param blockType        The block type, active or changed
     * @param blockIdentifer   The block identifier
     * @param idOfBlock        the id of whatever to put this onto
     * @param prettyPrint      Pretty print or not
     * @param renderBraces     render braces or not
     * @param renderQuotations render quotations or not
     */
    public CSSBlock(CSSTypes blockType, CSSBlockIdentifier blockIdentifer, String idOfBlock, boolean prettyPrint, boolean renderBraces, boolean renderQuotations)
    {
        this.blockType = blockType;
        this.idOfBlock = idOfBlock;
        cssLines = new CSSLines();
        cssLines.setPrettyPrint(true);
        cssLines.setRenderBraces(true);
        cssLines.setRenderInQuotations(false);
    }

    /**
     * Adds a property value pair to the Lines group. If it already exists, just returns it
     *
     * @param line Input Line to add to the lines collection
     *
     * @return The input Line
     */
    public CSSLine add(CSSLine line)
    {
        if (line == null)
        {
            return null;
        }

        if (cssLines.getCssLines().contains(line))
        {
            return line;
        }
        else
        {
            cssLines.getCssLines().add(line);
            java.util.Collections.sort(cssLines.getCssLines(), SORTER);
            return line;
        }
    }

    /**
     * Removes a line from the list
     *
     * @param line The line to be removed
     *
     * @return True if it could be removed
     */
    public boolean remove(CSSLine line)
    {
        if (cssLines.getCssLines().contains(line))
        {
            cssLines.getCssLines().remove(line);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * This blocks CSS according to how it is configured with 0 tabs
     *
     * @return This blocks CSS according to how it is configured with 0 tabs
     */
    @Override
    public String toString()
    {
        return toString(01);
    }

    /**
     * Returns a generated block ID to apply on top of this CSS
     *
     * @param block The linked block
     *
     * @return
     */
    private String generateBlockID(CSSBlock block)
    {
        return generateBlockID(block, 0);
    }

    /**
     * Returns a generated block ID to apply on top of this CSS
     *
     * @param block The linked block
     *
     * @return
     */
    private String generateBlockID(CSSBlock block, int tabCount)
    {
        StringBuilder sb = new StringBuilder();
        if (cssLines.isPrettyPrint())
        {
            sb.append(TextUtilities.getTabString(tabCount - 1));
        }

        switch (block.blockIdentifer)
        {
            case Class:
            {
                sb.append(".").append(block.getIdOfBlock()).append(" ");
                break;
            }
            case Element:
            {
                sb.append("").append(block.getIdOfBlock()).append(" ");
                break;
            }
            case Inline:
            {
                break;
            }
            case Id:
            {
                sb.append("#").append(block.getIdOfBlock()).append(" ");
                break;
            }
            case Theme:
            {
                break;
            }
            default:
            {
                throw new UnsupportedOperationException("Block Identifier has not been catered for in generate block id");
            }
        }

        switch (block.blockType)
        {
            case Active:
            {
                sb = new StringBuilder(sb.toString().trim());
                sb.append(":active");
                break;
            }
            case Link:
            {
                sb = new StringBuilder(sb.toString().trim());
                sb.append(":link");
                break;
            }
            case Hover:
            {
                sb = new StringBuilder(sb.toString().trim());
                sb.append(":hover");
                break;
            }
            case Visited:
            {
                sb = new StringBuilder(sb.toString().trim());
                sb.append(":visited");
                break;
            }
        }

        //addBlockID(idOfBlock);
        return sb.toString();
    }

    /**
     * Returns a generated block ID to apply on top of this CSS
     *
     * @param block The linked block
     *
     * @return
     */
    public String addBlockID(String block)
    {
        if (!linkedBlocks.contains(block))
        {
            linkedBlocks.add(block);
        }
        return block;
    }

    /**
     * Generates this block ID
     *
     * @return This blocks linked and itself ID
     */
    private String generateBlockIDS(int tabCount)
    {
        StringBuilder sb = new StringBuilder();
        getLinkedBlocks().stream().map(cssBlock ->
        {
            sb.append(cssBlock);
            return cssBlock;
        }).map(_item ->
        {
            sb.append(",");
            return _item;
        }).filter(_item -> (cssLines.isPrettyPrint())).forEachOrdered(_item ->
        {
            sb.append(TextUtilities.getTabString(tabCount - 1));
        });
        sb.append(generateBlockID(this));
        return sb.toString();
    }

    /**
     * This blocks CSS according to how it is configured with Set tabs
     *
     * @param tabCount
     *
     * @return This blocks CSS according to how it is configured with Set tabs
     */
    public String toString(int tabCount)
    {
        StringBuilder sb = new StringBuilder();
        if (cssLines.getCssLines().isEmpty())
        {
            return "";
        }
        sb.append(generateBlockIDS(tabCount));
        if (!(this.blockType == CSSTypes.None))
        {
            sb.append(" ");
        }
        sb.append(cssLines.toString(tabCount, this.blockType == CSSTypes.None));
        if (this.blockType == CSSTypes.None)
        {
            sb = new StringBuilder(sb.toString().replaceAll(",", ";"));
        }
        return sb.toString();
    }

    /**
     *
     * @return This objects CSS Lines string
     */
    public CSSLines getCssLines()
    {
        return cssLines;
    }

    /**
     * Adds a block ID into this blocks generated String
     *
     * @param linkedBlock The block to test if it's contents match, if so, then it is added
     *
     * @return True if the block can be added to this one
     */
    public boolean addLinkedBlock(CSSBlock linkedBlock)
    {
        addBlockID(linkedBlock.generateBlockID(linkedBlock));
        return true;
    }

    /**
     * Returns the full ID of this block as a string
     *
     * @return Returns the full ID of this block as a string
     */
    public String getIdOfBlock()
    {
        return idOfBlock;
    }

    /**
     * Sets the ID of the block to be built
     *
     * @param idOfBlock
     */
    public void setIdOfBlock(String idOfBlock)
    {
        this.idOfBlock = idOfBlock;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.blockIdentifer);
        hash = 41 * hash + Objects.hashCode(this.idOfBlock);
        return hash;
    }

    /**
     * Compares the body string to each other
     *
     * @param obj The CSS Block to compare
     *
     * @return True or false if they same
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final CSSBlock other = (CSSBlock) obj;
        if (!Objects.equals(this.idOfBlock, other.idOfBlock))
        {
            return false;
        }
        if (this.blockIdentifer != other.blockIdentifer)
        {
            return false;
        }
        return true;
    }

    /**
     * Gets the block ID's that are currently linked
     *
     * @return
     */
    public ArrayList<String> getLinkedBlocks()
    {
        return linkedBlocks;
    }

    /**
     * Sets the block ID's that are linked to this block
     *
     * @param linkedBlocks
     */
    public void setLinkedBlocks(ArrayList<String> linkedBlocks)
    {
        this.linkedBlocks = linkedBlocks;
    }

    /**
     * Gets this Master block's Type
     *
     * @return
     */
    public CSSTypes getBlockType()
    {
        return blockType;
    }

    /**
     * Sets this Block Type
     *
     * @param blockType
     */
    public void setBlockType(CSSTypes blockType)
    {
        this.blockType = blockType;
    }

    /**
     * Sets how this block is identified
     *
     * @return
     */
    public CSSBlockIdentifier getBlockIdentifer()
    {
        return blockIdentifer;
    }

    /**
     * Sets how this block is identified
     *
     * @param blockIdentifer
     */
    public void setBlockIdentifer(CSSBlockIdentifier blockIdentifer)
    {
        this.blockIdentifer = blockIdentifer;
    }

    public static void main(String... args)
    {
        GregorianCalendar date = new GregorianCalendar();
        CSSBlock cssIDComponentBlock = new CSSBlock("idOfTag");
        cssIDComponentBlock.add(null);
        cssIDComponentBlock.add(new CSSLine("property2:value2"));
        cssIDComponentBlock.add(new CSSLine("property2:value1"));
        cssIDComponentBlock.add(new CSSLine("property1:value1"));
        cssIDComponentBlock.add(new CSSLine("property1:value2"));
        System.out.println("CSS Block : \n" + cssIDComponentBlock);

        CSSBlock cssIDComponentBlockActive = new CSSBlock("className");
        cssIDComponentBlockActive.blockType = CSSTypes.Active;
        cssIDComponentBlockActive.blockIdentifer = CSSBlockIdentifier.Class;
        cssIDComponentBlockActive.add(null);
        cssIDComponentBlockActive.add(new CSSLine("property2:value2"));
        cssIDComponentBlockActive.add(new CSSLine("property2:value1"));
        cssIDComponentBlockActive.add(new CSSLine("property1:value1"));
        cssIDComponentBlockActive.add(new CSSLine("property1:value2"));
        System.out.println("\n" + cssIDComponentBlockActive);

        CSSBlock cssTagComponent = new CSSBlock("normal-tag");
        cssTagComponent.blockType = CSSTypes.Hover;
        cssTagComponent.blockIdentifer = CSSBlockIdentifier.Id;
        cssTagComponent.add(null);
        cssTagComponent.add(new CSSLine("property2:value2"));
        cssTagComponent.add(new CSSLine("property2:value1"));
        cssTagComponent.add(new CSSLine("property1:value1"));
        cssTagComponent.add(new CSSLine("property1:value2"));
        cssTagComponent.addLinkedBlock(cssTagComponent);
        System.out.println("\n" + cssTagComponent);

        CSSBlock cssInLineComponent = new CSSBlock();
        cssInLineComponent.add(null);
        cssInLineComponent.add(new CSSLine("property2:value2"));
        cssInLineComponent.add(new CSSLine("property2:value1"));
        cssInLineComponent.add(new CSSLine("property1:value1"));
        cssInLineComponent.add(new CSSLine("property1:value2"));
        System.out.println("\n" + cssInLineComponent);

        GregorianCalendar date2 = new GregorianCalendar();
        System.out.println("Time Taken : " + (date2.getTimeInMillis() - date.getTimeInMillis()) + "milliseconds.");
    }
}
