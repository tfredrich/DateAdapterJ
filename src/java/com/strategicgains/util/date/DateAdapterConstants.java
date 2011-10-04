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

import java.util.TimeZone;

/**
 * Defines the default formats and constants for Date and Timestamp adapters.
 * 
 * @author toddf
 * @since Nov 13, 2009
 */
public final class DateAdapterConstants
{
	// All dates and times marshaled within Dynamic-DTO are converted to UTC.
	public static final TimeZone UNIVERSAL_TIME_ZONE = TimeZone.getTimeZone("UTC");


	// SECTION: Date-related constants.
	
	public static final String DATE_OUTPUT_FORMAT = "yyyy-MM-dd";
	public static final String[] DATE_INPUT_FORMATS =
	{
		DATE_OUTPUT_FORMAT,
		"yyyyMMdd",
		"MM/dd/yyyy",
		"yyMMdd"
	};

	
	// SECTION: Time stamp-related constants.
	
	public static final String TIME_POINT_OUTPUT_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	public static final String TIMESTAMP_OUTPUT_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
	public static final String[] TIMESTAMP_INPUT_FORMATS =
	{
		TIMESTAMP_OUTPUT_FORMAT,
		"yyyy-MM-dd'T'HH:mm:ss.SSSZ",

		TIME_POINT_OUTPUT_FORMAT,
		"yyyy-MM-dd'T'HH:mm:ssZ",

		"yyyy-MM-dd'T'HHmmss'Z'",
		"yyyy-MM-dd'T'HHmmssZ",

		"yyyy-MM-dd'T'HH:mm'Z'",
		"yyyy-MM-dd'T'HH:mmZ",

		"yyyy-MM-dd'T'HHmm'Z'",
		"yyyy-MM-dd'T'HHmmZ"
	};
	
	
	// SECTION: RFC 1123 related constants (used for dates/timestamps in HTTP headers)
	
	public static final String RFC1123_OUTPUT_FORMAT = "EEE, dd MMM yyyy HH:mm:ss 'GMT'";  //e.g. Sun, 06 Nov 1994 08:49:37 GMT  ; RFC 822, updated by RFC 1123
	public static final String[] RFC1123_INPUT_FORMATS =
	{
		"EEE, dd MMM yyyy HH:mm:ss z",	//e.g. Sun, 06 Nov 1994 08:49:37 GMT ; RFC 822, updated by RFC 1123
		"EEEE, dd-MMM-yy HH:mm:ss z",	//e.g. Sunday, 06-Nov-94 08:49:37 GMT ; RFC 850, obsoleted by RFC 1036
		"EEE MMM d HH:mm:ss yyyy",		//e.g. Sun Nov  6 08:49:37 1994 ; ANSI C's asctime() format
		TIMESTAMP_OUTPUT_FORMAT,		// Default time stamp format from TimestampAdapter.
		DATE_OUTPUT_FORMAT				// Default date format from DateAdapter.
	};

	
	// SECTION: CONSTRUTOR - PRIVATE
	
	private DateAdapterConstants()
    {
		// prevents instantiation.
    }
}
