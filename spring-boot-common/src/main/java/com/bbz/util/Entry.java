package com.bbz.util;

import java.io.Serializable;

public class Entry<K, V> implements Serializable {
    private K key;
    private V value;

    public static <K, V> Entry<K, V> of(K key, V value) {
        return new Entry(key, value);
    }

    public Entry() {
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public String toString() {
        return this.key + "=" + this.value;
    }
}
