package com.example.translator;

import com.example.translator.actions.PdfService;
import com.example.translator.actions.TranslateRepositoryEntity;
import com.example.translator.actions.TranslateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpinConfig {

    @Bean
    TranslateService translateService() {
        return new TranslateService();
    }

    @Bean
    PdfService pdfService() {
        return new PdfService();
    }
}
