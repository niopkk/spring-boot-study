package com.bbz;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Favorites {


    private Map<Class<?>, Object> map = new HashMap<>();

    public <T> void putFavorites(Class<T> type, T instance) {
        map.put(Objects.requireNonNull(type), instance);
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(map.get(type));
    }


    public static void main(String[] args) {
        Favorites favorites = new Favorites();


        favorites.putFavorites(String.class, "java");
        favorites.putFavorites(Integer.class, 1);
        favorites.putFavorites(Class.class, Favorites.class);

        String favorite = favorites.getFavorite(String.class);
        Class<?> favoriteClass = favorites.getFavorite(Class.class);
        System.out.println(favorite);

        System.out.println(favoriteClass.getName());
    }
}
