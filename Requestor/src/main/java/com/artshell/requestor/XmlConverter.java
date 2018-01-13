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

import com.artshell.requestor.utils.Objects;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.IOException;

import okhttp3.ResponseBody;

/**
 * @author artshell on 11/01/2018
 */

public final class XmlConverter implements Converter {

    private final Serializer serializer;
    private final boolean strict;

    private XmlConverter(Serializer serializer, boolean strict) {
        this.serializer = serializer;
        this.strict = strict;
    }

    public static XmlConverter create() {
        return create(new Persister());
    }

    public static XmlConverter create(Serializer serializer) {
        Objects.requireNonNull(serializer, "serializer == null");
        return new XmlConverter(serializer, true);
    }

    public static XmlConverter createNonStrict() {
        return createNonStrict(new Persister());
    }

    public static XmlConverter createNonStrict(Serializer serializer) {
        Objects.requireNonNull(serializer, "serializer == null");
        return new XmlConverter(serializer, false);
    }

    @Override
    public <T> T apply(Class<T> target, ResponseBody body) throws IOException {
        try {
            T result = serializer.read(target, body.charStream(), strict);
            if (result == null) {
                throw new IllegalStateException("Could not deserialize body as " + target);
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            body.close();
        }
    }
}
