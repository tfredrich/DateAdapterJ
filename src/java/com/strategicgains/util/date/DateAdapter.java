/*
 * Copyright 2009, Strategic Gains, Inc.
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

import static com.strategicgains.util.date.DateAdapterConstants.DATE_INPUT_FORMATS;
import static com.strategicgains.util.date.DateAdapterConstants.DATE_OUTPUT_FORMAT;

import java.text.ParseException;
import java.util.Date;

import com.strategicgains.util.TextAdapter;


/**
 * Handles Date conversion from/to String via a DateFormatProcessor.  The default input and output formats
 * are discussed in DateAdapterConstants.
 * 
 * @author toddf
 * @since Nov 13, 2009
 * @see DateFormatProcessor
 * @see DateAdapterConstants
 */
public class DateAdapter
implements TextAdapter<Date>
{
	// SECTION: INSTANCE VARIABLES

	private DateFormatProcessor processor;

	
	// SECTION: CONSTRUCTOR

	public DateAdapter()
	{
		this(DATE_OUTPUT_FORMAT, DATE_INPUT_FORMATS);
	}
	
	protected DateAdapter(String outputFormat, String... inputFormats)
	{
		this.processor = new DateFormatProcessor(outputFormat, inputFormats);
	}

	
	// SECTION: FORMATTING
	
	@Override
	public Date parse(String dateString)
	throws ParseException
	{
		return processor.parse(dateString);
	}
	
	@Override
	public String format(Date date)
	{
		return processor.format(date);
	}
}
