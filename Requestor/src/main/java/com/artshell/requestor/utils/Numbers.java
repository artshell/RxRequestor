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
 * Created by artshell on 2017/11/2.
 */

public class Numbers {

    private Numbers() {
        throw new AssertionError("No com.artshell.utils.common.Numbers instances for you!");
    }

    /* ======  check for long  ====== */
    public static boolean requireNonNegative(long number) {
        if (number < 0) {
            throw new IllegalStateException();
        }
        return true;
    }

    public static boolean requireNonNegative(long number, String tip) {
        if (number < 0) {
            throw new IllegalStateException(tip);
        }
        return true;
    }

    public static boolean requireNonNegative(long number, Provider<String> tipProvider) {
        if (number < 0) {
            throw new IllegalStateException(tipProvider.get());
        }
        return true;
    }

    /* ======  check for double  ====== */
    public static boolean requireNonNegative(double number) {
        if (number < 0) {
            throw new IllegalStateException();
        }
        return true;
    }

    public static boolean requireNonNegative(double number, String tip) {
        if (number < 0) {
            throw new IllegalStateException(tip);
        }
        return true;
    }

    public static boolean requireNonNegative(double number, Provider<String> tipProvider) {
        if (number < 0) {
            throw new IllegalStateException(tipProvider.get());
        }
        return true;
    }

    /* ======  check for float  ====== */
    public static boolean requireNonNegative(float number) {
        if (number < 0) {
            throw new IllegalStateException();
        }
        return true;
    }

    public static boolean requireNonNegative(float number, String tip) {
        if (number < 0) {
            throw new IllegalStateException(tip);
        }
        return true;
    }

    public static boolean requireNonNegative(float number, Provider<String> tipProvider) {
        if (number < 0) {
            throw new IllegalStateException(tipProvider.get());
        }
        return true;
    }

    /* ======  check for int  ====== */
    public static boolean requireNonNegative(int number) {
        if (number < 0) {
            throw new IllegalStateException();
        }
        return true;
    }

    public static boolean requireNonNegative(int number, String tip) {
        if (number < 0) {
            throw new IllegalStateException(tip);
        }
        return true;
    }

    public static boolean requireNonNegative(int number, Provider<String> tipProvider) {
        if (number < 0) {
            throw new IllegalStateException(tipProvider.get());
        }
        return true;
    }

    public static boolean requireNonzero(int number) {
        if (number == 0) {
            throw new IllegalStateException();
        }
        return true;
    }

    public static boolean requireNonzero(int number, String tip) {
        if (number == 0) {
            throw new IllegalStateException(tip);
        }
        return true;
    }

    public static boolean requireNonzero(int number, Provider<String> tipProvider) {
        if (number == 0) {
            throw new IllegalStateException(tipProvider.get());
        }
        return true;
    }

    /* ======  check for short  ====== */
    public static boolean requireNonNegative(short number) {
        if (number < 0) {
            throw new IllegalStateException();
        }
        return true;
    }

    public static boolean requireNonNegative(short number, String tip) {
        if (number < 0) {
            throw new IllegalStateException(tip);
        }
        return true;
    }

    public static boolean requireNonNegative(short number, Provider<String> tipProvider) {
        if (number < 0) {
            throw new IllegalStateException(tipProvider.get());
        }
        return true;
    }
}
