/*
 * Copyright (C) 2017 GedMarc
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

package com.jwebmp.core.htmlbuilder.css.composer;

import com.jwebmp.core.htmlbuilder.css.enumarations.CSSTypes;
import com.guicedee.services.jsonrepresentation.json.StaticStrings;
import com.jwebmp.core.utilities.TextUtilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A Block of CSS
 *
 * @author MMagon
 * @version 1.0
 * @since 07 Apr 2013
 */
public class CSSBlock
{
	private static final CSSLineSorter SORTER = new CSSLineSorter();

	private List<String> linkedBlocks;
	private CSSLines cssLines;
	private CSSTypes blockType;
	private CSSBlockIdentifier blockIdentifer;
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
		if (blockID.contains(StaticStrings.STRING_SPACE))
		{
			throw new UnsupportedOperationException("Cannot create an id with a space in it");
		}
		if (blockID.isEmpty())
		{
			throw new UnsupportedOperationException("Cannot create a block with no id");
		}
		idOfBlock = blockID;
		cssLines = new CSSLines();
		cssLines.setPrettyPrint(true);
		cssLines.setRenderBraces(true);
		cssLines.setRenderInQuotations(false);
		blockType = CSSTypes.None;
		blockIdentifer = CSSBlockIdentifier.Id;
		linkedBlocks = new ArrayList();
	}

	/**
	 * Creates a new In-Line block inside quotations
	 */
	public CSSBlock()
	{
		idOfBlock = null;
		cssLines = new CSSLines();
		cssLines.setPrettyPrint(false);
		cssLines.setRenderBraces(false);
		cssLines.setRenderInQuotations(false);
		blockType = CSSTypes.None;
		blockIdentifer = CSSBlockIdentifier.Inline;
		linkedBlocks = new ArrayList<>();
	}

	/**
	 * @param blockType
	 * 		The block type, active or changed
	 * @param blockIdentifer
	 * 		The block identifier
	 * @param idOfBlock
	 * 		the id of whatever to put this onto
	 */
	public CSSBlock(CSSTypes blockType, CSSBlockIdentifier blockIdentifer, String idOfBlock)
	{
		this.blockType = blockType;
		this.idOfBlock = idOfBlock;
		this.blockIdentifer = blockIdentifer;

		cssLines = new CSSLines();
		cssLines.setPrettyPrint(true);
		cssLines.setRenderBraces(true);
		cssLines.setRenderInQuotations(false);
		linkedBlocks = new ArrayList<>();
	}

	/**
	 * @param blockType
	 * 		The block type, active or changed
	 * @param blockIdentifer
	 * 		The block identifier
	 * @param idOfBlock
	 * 		the id of whatever to put this onto
	 * @param prettyPrint
	 * 		Pretty print or not
	 * @param renderBraces
	 * 		render braces or not
	 * @param renderQuotations
	 * 		render quotations or not
	 */
	public CSSBlock(CSSTypes blockType, CSSBlockIdentifier blockIdentifer, String idOfBlock, boolean prettyPrint, boolean renderBraces, boolean renderQuotations)
	{
		this.blockType = blockType;
		this.blockIdentifer = blockIdentifer;
		this.idOfBlock = idOfBlock;

		cssLines = new CSSLines();
		cssLines.setPrettyPrint(prettyPrint);
		cssLines.setRenderBraces(renderBraces);
		cssLines.setRenderInQuotations(renderQuotations);
		linkedBlocks = new ArrayList<>();
	}

	/**
	 * Adds a property value pair to the Lines group. If it already exists, just returns it
	 *
	 * @param line
	 * 		Input Line to add to the lines collection
	 *
	 * @return The input Line
	 */
	public CSSLine add(CSSLine line)
	{
		if (line == null)
		{
			return null;
		}

		if (cssLines.getAllLines()
		            .contains(line))
		{
			return line;
		}
		else
		{
			cssLines.getAllLines()
			        .add(line);
			java.util.Collections.sort(cssLines.getAllLines(), SORTER);
			return line;
		}
	}

	/**
	 * Removes a line from the list
	 *
	 * @param line
	 * 		The line to be removed
	 *
	 * @return True if it could be removed
	 */
	public boolean remove(CSSLine line)
	{
		if (cssLines.getAllLines()
		            .contains(line))
		{
			cssLines.getAllLines()
			        .remove(line);
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Adds a block ID into this blocks generated String
	 *
	 * @param linkedBlock
	 * 		The block to test if it's contents match, if so, then it is added
	 *
	 * @return True if the block can be added to this one
	 */
	public boolean addLinkedBlock(CSSBlock linkedBlock)
	{
		addBlockID(linkedBlock.generateBlockID(linkedBlock));
		return true;
	}

	/**
	 * Returns a generated block ID to apply on top of this CSS
	 *
	 * @param block
	 * 		The linked block
	 *
	 * @return
	 */
	public String addBlockID(String block)
	{
		if (!getLinkedBlocks().contains(block))
		{
			getLinkedBlocks().add(block);
		}
		return block;
	}

	/**
	 * Returns a generated block ID to apply on top of this CSS
	 *
	 * @param block
	 * 		The linked block
	 *
	 * @return
	 */
	private String generateBlockID(CSSBlock block)
	{
		return generateBlockID(block, 0);
	}

	/**
	 * Gets the block ID's that are currently linked
	 *
	 * @return
	 */
	public List<String> getLinkedBlocks()
	{
		return linkedBlocks;
	}

	/**
	 * Returns a generated block ID to apply on top of this CSS
	 *
	 * @param block
	 * 		The linked block
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

		renderBlockIdentifier(sb, block.blockIdentifer, block);
		sb.append(block.blockType.getCssName()
		                         .trim());
		return sb.toString();
	}

	private StringBuilder renderBlockIdentifier(StringBuilder sb, CSSBlockIdentifier cssBlockIdentifier, CSSBlock block)
	{
		switch (cssBlockIdentifier)
		{
			case Class:
			{
				sb.append(StaticStrings.STRING_DOT)
				  .append(block.getIdOfBlock());
				break;
			}
			case Element:
			{
				sb.append(block.getIdOfBlock());
				break;
			}
			case Inline:
			{
				break;
			}
			case Id:
			{
				sb.append(StaticStrings.STRING_HASH)
				  .append(block.getIdOfBlock());
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
		return sb;
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

	/**
	 * Sets the block ID's that are linked to this block
	 *
	 * @param linkedBlocks
	 */
	public void setLinkedBlocks(List<String> linkedBlocks)
	{
		this.linkedBlocks = linkedBlocks;
	}

	/**
	 * @return This objects CSS Lines string
	 */
	public CSSLines getCssLines()
	{
		return cssLines;
	}

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 41 * hash + Objects.hashCode(blockIdentifer);
		hash = 41 * hash + Objects.hashCode(idOfBlock);
		return hash;
	}

	/**
	 * Compares the body string to each other
	 *
	 * @param obj
	 * 		The CSS Block to compare
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
		if (!Objects.equals(idOfBlock, other.idOfBlock))
		{
			return false;
		}
		return blockIdentifer == other.blockIdentifer;
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
	 * This blocks CSS according to how it is configured with Set tabs
	 *
	 * @param tabCount
	 *
	 * @return This blocks CSS according to how it is configured with Set tabs
	 */
	public String toString(int tabCount)
	{
		StringBuilder sb = new StringBuilder();
		if (cssLines.getAllLines()
		            .isEmpty())
		{
			return "";
		}
		sb.append(generateBlockIDS(tabCount));
		sb.append(cssLines.toString(tabCount));
		if (blockType == CSSTypes.None)
		{
			sb = new StringBuilder(sb.toString()
			                         .replaceAll(StaticStrings.STRING_COMMNA, ";"));
		}
		return sb.toString();
	}

	/**
	 * Generates this block ID
	 *
	 * @return This blocks linked and itself ID
	 */
	private String generateBlockIDS(int tabCount)
	{
		StringBuilder sb = new StringBuilder();
		for (String _item : getLinkedBlocks())
		{
			sb.append(_item);
			sb.append(StaticStrings.STRING_COMMNA);
			if ((cssLines.isPrettyPrint()))
			{
				sb.append(TextUtilities.getTabString(tabCount - 1));
			}
		}
		sb.append(generateBlockID(this));
		return sb.toString();
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
}
