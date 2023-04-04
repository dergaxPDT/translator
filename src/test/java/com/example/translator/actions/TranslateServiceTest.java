package com.example.translator.actions;

import com.example.translator.data.SentenceDto;
import com.example.translator.data.TranslateDictionary;
import com.example.translator.data.TypeWord;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
class TranslateServiceTest {

    @Autowired
    private TranslateService translateService;

    @Autowired
    private TranslateRepositoryEntity repository;

    private final List<String> listPolishWords = List.of("ja", "chce", "powiedzieć", "witaj", "świecie");
    private final List<String> listEnglishWords = List.of("i", "want", "say", "hello", "world");


    @BeforeEach
    public void init() {
        for (int i = 0; i < listPolishWords.size(); i++) {
            repository.save(new TranslateDictionary(UUID.randomUUID().toString(), listPolishWords.get(i), listEnglishWords.get(i)));
        }
    }

    @Test
    void translateSentenceToPolish() {
        String translations = translateService.translateSentence(new SentenceDto("i want say hello world", TypeWord.ENGLISH));
        Assertions.assertEquals("ja chce powiedzieć witaj świecie", translations);
    }

    @Test
    void translateSentenceToEnglish() {
        String translations = translateService.translateSentence(new SentenceDto("ja chce powiedzieć witaj świecie", TypeWord.POLISH));
        Assertions.assertEquals("i want say hello world", translations);
    }

    @AfterEach
    void clear(){
        repository.deleteAll();
    }
}