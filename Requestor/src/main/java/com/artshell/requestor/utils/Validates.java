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

import java.util.Collection;
import java.util.Map;

/**
 * Created by artshell on 2017/11/23.
 */

public class Validates {
    public static void check(Class<?> clazz, Map<?, ?> map) {
        ClassExclude.exclude(clazz);
        Objects.requireNonNull(map, "map == null");
        Numbers.requireNonzero(map.size(), "map.size() == 0");
    }

    public static void check(Class<?> clazz, Map<?, ?> mapOne, Map<?, ?> mapTwo) {
        ClassExclude.exclude(clazz);
        Objects.requireNonNull(mapOne, "mapOne == null");
        Objects.requireNonNull(mapTwo, "mapTwo == null");
        Numbers.requireNonzero(mapOne.size(), "mapOne.size() == 0");
        Numbers.requireNonzero(mapTwo.size(), "mapTwo.size() == 0");
    }

    public static void check(Class<?> clazz, Map<?, ?> mapOne, Map<?, ?> mapTwo, Map<?, ?> mapThree) {
        ClassExclude.exclude(clazz);
        Objects.requireNonNull(mapOne, "mapOne == null");
        Objects.requireNonNull(mapTwo, "mapTwo == null");
        Objects.requireNonNull(mapThree, "mapThree == null");
        Numbers.requireNonzero(mapOne.size(), "mapOne.size() == 0");
        Numbers.requireNonzero(mapTwo.size(), "mapTwo.size() == 0");
        Numbers.requireNonzero(mapThree.size(), "mapThree.size() == 0");
    }

    public static void check(Class<?> clazz, Collection<?> collect) {
        ClassExclude.exclude(clazz);
        Objects.requireNonNull(collect, "collect == null");
        Numbers.requireNonzero(collect.size(), "collect.size() == 0");
    }

    public static void check(Class<?> clazz, Map<?, ?> map, Collection<?> collect) {
        ClassExclude.exclude(clazz);
        Objects.requireNonNull(map, "map == null");
        Objects.requireNonNull(collect, "collect == null");
        Numbers.requireNonzero(map.size(), "map.size() == 0");
        Numbers.requireNonzero(collect.size(), "collect.size() == 0");
    }

    public static void check(Class<?> clazz, Map<?, ?> mapOne, Map<?, ?> mapTwo, Collection<?> collect) {
        ClassExclude.exclude(clazz);
        Objects.requireNonNull(mapOne, "mapOne == null");
        Objects.requireNonNull(mapTwo, "mapTwo == null");
        Objects.requireNonNull(collect, "collect == null");
        Numbers.requireNonzero(mapOne.size(), "mapOne.size() == 0");
        Numbers.requireNonzero(mapTwo.size(), "mapTwo.size() == 0");
        Numbers.requireNonzero(collect.size(), "collect.size() == 0");
    }

    public static void check(Class<?> clazz, Object[] array) {
        ClassExclude.exclude(clazz);
        Objects.requireNonNull(array, "array == null");
        Numbers.requireNonzero(array.length, "array.length == 0");
    }

    public static void check(Class<?> clazz, Map<?, ?> map, Object[] array) {
        ClassExclude.exclude(clazz);
        Objects.requireNonNull(map, "map == null");
        Objects.requireNonNull(array, "array == null");
        Numbers.requireNonzero(map.size(), "map.size() == 0");
        Numbers.requireNonzero(array.length, "array.length == 0");
    }

    public static void check(Class<?> clazz, Map<?, ?> mapOne, Map<?, ?> mapTwo, Object[] array) {
        ClassExclude.exclude(clazz);
        Objects.requireNonNull(mapOne, "mapOne == null");
        Objects.requireNonNull(mapTwo, "mapTwo == null");
        Objects.requireNonNull(array, "array == null");
        Numbers.requireNonzero(mapOne.size(), "mapOne.size() == 0");
        Numbers.requireNonzero(mapTwo.size(), "mapTwo.size() == 0");
        Numbers.requireNonzero(array.length, "array.length == 0");
    }
}
