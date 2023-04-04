package com.example.translator.actions;

import com.example.translator.data.ReportDto;
import com.example.translator.data.TranslateDictionary;
import com.example.translator.data.TypeWord;
import com.example.translator.data.UntranslatedDictionary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GetReportTest {

    @Autowired
    private TranslateService translateService;

    @Autowired
    private TranslateRepositoryEntity translateRepositoryEntity;

    @Autowired
    private WordsUntranslatedRepositoryEntity untranslatedRepository;

    @Test
    void getReport() {
        //given
        translateRepositoryEntity.save(new TranslateDictionary("1", "1231245215", "2131231244524"));
        translateRepositoryEntity.save(new TranslateDictionary("2", "12312452152313223132", "2131231244524231321321123321"));
        translateRepositoryEntity.save(new TranslateDictionary("3", "1231", "2131231"));
        translateRepositoryEntity.save(new TranslateDictionary("4", "1231", "2131231"));
        untranslatedRepository.save(new UntranslatedDictionary("1", "1231", TypeWord.ENGLISH));
        untranslatedRepository.save(new UntranslatedDictionary("2", "1231", TypeWord.POLISH));
        //when
        ReportDto report= translateService.getReport();
        //then
        assertEquals(4, report.getCountAllWords());
        assertEquals(2, report.getCountUntranslatedWords());
        assertEquals(13.0, report.getAverageSizeWordEng());
        assertEquals(9.0, report.getAverageSizeWordPl());
        assertEquals(3, report.getCountWordsSize0To10Pl());
        assertEquals(1, report.getCountWordsSize10To20Pl());
        assertEquals(0, report.getCountWordsSizeOver20Pl());
        assertEquals(3, report.getCountWordsSize0To10Eng());
        assertEquals(1, report.getCountWordsSize10To20Eng());
        assertEquals(0, report.getCountWordsSizeOver20Eng());
    }
}