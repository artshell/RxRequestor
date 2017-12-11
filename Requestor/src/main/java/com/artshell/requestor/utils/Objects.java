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
 * Created by artshell on 2017/11/1.
 */

public class Objects {
    private Objects() {
        throw new AssertionError("No com.artshell.utils.common.Objects instances for you!");
    }

    public static <T> T requireNonNull(T obj) {
        if (obj == null)
            throw new NullPointerException();
        return obj;
    }

    public static <T> T requireNonNull(T obj, String tip) {
        if (obj == null)
            throw new NullPointerException(tip);
        return obj;
    }

    public static <T> T requireNonNull(T obj, Provider<String> tipProvider) {
        if (obj == null)
            throw new NullPointerException(tipProvider.get());
        return obj;
    }
}
