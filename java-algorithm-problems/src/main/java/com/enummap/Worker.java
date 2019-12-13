package com.enummap;

import java.util.Set;

/**
 * com.enummap
 * <p>
 * Created by tianxin2 on 2019/12/13
 */
public class Worker {

    private String name;

    private Set<Day> availableDays;

    public Worker(String name, Set<Day> availableDays) {
        this.name = name;
        this.availableDays = availableDays;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Day> getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(Set<Day> availableDays) {
        this.availableDays = availableDays;
    }
}
