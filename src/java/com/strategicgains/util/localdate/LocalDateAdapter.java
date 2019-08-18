/*
    Copyright 2019, Strategic Gains, Inc.

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
package com.strategicgains.util.localdate;

import static com.strategicgains.util.date.DateAdapterConstants.DATE_INPUT_FORMATS;
import static com.strategicgains.util.date.DateAdapterConstants.DATE_OUTPUT_FORMAT;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.strategicgains.util.TextAdapter;
import com.strategicgains.util.date.DateFormatProcessor;

/**
 * @author toddf
 * @since Aug 16, 2019
 */
public class LocalDateAdapter
implements TextAdapter<LocalDate>
{
	private static final ZoneId ZONE_ID = ZoneId.of("UTC").normalized();

	private DateFormatProcessor processor;

	public LocalDateAdapter()
	{
		processor = new DateFormatProcessor(DATE_OUTPUT_FORMAT, DATE_INPUT_FORMATS);
	}

	@Override
	public LocalDate parse(String value)
	throws ParseException
	{
		Date date = processor.parse(value);
		return date.toInstant()
			.atZone(ZONE_ID)
			.toLocalDate();
	}

	@Override
	public String format(LocalDate value)
	{
		return value.format(DateTimeFormatter.ofPattern(DATE_OUTPUT_FORMAT));
	}
}
