package com.example.translator.data;

import com.example.translator.data.TypeWord;

public class SentenceDto {
    private String sentence;
    private TypeWord typeTranslation;

    public SentenceDto(String sentence, TypeWord typeTranslation) {
        this.sentence = sentence;
        this.typeTranslation = typeTranslation;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public TypeWord getTypeTranslation() {
        return typeTranslation;
    }

    public void setTypeTranslation(TypeWord typeTranslation) {
        this.typeTranslation = typeTranslation;
    }
}
