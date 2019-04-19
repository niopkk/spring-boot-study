package com.bbz.infacestest;

import java.util.function.Function;

public interface TestB {


    <R> R extract(Function<String, R> function);
    
}
