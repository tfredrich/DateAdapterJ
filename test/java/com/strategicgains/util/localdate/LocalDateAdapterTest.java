/*
 * Copyright 2010, Strategic Gains, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.strategicgains.util.localdate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

/**
 * Test the default, out-of-the-box date format support.
 * 
 * @author toddf
 * @since April 7, 2010
 */
public class LocalDateAdapterTest
{
	private LocalDateAdapter adapter = new LocalDateAdapter();
	
	@Test
	public void shouldOutput_yyyy_MM_dd()
	{
		LocalDate date = LocalDate.of(2010, 4, 7);
		assertEquals("2010-04-07", adapter.format(date));
	}

	@Test
	public void shouldParse_yyyy_MM_dd()
	throws ParseException
	{
		LocalDate date = adapter.parse("2010-04-07");
		assertNotNull(date);

		assertEquals(2010, date.getYear());
		assertEquals(Month.APRIL, date.getMonth());
		assertEquals(7, date.getDayOfMonth());
	}

	@Test
	public void shouldParse_yyyyMMdd()
	throws ParseException
	{
		LocalDate date = adapter.parse("20100407");
		assertNotNull(date);

		assertEquals(2010, date.getYear());
		assertEquals(Month.APRIL, date.getMonth());
		assertEquals(7, date.getDayOfMonth());
	}

	@Test
	public void shouldParse_MMddyyyy()
	throws ParseException
	{
		LocalDate date = adapter.parse("04/07/2010");
		assertNotNull(date);

		assertEquals(2010, date.getYear());
		assertEquals(Month.APRIL, date.getMonth());
		assertEquals(7, date.getDayOfMonth());
	}

	@Test
	public void shouldParse_yyMMdd()
	throws ParseException
	{
		LocalDate date = adapter.parse("100407");
		assertNotNull(date);

		assertEquals(2010, date.getYear());
		assertEquals(Month.APRIL, date.getMonth());
		assertEquals(7, date.getDayOfMonth());
	}
}
