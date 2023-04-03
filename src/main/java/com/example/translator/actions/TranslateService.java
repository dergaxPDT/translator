package com.example.translator.actions;

import com.example.translator.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class TranslateService {

    @Autowired
    private TranslateRepositoryEntity translateRepositoryEntity;

//    @Autowired
//    private WordsUntranslatedRepositoryEntity wordsUntranslatedRepositoryEntity;

    public String getTranslation(WordToTranslateDto dto) {
        return dto.getTypeWord().equals(TypeWord.ENGLISH) ?
                translateRepositoryEntity.findByEnglishWord(dto.getWord()).getPolishWord() :
                translateRepositoryEntity.findByPolishWord(dto.getWord()).getEnglishWord();
    }

    public TranslateDictionary createTranslation(TranslateDictionaryDto newTranslation) {
        return translateRepositoryEntity.save(new TranslateDictionary(UUID.randomUUID().toString(), newTranslation.getPolishWord(), newTranslation.getEnglishWord()));
    }

    public Page<TranslateDictionary> getTranslations(int pageNumber, int pageSize) {
        return translateRepositoryEntity.findAll(PageRequest.of(pageNumber, pageSize));
    }

//    public String translateSentence(SentenceDto sentenceDto) {
//        String sentence = sentenceDto.getSentence();
//        String[] words = sentence.split(" ");
//        StringBuilder stringBuilder = new StringBuilder();
//        if (sentenceDto.getTypeTranslation().equals(TypeWord.ENGLISH)){
//            return translateToPolish(words, stringBuilder).toString();
//        } else {
//           return translateToEnglish(words, stringBuilder).toString();
//        }
//    }
//
//    private StringBuilder translateToEnglish(String[] words, StringBuilder stringBuilder) {
//        for (String word: words){
//            Optional<TranslateDictionary> wordTranslated = translateRepositoryEntity.findByPolishWord(word);
//            if (wordTranslated.isPresent()){
//                stringBuilder.append(wordTranslated.get().getEnglishWord());
//            } else {
//                stringBuilder.append(word);
//                wordsUntranslatedRepositoryEntity.save(new UntranslatedDictionary(word, TypeWord.POLISH));
//            }
//        }
//        return stringBuilder;
//    }
//
//    private StringBuilder translateToPolish(String[] words, StringBuilder stringBuilder) {
//        for (String word: words){
//            Optional<TranslateDictionary> wordTranslated = translateRepositoryEntity.findByEnglishWord(word);
//            if (wordTranslated.isPresent()){
//                stringBuilder.append(wordTranslated.get().getPolishWord());
//            } else {
//                stringBuilder.append(word);
//                wordsUntranslatedRepositoryEntity.save(new UntranslatedDictionary(word, TypeWord.ENGLISH));
//            }
//        }
//        return stringBuilder;
//    }
}
