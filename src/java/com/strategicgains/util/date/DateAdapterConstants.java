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
		"yyyy-MM-dd'T'HH:mm:ss.SSSZZ:ZZ",
		"yyyy-MM-dd'T'HH:mm:ss.SSSZ",

		TIME_POINT_OUTPUT_FORMAT,
		"yyyy-MM-dd'T'HH:mm:ssZZ:ZZ",
		"yyyy-MM-dd'T'HH:mm:ssZ",

		"yyyy-MM-dd'T'HH:mm'Z'",
		"yyyy-MM-dd'T'HH:mmZZ:ZZ",
		"yyyy-MM-dd'T'HH:mmZ",
	};

	
	// SECTION: CONSTRUTOR - PRIVATE
	
	private DateAdapterConstants()
    {
		// prevents instantiation.
    }
}
