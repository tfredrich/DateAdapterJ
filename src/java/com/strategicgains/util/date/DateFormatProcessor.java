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
import static com.strategicgains.util.date.DateAdapterConstants.UNIVERSAL_TIME_ZONE;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.strategicgains.util.TextAdapter;
/**
 * Responsible for using converting java.util.Data instances to and from strings.
 * 
 * <p>The constructor accepts a list of input formats (see SimpleDateFormat) and an output format.
 * The input formats are those date formats, in priority order, that the input accepts as valid.
 * The output format is the date format always used for output.  It is good form to have the first
 * input format match the output format.
 * 
 * @author Todd Fredrich
 * @since Nov 13, 2009
 */
public class DateFormatProcessor
implements TextAdapter<Date>
{
	private DateFormat[] inputFormats;
	private DateFormat outputFormat;
	
	public DateFormatProcessor(List<String> inputFormats, String outputFormat)
	{
		this(inputFormats.toArray(new String[0]), outputFormat);
	}

	/**
	 * Utilizes string representations to initialize the internal input and output DateFormats.
	 * Note that all format strings are converted to DateFormats internally with their timezone set to UTC.
	 * This means that dates accepted as input will be returned on output as UTC correctly converted.  It works
	 * well to keep everything internal to the service as UTC, but clients will have to convert to
	 * the local timezone before presentation to the user, if necessary.
	 *
	 * @param inputFormatStrings Array of SimpleDateFormat strings representing date formats accepted as input.
	 * @param outputFormat SimpleDateFormat string representing the output date format.
	 */
	public DateFormatProcessor(String[] inputFormatStrings, String outputFormat)
	{
		this.outputFormat = new SimpleDateFormat(outputFormat);
		this.outputFormat.setTimeZone(UNIVERSAL_TIME_ZONE);
		this.inputFormats = new SimpleDateFormat[inputFormatStrings.length];
		
		for (int i = 0; i < this.inputFormats.length; ++i)
		{
			this.inputFormats[i] = new SimpleDateFormat(inputFormatStrings[i]);
			this.inputFormats[i].setTimeZone(UNIVERSAL_TIME_ZONE);
		}
	}
	
	/**
	 * Utilizes DateFormat instances to initialize the internal input and output DateFormats.
	 * Use this constructor to set the desired internal timezone to something other than UTC.
	 * 
	 * @param inputFormats Array of DateFormat instances for accepting input dates.
	 * @param outputFormat DateFormat for date output.
	 */
	public DateFormatProcessor(DateFormat[] inputFormats, DateFormat outputFormat)
	{
		this.outputFormat = (DateFormat) outputFormat.clone();
		this.inputFormats = new DateFormat[inputFormats.length];
		
		for (int i = 0; i < this.inputFormats.length; ++i)
		{
			this.inputFormats[i] = (DateFormat) inputFormats[i].clone();	
		}
	}
	
	/**
	 * Attempts to parse the given string into a java.util.Date using the provided
	 * input formats.
	 * 
	 * @param dateString a date string in one of the acceptable formats.
	 * @throws ParseException if the date is not in one of the input formats.
	 */
	public Date parse(String dateString)
	throws ParseException
	{
		Date result = null;
		ParseException lastException = null;
		
		for (DateFormat format : inputFormats)
		{
			try
			{
				result = ((DateFormat) format.clone()).parse(dateString);	// DateFormat is not thread safe.
				lastException = null;
				break;
			}
			catch (ParseException e)
			{
				// Keep the first exception that occurred.
				if (lastException == null)
				{
					lastException = e;
				}
				// And just try the next input format.
			}
		}

		if (lastException != null)
		{
			throw lastException;
		}

		return result;
	}
	
	/**
	 * Formats the given java.util.Date into a string using the output format provided in the
	 * constructor.
	 * 
	 * @param date a java.util.Date
	 */
	public String format(Date date)
	{
		return ((DateFormat) outputFormat.clone()).format(date);		// DateFormat is not thread safe.
	}
}
