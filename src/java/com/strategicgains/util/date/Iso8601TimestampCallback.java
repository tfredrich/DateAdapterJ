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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.strategicgains.util.AdapterCallback;

/**
 * @author Todd Fredrich
 * @since April 7, 2010
 */
public class Iso8601TimestampCallback
implements AdapterCallback<String>
{
	private static final String SHORT_TZ_REGEX = ".*T.*[-+]\\d\\d$";
	private static final String COLON_DELIM_TZ_REGEX = "([-+]\\d\\d):(\\d\\d)$";
	
	private static final Pattern SHORT_TZ_PATTERN = Pattern.compile(SHORT_TZ_REGEX);
	private static final Pattern COLON_TZ_PATTERN = Pattern.compile(".*T.*" + COLON_DELIM_TZ_REGEX);

	@Override
	public String process(String string)
	{
		if (SHORT_TZ_PATTERN.matcher(string).matches())
		{
			return string + "00";
		}
		else
		{
			Matcher colonMatcher = COLON_TZ_PATTERN.matcher(string);

			if (colonMatcher.matches())
			{
				return string.replaceAll(COLON_DELIM_TZ_REGEX, colonMatcher.group(1) + colonMatcher.group(2));
			}
		}

		return string;
	}
}
