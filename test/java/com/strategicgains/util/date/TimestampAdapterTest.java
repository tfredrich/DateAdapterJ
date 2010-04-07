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

package com.strategicgains.util.date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Before;
import org.junit.Test;

/**
 * Test the default, out-of-the-box date format support.
 * 
 * @author toddf
 * @since April 7, 2010
 */
public class TimestampAdapterTest
{
	private DateAdapter adapter = new TimestampAdapter();
	private Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
	
	@Before
	public void setup()
	{
		calendar.clear();
	}
	
	@Test
	public void shouldOutput_yyyyMMddTHHmmssSSSz()
	{
		calendar.set(2010, Calendar.APRIL, 7, 13, 30, 37);
		calendar.set(Calendar.MILLISECOND, 123);
		assertEquals("2010-04-07T13:30:37.123UTC", adapter.format(calendar.getTime()));
	}

	@Test
	public void shouldParse_yyyyMMdd()
	throws ParseException
	{
		Date date = adapter.parse("2010-04-07");
		assertNotNull(date);

		calendar.setTime(date);
		assertEquals(2010, calendar.get(Calendar.YEAR));
		assertEquals(Calendar.APRIL, calendar.get(Calendar.MONTH));
		assertEquals(7, calendar.get(Calendar.DAY_OF_MONTH));
		assertTimePortionEmpty();
	}

	@Test
	public void shouldParse_yyyyMMddTHHmmz()
	throws ParseException
	{
		Date date = adapter.parse("2010-04-07T11:52GMT-07:00");
		assertNotNull(date);

		calendar.setTime(date);
		assertEquals(2010, calendar.get(Calendar.YEAR));
		assertEquals(Calendar.APRIL, calendar.get(Calendar.MONTH));
		assertEquals(7, calendar.get(Calendar.DAY_OF_MONTH));
		assertEquals(18, calendar.get(Calendar.HOUR_OF_DAY));
		assertEquals(52, calendar.get(Calendar.MINUTE));
		assertEquals(0, calendar.get(Calendar.SECOND));
		assertEquals(0, calendar.get(Calendar.MILLISECOND));
	}

	@Test
	public void shouldParse_yyyyMMddTHHmmZ()
	throws ParseException
	{
		Date date = adapter.parse("2010-04-07T11:52-0700");
		assertNotNull(date);

		calendar.setTime(date);
		assertEquals(2010, calendar.get(Calendar.YEAR));
		assertEquals(Calendar.APRIL, calendar.get(Calendar.MONTH));
		assertEquals(7, calendar.get(Calendar.DAY_OF_MONTH));
		assertEquals(18, calendar.get(Calendar.HOUR_OF_DAY));
		assertEquals(52, calendar.get(Calendar.MINUTE));
		assertEquals(0, calendar.get(Calendar.SECOND));
		assertEquals(0, calendar.get(Calendar.MILLISECOND));
	}

	@Test
	public void shouldParse_yyyyMMddTHHmmssz()
	throws ParseException
	{
		Date date = adapter.parse("2010-04-07T11:52:17GMT-07:00");
		assertNotNull(date);

		calendar.setTime(date);
		assertEquals(2010, calendar.get(Calendar.YEAR));
		assertEquals(Calendar.APRIL, calendar.get(Calendar.MONTH));
		assertEquals(7, calendar.get(Calendar.DAY_OF_MONTH));
		assertEquals(18, calendar.get(Calendar.HOUR_OF_DAY));
		assertEquals(52, calendar.get(Calendar.MINUTE));
		assertEquals(17, calendar.get(Calendar.SECOND));
		assertEquals(0, calendar.get(Calendar.MILLISECOND));
	}

	@Test
	public void shouldParse_yyyyMMddTHHmmssSSSz()
	throws ParseException
	{
		Date date = adapter.parse("2010-04-07T11:52:17.123GMT-07:00");
		assertNotNull(date);

		calendar.setTime(date);
		assertEquals(2010, calendar.get(Calendar.YEAR));
		assertEquals(Calendar.APRIL, calendar.get(Calendar.MONTH));
		assertEquals(7, calendar.get(Calendar.DAY_OF_MONTH));
		assertEquals(18, calendar.get(Calendar.HOUR_OF_DAY));
		assertEquals(52, calendar.get(Calendar.MINUTE));
		assertEquals(17, calendar.get(Calendar.SECOND));
		assertEquals(123, calendar.get(Calendar.MILLISECOND));
	}

	@Test
	public void shouldParse_yyyyMMddTHHmmssZ()
	throws ParseException
	{
		Date date = adapter.parse("2010-04-07T11:52:17-0700");
		assertNotNull(date);

		calendar.setTime(date);
		assertEquals(2010, calendar.get(Calendar.YEAR));
		assertEquals(Calendar.APRIL, calendar.get(Calendar.MONTH));
		assertEquals(7, calendar.get(Calendar.DAY_OF_MONTH));
		assertEquals(18, calendar.get(Calendar.HOUR_OF_DAY));
		assertEquals(52, calendar.get(Calendar.MINUTE));
		assertEquals(17, calendar.get(Calendar.SECOND));
		assertEquals(0, calendar.get(Calendar.MILLISECOND));
	}

	@Test
	public void shouldParse_yyyyMMddTHHmmssSSSZ()
	throws ParseException
	{
		Date date = adapter.parse("2010-04-07T11:52:17.123-0700");
		assertNotNull(date);

		calendar.setTime(date);
		assertEquals(2010, calendar.get(Calendar.YEAR));
		assertEquals(Calendar.APRIL, calendar.get(Calendar.MONTH));
		assertEquals(7, calendar.get(Calendar.DAY_OF_MONTH));
		assertEquals(18, calendar.get(Calendar.HOUR_OF_DAY));
		assertEquals(52, calendar.get(Calendar.MINUTE));
		assertEquals(17, calendar.get(Calendar.SECOND));
		assertEquals(123, calendar.get(Calendar.MILLISECOND));
	}

	private void assertTimePortionEmpty()
	{
		assertEquals(0, calendar.get(Calendar.HOUR_OF_DAY));
		assertEquals(0, calendar.get(Calendar.MINUTE));
		assertEquals(0, calendar.get(Calendar.SECOND));
		assertEquals(0, calendar.get(Calendar.MILLISECOND));
	}
}
