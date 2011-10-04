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

import static com.strategicgains.util.date.DateAdapterConstants.RFC1123_OUTPUT_FORMAT;
import static com.strategicgains.util.date.DateAdapterConstants.RFC1123_INPUT_FORMATS;;

/**
 * This timestamp adapter conforms to the HTTP 1.1 (RFC 1123) specification for reading and writing full dates in HTTP headers.
 * <p/>
 * From the spec:<br/>
 * HTTP applications have historically allowed three different formats for the representation of date/time stamps:
 * <p/>
 *       Sun, 06 Nov 1994 08:49:37 GMT  ; RFC 822, updated by RFC 1123<br/>
 *       Sunday, 06-Nov-94 08:49:37 GMT ; RFC 850, obsoleted by RFC 1036<br/>
 *       Sun Nov  6 08:49:37 1994       ; ANSI C's asctime() format<br/>
 * <p/>
 * The first format is preferred as an Internet standard and represents a fixed-length subset of that defined by RFC 1123 [8]
 * (an update to RFC 822 [9]). The second format is in common use, but is based on the obsolete RFC 850 [12] date format and
 * lacks a four-digit year. HTTP/1.1 clients and servers that parse the date value MUST accept all three formats (for
 * compatibility with HTTP/1.0), though they MUST only generate the RFC 1123 format for representing HTTP-date values in header
 * fields. See section 19.3 for further information.
 * <p/>
 * All HTTP date/time stamps MUST be represented in Greenwich Mean Time (GMT), without exception. For the purposes of HTTP,
 * GMT is exactly equal to UTC (Coordinated Universal Time). This is indicated in the first two formats by the inclusion of
 * "GMT" as the three-letter abbreviation for time zone, and MUST be assumed when reading the asctime format. HTTP-date is case
 * sensitive and MUST NOT include additional LWS beyond that specifically included as SP in the grammar.
 * <p/>
 * Oh, by the way, this adapter also parses the default time stamp format output by TimestampAdapter and the default
 * date format output by DateAdapter.
 * 
 * @author toddf
 * @since Oct 3, 2011
 */
public class HttpHeaderTimestampAdapter
extends DateAdapter
{
	public HttpHeaderTimestampAdapter()
	{
		super(RFC1123_OUTPUT_FORMAT, RFC1123_INPUT_FORMATS);
	}
}
