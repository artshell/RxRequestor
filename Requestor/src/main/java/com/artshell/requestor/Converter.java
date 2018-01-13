/*
 * Copyright 2017 artshell. https://github.com/artshell
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.artshell.requestor;

import java.io.IOException;

import okhttp3.ResponseBody;

/**
 * @author artshell on 02/12/2017
 */

public interface Converter {
    /**
     * @param target    custom type, {@link ResponseBody}, {@link Byte} arrays, {@link java.io.Reader}
     *                  {@link java.io.InputStream}, {@link String}
     * @param body
     * @param <T>
     * @return
     * @throws IOException
     */
    <T> T apply(Class<T> target, ResponseBody body) throws IOException;
}
