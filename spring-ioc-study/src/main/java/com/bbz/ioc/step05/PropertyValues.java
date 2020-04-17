package com.bbz.ioc.step05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PropertyValues {

    private List<PropertyValue> propertyValues = new ArrayList<>();

    public PropertyValues() {
    }

    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }

    public void addPropertyValues(PropertyValue... pv) {
        Arrays.stream(pv).forEach(propertyValue -> {
            propertyValues.add(propertyValue);
        });
    }
}
