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
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Before;
import org.junit.Test;


public class DateFormatProcessorTest
{
	private DateFormatProcessor dfp = new DateFormatProcessor("yyyy-MM-dd'T'HH:mm:ss'Z'",
		"yyyy-MM-dd'T'HH:mm:ssZ",
		"yyyy-MM-dd",
		"MM/dd/yyyy");
	private Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
	
	@Before
	public void setup()
	{
		calendar.clear();
	}

	@Test
	public void shouldConvertOutputToUTC()
	{
		TimeZone tz = TimeZone.getTimeZone("MST");
		Calendar c = Calendar.getInstance(tz);
		c.clear(); // reset milliseconds
		c.set(2010, Calendar.APRIL, 7, 11, 52, 17); // 2010-04-07T11:52:17 -07:00
		assertEquals("2010-04-07T18:52:17Z", dfp.format(c.getTime()));
	}

	@Test
	public void shouldParse_yyyyMMdd()
	throws ParseException
	{
		Date date = dfp.parse("2010-04-07");
		assertNotNull(date);

		calendar.setTime(date);
		assertEquals(2010, calendar.get(Calendar.YEAR));
		assertEquals(Calendar.APRIL, calendar.get(Calendar.MONTH));
		assertEquals(7, calendar.get(Calendar.DAY_OF_MONTH));
		assertTimePortionEmpty();
	}

	@Test
	public void shouldParse_MMddyyyy()
	throws ParseException
	{
		Date date = dfp.parse("04/07/2010");
		assertNotNull(date);

		calendar.setTime(date);
		assertEquals(2010, calendar.get(Calendar.YEAR));
		assertEquals(Calendar.APRIL, calendar.get(Calendar.MONTH));
		assertEquals(7, calendar.get(Calendar.DAY_OF_MONTH));
		assertTimePortionEmpty();
	}

	@Test
	public void shouldParse_yyyyMMddTHHmmssz()
	throws ParseException
	{
		Date date = dfp.parse("2010-04-07T11:52:17GMT-07:00");
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
	public void shouldThrowParseException()
	{
		try
		{
			dfp.parse("todd-fredrich");
			fail("ParseException not thrown on invalid date.");
		}
		catch (ParseException e)
		{
			// expected.
		}
	}

	private void assertTimePortionEmpty()
	{
		assertEquals(0, calendar.get(Calendar.HOUR_OF_DAY));
		assertEquals(0, calendar.get(Calendar.MINUTE));
		assertEquals(0, calendar.get(Calendar.SECOND));
		assertEquals(0, calendar.get(Calendar.MILLISECOND));
	}
}
