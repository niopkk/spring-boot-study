package com.bbz.builder;

public class SpellCheckerMainTest {


    public static void main(String[] args) {

        SpellChecker spellCheckerCH = new SpellChecker(() -> new ChineseDictionary());
        spellCheckerCH.isValid("sdf");

        SpellChecker spellCheckerEN = new SpellChecker(() -> new EnglishDictionary());
        spellCheckerEN.isValid("sdf");
    }

    static class ChineseDictionary implements Dictionary {


        @Override
        public boolean findWord(String word) {
            return true;
        }
    }

    static class EnglishDictionary implements Dictionary {


        @Override
        public boolean findWord(String word) {
            return false;
        }
    }
}
