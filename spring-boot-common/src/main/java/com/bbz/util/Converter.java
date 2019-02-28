package com.bbz.util;

@FunctionalInterface
public interface Converter<I, O> {
    O convert(I source);
}
