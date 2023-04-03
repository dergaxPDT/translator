package com.example.translator.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.DataAmount;
import lombok.Data;

@Entity
@Data
@Table
public class TranslateDictionary {
    @Id
    private String id;
    private String polishWord;
    private String englishWord;

    public TranslateDictionary(String id, String polishWord, String englishWord) {
        this.id = id;
        this.polishWord = polishWord;
        this.englishWord = englishWord;
    }

    public TranslateDictionary() {

    }

    public String getPolishWord() {
        return polishWord;
    }

    public void setPolishWord(String polishWord) {
        this.polishWord = polishWord;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
