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

package com.jwebmp;

import com.jwebmp.guiceinjection.GuiceContext;
import com.jwebmp.logger.LogFactory;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author mmagon
 */
public class LoggerFactoryTest
{

	private LogFactory instance;

	public LoggerFactoryTest()
	{
		instance = LogFactory.getInstance();
	}

	/**
	 * Test of addLogAppender method, of class LogFactory.
	 */
	@Test
	public void testAddLogAppender()
	{
		System.out.println("Testing Log Appender Adding and Removing");
		Logger log = instance.getLogger("new lo g");
		log.info("yes");
		log.config("debug");
		log.log(Level.WARNING, "warn");
		log.log(Level.SEVERE, "error");
		log.log(Level.FINE, "trace");
	}

	/**
	 * Test of addLogAppender method, of class LogFactory.
	 */
	@Test
	public void testInitialize()
	{
		System.out.println("Testing Initialization");
		GuiceContext.inject();
		System.out.println("Testing Initialization");
		GuiceContext.inject();
		GuiceContext.reflect();
	}

}
