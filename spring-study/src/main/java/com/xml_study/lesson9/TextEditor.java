package com.xml_study.lesson9;

public class TextEditor {

    private SpellChecker spellChecker;

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    public void setSpellChecker(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

    public void spellChecker() {
        spellChecker.spellCheck();
    }
}
