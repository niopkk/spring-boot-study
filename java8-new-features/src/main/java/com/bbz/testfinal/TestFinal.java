package com.bbz.testfinal;

import java.util.HashMap;
import java.util.Map;

public class TestFinal {

    private String name;

    private Map map = new HashMap();

    public TestFinal() {
        name = "li";
    }

    public void put(Object key, Object value) {
        map.put(key, value);
    }

    public Object get(Object key) {
        return map.get(key);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
