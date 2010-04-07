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

import static com.strategicgains.util.date.DateAdapterConstants.TIMESTAMP_INPUT_FORMATS;
import static com.strategicgains.util.date.DateAdapterConstants.TIMESTAMP_OUTPUT_FORMAT;

/**
 * @author toddf
 * @since Nov 13, 2009
 */
public class TimestampAdapter
extends DateAdapter
{
	public TimestampAdapter()
	{
		super(TIMESTAMP_OUTPUT_FORMAT, TIMESTAMP_INPUT_FORMATS);
	}
}
