package com.bbz.util;

import java.util.Iterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public interface Streams {

    static <T> Stream<T> of(T value) {
        return value instanceof Iterable ? of((Iterable)value) : Stream.of(value);
    }

    @SafeVarargs
    static <T> Stream<T> of(T... values) {
        return values == null ? Stream.empty() : Stream.of(values);
    }

    static <T> Stream<T> of(Iterable<T> iterable) {
        return of(iterable, false);
    }

    static <T> Stream<T> of(Iterable<T> iterable, boolean parallel) {
        return iterable == null ? Stream.empty() : StreamSupport.stream(iterable.spliterator(), parallel);
    }

    static <T> Stream<T> of(Iterator<T> iterator, long total, int characteristics, boolean parallel) {
        return StreamSupport.stream(Spliterators.spliterator(iterator, total, characteristics), parallel);
    }

    static <T> Stream<T> of(Iterator<T> iterator, int characteristics, boolean parallel) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, characteristics), parallel);
    }
}
