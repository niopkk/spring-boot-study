package com.bbz.builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {

    //火腿、蘑菇、洋葱、辣椒、香肠
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

    final Set<Topping> toppings;

    public abstract static class Builder<T extends Builder> {

        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza builder();

        protected abstract T self();
    }

    public Pizza(Builder<?> builder) {
        this.toppings = builder.toppings.clone();
    }
}
