package com.bbz.builder;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class SpellChecker {

    private final Dictionary dictionary;

    //    public SpellChecker(Dictionary dictionary) {
//        this.dictionary = Objects.requireNonNull(dictionary);
//    }

    /**
     *
     * @param factory
     */
    public SpellChecker(Supplier<? extends Dictionary> factory) {
        this.dictionary = factory.get();
    }


    public boolean isValid(String word) {
        System.out.println(String.format("输入的值%s", word));
        boolean dictionaryWord = dictionary.findWord(word);
        System.out.println(String.format("是否存在%s", dictionaryWord));
        return dictionaryWord;
    }

    public List<String> suggestions(String type) {
        return null;
    }
}
