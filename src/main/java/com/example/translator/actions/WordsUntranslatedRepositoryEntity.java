package com.example.translator.actions;

import com.example.translator.data.UntranslatedDictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordsUntranslatedRepositoryEntity extends JpaRepository<UntranslatedDictionary, Long> {
}
