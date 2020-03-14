/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.config;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.util.ClassUtils;

/**
 * @author Dave Syer
 *
 */
public class ApplicationBuilder {

	public static SpringApplicationBuilder builder(Class<?> type) {
		// Defensive reflective builder to work with Boot 1.5 and 2.0
		if (ClassUtils.hasConstructor(SpringApplicationBuilder.class, Class[].class)) {
			return BeanUtils
					.instantiateClass(
							ClassUtils.getConstructorIfAvailable(
									SpringApplicationBuilder.class, Class[].class),
							(Object) new Class<?>[] { type });
		}
		return BeanUtils
				.instantiateClass(
						ClassUtils.getConstructorIfAvailable(
								SpringApplicationBuilder.class, Object[].class),
						(Object) new Object[] { type.getName() });
	}

}
