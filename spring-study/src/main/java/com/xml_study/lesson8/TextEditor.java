package com.xml_study.lesson8;

public class TextEditor {


    private SpellChecker spellChecker;

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    public void setSpellChecker(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

    public void setSpellCheck(){
        spellChecker.checkSpelling();
    }

}
