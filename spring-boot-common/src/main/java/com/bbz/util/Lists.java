package com.bbz.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Lists {


    static <T> List<T> of(T... value) {
        return value != null ? Stream.of(value).collect(Collectors.toList()) : Collections.EMPTY_LIST;
    }

    static <T> List<T> of(Iterable<T> iterable) {
        return (List) Stream.of(iterable).collect(Collectors.toList());
    }
}
