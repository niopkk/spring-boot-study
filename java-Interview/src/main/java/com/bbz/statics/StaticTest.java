package com.bbz.statics;

import com.bbz.util.Dates;

public class StaticTest {


    private static Long data = Dates.unixNow();


    public Long getData() {
        return data;
    }
}
