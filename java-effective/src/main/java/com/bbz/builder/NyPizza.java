package com.bbz.builder;

public class NyPizza extends Pizza {

    //小号、中号、大号
    public enum Size {SMALL, MEDIUM, LARGE}

    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private Size size;

        public Builder(Size size) {
            this.size = size;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public NyPizza builder() {
            return new NyPizza(this);
        }
    }

    public NyPizza(Builder builder) {
        super(builder);
        this.size = builder.size;
    }
}
