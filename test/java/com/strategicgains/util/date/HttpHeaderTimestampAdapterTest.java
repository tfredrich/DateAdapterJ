/*
    Copyright 2011, Strategic Gains, Inc.

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

		http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
*/
package com.strategicgains.util.date;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Before;
import org.junit.Test;

/**
 * @author toddf
 * @since Oct 4, 2011
 */
public class HttpHeaderTimestampAdapterTest
{
	private DateAdapter adapter = new HttpHeaderTimestampAdapter();
	private Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
	
	@Before
	public void setup()
	{
		calendar.clear();
	}

	@Test
	public void shouldOutput_Day_dd_MMM_yyyy_HH_mm_ss_GMT()
	{
		calendar.set(2010, Calendar.APRIL, 7, 13, 30, 37);
		calendar.set(Calendar.MILLISECOND, 123);
		assertEquals("Wed, 07 Apr 2010 13:30:37 GMT", adapter.format(calendar.getTime()));
	}

	@Test
	public void shouldParse_ZeroTime()
	throws ParseException
	{
		Date date = adapter.parse("Sun, 06 Nov 1994 00:00:00 GMT");
		assertNotNull(date);

		calendar.setTime(date);
		assertEquals(1994, calendar.get(Calendar.YEAR));
		assertEquals(Calendar.NOVEMBER, calendar.get(Calendar.MONTH));
		assertEquals(6, calendar.get(Calendar.DAY_OF_MONTH));
		assertEquals(0, calendar.get(Calendar.HOUR_OF_DAY));
		assertEquals(0, calendar.get(Calendar.MINUTE));
		assertEquals(0, calendar.get(Calendar.SECOND));
	}

	@Test
	public void shouldParse_MaxTime()
	throws ParseException
	{
		Date date = adapter.parse("Sun, 06 Nov 1994 23:59:59 GMT");
		assertNotNull(date);

		calendar.setTime(date);
		assertEquals(1994, calendar.get(Calendar.YEAR));
		assertEquals(Calendar.NOVEMBER, calendar.get(Calendar.MONTH));
		assertEquals(6, calendar.get(Calendar.DAY_OF_MONTH));
		assertEquals(23, calendar.get(Calendar.HOUR_OF_DAY));
		assertEquals(59, calendar.get(Calendar.MINUTE));
		assertEquals(59, calendar.get(Calendar.SECOND));
	}

	@Test
	public void shouldParse_Day_dd_MMM_yyyy_HH_mm_ss_GMT()
	throws ParseException
	{
		Date date = adapter.parse("Sun, 06 Nov 1994 08:49:37 GMT");
		assertNotNull(date);

		calendar.setTime(date);
		assertEquals(1994, calendar.get(Calendar.YEAR));
		assertEquals(Calendar.NOVEMBER, calendar.get(Calendar.MONTH));
		assertEquals(6, calendar.get(Calendar.DAY_OF_MONTH));
		assertEquals(8, calendar.get(Calendar.HOUR_OF_DAY));
		assertEquals(49, calendar.get(Calendar.MINUTE));
		assertEquals(37, calendar.get(Calendar.SECOND));
	}

	@Test
	public void shouldParse_Day_dd_MMM_yy_HH_mm_ss_GMT()
	throws ParseException
	{
		Date date = adapter.parse("Sunday, 06-Nov-94 08:49:37 GMT");
		assertNotNull(date);

		calendar.setTime(date);
		assertEquals(1994, calendar.get(Calendar.YEAR));
		assertEquals(Calendar.NOVEMBER, calendar.get(Calendar.MONTH));
		assertEquals(6, calendar.get(Calendar.DAY_OF_MONTH));
		assertEquals(8, calendar.get(Calendar.HOUR_OF_DAY));
		assertEquals(49, calendar.get(Calendar.MINUTE));
		assertEquals(37, calendar.get(Calendar.SECOND));
	}

	@Test
	public void shouldParse_Day_d_MMM_HH_mm_ss_yyyy()
	throws ParseException
	{
		Date date = adapter.parse("Sun Nov  6 08:49:37 1994");
		assertNotNull(date);

		calendar.setTime(date);
		assertEquals(1994, calendar.get(Calendar.YEAR));
		assertEquals(Calendar.NOVEMBER, calendar.get(Calendar.MONTH));
		assertEquals(6, calendar.get(Calendar.DAY_OF_MONTH));
		assertEquals(8, calendar.get(Calendar.HOUR_OF_DAY));
		assertEquals(49, calendar.get(Calendar.MINUTE));
		assertEquals(37, calendar.get(Calendar.SECOND));
	}

	@Test
	public void shouldParse_Day_dd_MMM_HH_mm_ss_yyyy()
	throws ParseException
	{
		Date date = adapter.parse("Sun Nov 16 08:49:37 1994");
		assertNotNull(date);

		calendar.setTime(date);
		assertEquals(1994, calendar.get(Calendar.YEAR));
		assertEquals(Calendar.NOVEMBER, calendar.get(Calendar.MONTH));
		assertEquals(16, calendar.get(Calendar.DAY_OF_MONTH));
		assertEquals(8, calendar.get(Calendar.HOUR_OF_DAY));
		assertEquals(49, calendar.get(Calendar.MINUTE));
		assertEquals(37, calendar.get(Calendar.SECOND));
	}

	@Test
	public void shouldParse_yyyy_MM_ddTHH_mm_ss_SSSZ()
	throws ParseException
	{
		Date date = adapter.parse("2010-04-07T11:52:13.123Z");
		assertNotNull(date);

		calendar.setTime(date);
		assertEquals(2010, calendar.get(Calendar.YEAR));
		assertEquals(Calendar.APRIL, calendar.get(Calendar.MONTH));
		assertEquals(7, calendar.get(Calendar.DAY_OF_MONTH));
		assertEquals(11, calendar.get(Calendar.HOUR_OF_DAY));
		assertEquals(52, calendar.get(Calendar.MINUTE));
		assertEquals(13, calendar.get(Calendar.SECOND));
		assertEquals(123, calendar.get(Calendar.MILLISECOND));
	}

	@Test
	public void shouldParse_yyyy_MM_dd()
	throws ParseException
	{
		Date date = adapter.parse("2010-04-07");
		assertNotNull(date);

		calendar.setTime(date);
		assertEquals(2010, calendar.get(Calendar.YEAR));
		assertEquals(Calendar.APRIL, calendar.get(Calendar.MONTH));
		assertEquals(7, calendar.get(Calendar.DAY_OF_MONTH));
		assertEquals(0, calendar.get(Calendar.HOUR_OF_DAY));
		assertEquals(0, calendar.get(Calendar.MINUTE));
		assertEquals(0, calendar.get(Calendar.SECOND));
		assertEquals(0, calendar.get(Calendar.MILLISECOND));
	}
}
