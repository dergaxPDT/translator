package com.example.translator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslateService {

    @Autowired
    private TranslateRepositoryEntity translateRepositoryEntity;

    public String getTranslation(WordToTranslateDto dto) {
        try {
            return wordToTranslateDto.getTypeWord().equals(TypeWord.ENGLISH) ?
                    translateRepositoryEntity.findByEnglishWord(dto.getWord()).getPolishWord() :
                    translateRepositoryEntity.findByPolishWord(dto.getWord()).getEnglishWord();
        } catch (NullPointerException e) {
            throw
        }
    }
}
