package com.bbz.ioc.step03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PropertyValues {


    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public PropertyValues() {
    }

    public void addPropertyValue(PropertyValue... propertyValue) {
        //TODO:这里可以对于重复propertyName进行判断，直接用list没法做到
        Arrays.stream(propertyValue).forEach(p -> {
            this.propertyValueList.add(p);
        });

    }

    public List<PropertyValue> getPropertyValues() {
        return this.propertyValueList;
    }
}
