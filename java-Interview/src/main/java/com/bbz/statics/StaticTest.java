package com.bbz.statics;

import com.bbz.util.Dates;

public class StaticTest {


    private static volatile Long data = Dates.unixNow();


    public Long getData() {
        return data;
    }

    public void setData(Long value) {
        data = value;
    }
}
