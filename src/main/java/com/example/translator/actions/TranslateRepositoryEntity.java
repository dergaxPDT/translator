package com.example.translator.actions;

import com.example.translator.data.TranslateDictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TranslateRepositoryEntity extends JpaRepository<TranslateDictionary, Long> {
    Optional<TranslateDictionary> findByPolishWord(String polishWord);
    Optional<TranslateDictionary> findByEnglishWord(String englishWord);
}
