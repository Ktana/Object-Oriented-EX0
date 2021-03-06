/*
 * Copyright 2007 the original author or authors.
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

package org.jsefa.csv.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.jsefa.common.annotation.NoValidatorType;
import org.jsefa.common.mapping.EntryPoint;
import org.jsefa.common.validator.Validator;

/**
 * An annotation declaring a CSV data type.
 * 
 * @author Norman Lahme-Huetig
 * 
 */
@Retention(RUNTIME)
@Target({TYPE})
public @interface CsvDataType {
    /**
     * The name of the data type. The name must be unique within the set of data types used within one CSV
     * document. If it is not explicitly set it will be generated automatically from the class name.
     */
    String name() default "";

    /**
     * The default prefix of the CSV the annotated class describes. The prefix is used to determine the
     * {@link EntryPoint} during deserialization or serialization. By defining prefixes one can write different
     * record types into the same stream.
     */
    String defaultPrefix() default "";

    /**
     * Specifies the validator type to be used for the default case.
     */
    Class<? extends Validator> defaultValidatorType() default NoValidatorType.class;
}
