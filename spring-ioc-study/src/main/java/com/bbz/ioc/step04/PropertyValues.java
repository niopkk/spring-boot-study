package com.bbz.ioc.step04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PropertyValues {

    private final List<PropertyValue> propertyValues = new ArrayList<>();

    public PropertyValues() {
    }

    public void addProperValues(PropertyValue... pv) {
        Arrays.stream(pv).forEach(properValue -> {
            propertyValues.add(properValue);
        });
    }

    public List<PropertyValue> getProperValues() {
        return this.propertyValues;
    }
}
