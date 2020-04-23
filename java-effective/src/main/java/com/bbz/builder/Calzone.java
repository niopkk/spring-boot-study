package com.bbz.builder;

public class Calzone extends Pizza {

    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder> {

        private boolean sauceInside = false;

        public Builder sauceInside() {
            this.sauceInside = true;
            return this;
        }

        @Override
        public Calzone builder() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }


    public Calzone(Builder builder) {
        super(builder);
        this.sauceInside = builder.sauceInside;
    }

}
