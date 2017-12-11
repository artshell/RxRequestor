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

package com.artshell.requestor.utils;

/**
 * Created by artshell on 2017/11/22.
 */

public class ClassExclude {
    public static <T> void exclude(Class<T> clz) {
        Objects.requireNonNull(clz, "clz == null");
        if (clz == byte.class || clz == Byte.class || clz == byte[].class) {
            throw new IllegalStateException("You should use Byte[].class as parameterize type, eg: Flowable<Byte[]>> post(Byte[].class ...)");
        }

        if (clz == void.class || clz == Void.TYPE) {
            throw new IllegalStateException("The Void class cannot be instantiated");
        }
    }
}
