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
package com.jwebmp.htmlbuilder.css.composer;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author GedMarc
 * @since 19 Jan 2016
 */
public class CSSBlockMaster
{
	/**
	 * A list of all the existing css blocks
	 */
	private List<CSSBlock> allBlocks;

	/**
	 * Creates a new block master
	 */
	public CSSBlockMaster()
	{
		//Nothing Needed
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
	 * @param block
	 * 		The block to add to the composer
	 */
	public void addBlock(CSSBlock block)
	{
		CSSBlock dupLines;
		if (!getAllCSSBlocks().contains(block))
		{

			if ((dupLines = checkBlocksForDuplicateLines(block)) != null)
			{
				dupLines.addLinkedBlock(block);
			}
			else
			{
				getAllCSSBlocks().add(block);
			}
		}
	}

	/**
	 * Return the list of CSS Blocks loaded in this composer
	 *
	 * @return
	 */
	@NotNull
	public List<CSSBlock> getAllCSSBlocks()
	{
		if (allBlocks == null)
		{
			allBlocks = new ArrayList<>();
		}
		return allBlocks;
	}

	/**
	 * Returns any duplicate blocks
	 *
	 * @param blockToCompare
	 * 		The block to compare against
	 *
	 * @return The block with the same lines
	 */
	protected CSSBlock checkBlocksForDuplicateLines(CSSBlock blockToCompare)
	{
		List<CSSBlock> bl = getAllCSSBlocks();
		for (CSSBlock cssBlock : bl)
		{
			if (blockToCompare.equals(cssBlock))
			{
				return cssBlock;
			}
		}
		return null;
	}

	/**
	 * Adds a block to the CSS Composer
	 *
	 * @param block
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	public List<CSSBlock> addBlock(List<CSSBlock> block)
	{
		block.forEach(this::addBlock);
		return block;
	}

	/**
	 * Checks if the ID of a block is loaded for this composer
	 *
	 * @param block
	 * 		The block to check
	 *
	 * @return True if the ID is already complete
	 */
	protected boolean idAlreadyLoaded(CSSBlock block)
	{
		return getAllCSSBlocks().stream()
		                        .anyMatch(cssBlock -> (block.getIdOfBlock()
		                                                    .equalsIgnoreCase(cssBlock.getIdOfBlock())));
	}

	/**
	 * Returns the generated CSS as small as possible
	 *
	 * @param ajax
	 * 		Placeholder - will always render as in-line
	 *
	 * @return The generated CSS
	 */
	public String toString(boolean ajax)
	{
		if (ajax)
		{
			StringBuilder cssBlocksSB = new StringBuilder();
			getAllCSSBlocks().forEach(cSSBlock ->
			                          {
				                          CSSBlockIdentifier oldIdent = cSSBlock.getBlockIdentifer();
				                          cSSBlock.setBlockIdentifer(CSSBlockIdentifier.Inline);
				                          if (!cSSBlock.toString()
				                                       .isEmpty())
				                          {
					                          cssBlocksSB.append(cSSBlock)
					                                     .append(cSSBlock.getBlockIdentifer() == CSSBlockIdentifier.Inline ? "" : "\n");
				                          }
				                          cSSBlock.setBlockIdentifer(oldIdent);
			                          });
			return cssBlocksSB.toString();
		}
		else
		{
			return toString();
		}
	}

	/**
	 * Returns the generated CSS as small as possible
	 *
	 * @return The generated CSS
	 */
	@Override
	public String toString()
	{
		StringBuilder cssBlocksSB = new StringBuilder();
		getAllCSSBlocks().forEach(cSSBlock ->
		                          {
			                          if (!cSSBlock.toString()
			                                       .isEmpty())
			                          {
				                          cssBlocksSB.append(cSSBlock);
			                          }
		                          });
		return cssBlocksSB.toString();
	}
}
