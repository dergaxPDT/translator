package com.example.translator.data;

import com.example.translator.data.TypeWord;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table
public class UntranslatedDictionary {
    @Id
    private String id;
    private String word;
    private TypeWord typeWord;


    public UntranslatedDictionary(String word, TypeWord typeWord) {
        this.word = word;
        this.typeWord = typeWord;
    }

    public UntranslatedDictionary(String id, String word, TypeWord typeWord) {
        this.id = id;
        this.word = word;
        this.typeWord = typeWord;
    }

    public UntranslatedDictionary() {

    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public TypeWord getTypeWord() {
        return typeWord;
    }

    public void setTypeWord(TypeWord typeWord) {
        this.typeWord = typeWord;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
