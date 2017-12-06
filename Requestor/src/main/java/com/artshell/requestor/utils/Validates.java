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
