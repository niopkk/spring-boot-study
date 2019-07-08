package com.bbz.builder;

public class MyPizaa extends Pizza {


    public enum Size {SMALL, MEDIUM, LARGE}

    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {

        private final Size size;

        public Builder(Size size) {
            this.size = size;
        }

        @Override
        MyPizaa build() {
            return new MyPizaa(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    MyPizaa(Builder builder) {
        super(builder);
        size = builder.size;
    }

    @Override
    public String toString() {
        return "MyPizaa{" +
                "size=" + size +
                ", toppings=" + toppings +
                '}';
    }
}
