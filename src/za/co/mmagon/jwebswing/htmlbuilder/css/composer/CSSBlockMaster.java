/*
 * Copyright (C) 2016 GedMarc
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
package za.co.mmagon.jwebswing.htmlbuilder.css.composer;

import java.util.*;

/**
 *
 * @author GedMarc
 * @since 19 Jan 2016
 */
public class CSSBlockMaster
{

    private final ArrayList<CSSBlock> allBlocks;

    public CSSBlockMaster()
    {
        this.allBlocks = new ArrayList<>();
    }

    /**
     * Restart a block building section
     */
    public void reset()
    {
        allBlocks.clear();
    }

    /**
     * Adds a block to the CSS Composer
     *
     * @param block The block to add to the composer
     */
    public void addBlock(CSSBlock block)
    {
        CSSBlock dupLines;
        if (!allBlocks.contains(block))
        {

            if ((dupLines = checkBlocksForDuplicateLines(block)) != null)
            {
                dupLines.addLinkedBlock(block);
            }
            else
            {
                allBlocks.add(block);
            }
        }
    }

    /**
     * Adds a block to the CSS Composer
     *
     * @param block
     *
     * @return
     */
    public ArrayList<CSSBlock> addBlock(ArrayList<CSSBlock> block)
    {
        block.stream().forEach((cssBlock)
                ->
        {
            addBlock(cssBlock);
        });
        return block;
    }

    /**
     * Returns any duplicate blocks
     *
     * @param blockToCompare The block to compare against
     *
     * @return The block with the same lines
     */
    protected CSSBlock checkBlocksForDuplicateLines(CSSBlock blockToCompare)
    {
        for (CSSBlock cssBlock : allBlocks)
        {
            String mylines = cssBlock.getCssLines().toString();
            String compareToLines = blockToCompare.getCssLines().toString();
            //System.out.println("my lines : " + mylines);
            //System.out.println("compare lines : " + compareToLines);
            if (blockToCompare.getCssLines().toString().equalsIgnoreCase(cssBlock.getCssLines().toString()))
            {
                return cssBlock;
            }
        }
        return null;
    }

    /**
     * Checks if the ID of a block is loaded for this composer
     *
     * @param block The block to check
     *
     * @return True if the ID is already complete
     */
    protected boolean idAlreadyLoaded(CSSBlock block)
    {
        return allBlocks.stream().anyMatch((cssBlock) -> (block.getIdOfBlock().equalsIgnoreCase(cssBlock.getIdOfBlock())));
    }

    /**
     * Return the list of CSS Blocks loaded in this composer
     *
     * @return
     */
    public ArrayList<CSSBlock> getAllCSSBlocks()
    {
        return allBlocks;
    }

    /**
     * Returns the generated CSS as small as possible
     *
     * @param ajax Placeholder - will always render as inline
     *
     * @return The generated CSS
     */
    public String toString(boolean ajax)
    {
        StringBuilder cssBlocksSB = new StringBuilder();
        (getAllCSSBlocks()).stream().forEach(cSSBlock
                ->
        {
            CSSBlockIdentifier oldIdent = cSSBlock.getBlockIdentifer();
            cSSBlock.setBlockIdentifer(CSSBlockIdentifier.Inline);
            if (!cSSBlock.toString().isEmpty())
            {
                cssBlocksSB.append(cSSBlock).append(cSSBlock.getBlockIdentifer() == CSSBlockIdentifier.Inline ? "" : "\n");
            }
            cSSBlock.setBlockIdentifer(oldIdent);
        });
        return cssBlocksSB.toString();
    }
}
