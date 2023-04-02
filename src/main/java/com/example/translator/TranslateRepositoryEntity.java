package com.example.translator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslateRepositoryEntity extends JpaRepository<TranslateDictionary, Long> {
    TranslateDictionary findByPolishWord(String polishWord);
    TranslateDictionary findByEnglishWord(String englishWord);
}
