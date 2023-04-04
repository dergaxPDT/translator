package com.example.translator.actions;

import com.example.translator.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;


//@Service
public class TranslateService {

    @Autowired
    private TranslateRepositoryEntity translateRepositoryEntity;

    @Autowired
    private WordsUntranslatedRepositoryEntity wordsUntranslatedRepositoryEntity;

    public String getTranslation(WordToTranslateDto dto) {
        return dto.getTypeWord().equals(TypeWord.ENGLISH) ?
                translateRepositoryEntity.findByEnglishWord(dto.getWord()).get().getPolishWord() :
                translateRepositoryEntity.findByPolishWord(dto.getWord()).get().getEnglishWord();//TODO
    }

    public TranslateDictionary createTranslation(TranslateDictionaryDto newTranslation) {
        return translateRepositoryEntity.save(new TranslateDictionary(UUID.randomUUID().toString(), newTranslation.getPolishWord(), newTranslation.getEnglishWord()));
    }

    public Page<TranslateDictionary> getTranslations(int pageNumber, int pageSize) {
        return translateRepositoryEntity.findAll(PageRequest.of(pageNumber, pageSize));
    }

    public String translateSentence(SentenceDto sentenceDto) {
        String sentence = sentenceDto.getSentence();
        String[] words = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        if (sentenceDto.getTypeTranslation().equals(TypeWord.ENGLISH)) {
            return translateToPolish(words, stringBuilder).toString();
        } else {
            return translateToEnglish(words, stringBuilder).toString();
        }
    }

    private StringBuilder translateToEnglish(String[] words, StringBuilder stringBuilder) {
        int i = 0;
        for (String word : words) {
            if (i != 0) {
                stringBuilder.append(" ");
            }
            Optional<TranslateDictionary> wordTranslated = translateRepositoryEntity.findByPolishWord(word);
            if (wordTranslated.isPresent()) {
                stringBuilder.append(wordTranslated.get().getEnglishWord());
            } else {
                stringBuilder.append(word);
                wordsUntranslatedRepositoryEntity.save(new UntranslatedDictionary(word, TypeWord.POLISH));
            }
            i++;
        }
        return stringBuilder;
    }

    private StringBuilder translateToPolish(String[] words, StringBuilder stringBuilder) {
        int i = 0;
        for (String word : words) {
            if (i != 0) {
                stringBuilder.append(" ");
            }
            Optional<TranslateDictionary> wordTranslated = translateRepositoryEntity.findByEnglishWord(word);
            if (wordTranslated.isPresent()) {
                stringBuilder.append(wordTranslated.get().getPolishWord());
            } else {
                stringBuilder.append(word);
                wordsUntranslatedRepositoryEntity.save(new UntranslatedDictionary(UUID.randomUUID().toString(), word, TypeWord.ENGLISH));
            }
            i++;
        }
        return stringBuilder;
    }

    public ReportDto getReport() {
        List<TranslateDictionary> list = translateRepositoryEntity.findAll();
        int sizeAll = list.size();

        AtomicInteger toTenPl = new AtomicInteger();
        AtomicInteger toTwentyPl = new AtomicInteger();
        AtomicInteger overTwentyPl = new AtomicInteger();
        list.forEach(o -> {
            int length = o.getPolishWord().length();
            if (length <= 10) {
                toTenPl.set(toTenPl.get() + 1);
            } else if (length <= 20) {
                toTwentyPl.set(toTwentyPl.get() + 1);
            } else {
                overTwentyPl.set(overTwentyPl.get() + 1);
            }

        });

        AtomicInteger toTenEng = new AtomicInteger();
        AtomicInteger toTwentyEng = new AtomicInteger();
        AtomicInteger overTwentyEng = new AtomicInteger();
        list.forEach(o -> {
            int length = o.getPolishWord().length();
            if (length <= 10) {
                toTenEng.set(toTenEng.get() + 1);
            } else if (length <= 20) {
                toTwentyEng.set(toTwentyEng.get() + 1);
            } else {
                overTwentyEng.set(overTwentyEng.get() + 1);
            }

        });

        int contLengthPl = 0;
        int contLengthEng = 0;
        for (TranslateDictionary dictionary : list) {
            contLengthPl = contLengthPl + dictionary.getPolishWord().length();
            contLengthEng = contLengthEng + dictionary.getEnglishWord().length();
        }
        int sizeUntranslatedWords = wordsUntranslatedRepositoryEntity.findAll().size();
        return new ReportDto(sizeAll, toTenEng.get(), toTwentyEng.get(), overTwentyEng.get(), toTenPl.get(), toTwentyPl.get(), overTwentyPl.get(), contLengthEng / sizeAll, contLengthPl / sizeAll, sizeUntranslatedWords);
    }
}
