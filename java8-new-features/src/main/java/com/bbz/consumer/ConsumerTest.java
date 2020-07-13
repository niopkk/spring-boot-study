package com.bbz.consumer;

import com.bbz.util.Jsons;

import java.util.Objects;
import java.util.function.Consumer;

public class ConsumerTest {


    static <T> T of(T value, Consumer<T> callbacks) {
        if (Objects.nonNull((value))) {
            callbacks.accept(value);
            return value;
        }
        return null;
    }

    public static void main(String[] args) {
        Test t1 = new Test();

        Test t3=  of(t1,
                test -> test.setId("1"));
        System.out.println(Jsons.toJson(t3));
        Test t4 = of(t1,test -> test.setName("1"));

        System.out.println(Jsons.toJson(t4));
    }

    static class Test {
        private String id;

        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
