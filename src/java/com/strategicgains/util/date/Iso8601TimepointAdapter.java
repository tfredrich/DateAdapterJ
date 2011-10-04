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


/**
 * Utilizes the {@link Iso8601TimepointCallback} to implement ISO 8601 time point parsing and formatting.
 * 
 * @author toddf
 * @since Nov 13, 2009
 */
public class Iso8601TimepointAdapter
extends TimestampAdapter
{
	public Iso8601TimepointAdapter()
	{
		super();
		setPreParseCallback(new Iso8601TimepointCallback());
	}
}
