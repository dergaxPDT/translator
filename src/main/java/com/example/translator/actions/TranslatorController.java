package com.example.translator.actions;

import com.example.translator.data.TranslateDictionary;
import com.example.translator.data.TranslateDictionaryDto;
import com.example.translator.data.WordToTranslateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/translator")
public class TranslatorController {

    @Autowired
    private TranslateService translateService;

    @GetMapping
    String getTranslation(@RequestBody WordToTranslateDto wordToTranslateDto){
        return translateService.getTranslation(wordToTranslateDto);
    }

    @PostMapping
    TranslateDictionary createTranslate(@RequestBody TranslateDictionaryDto newTranslation){
        return translateService.createTranslation(newTranslation);
    }

    @GetMapping("/list")
    Page<TranslateDictionary> listTranslations(@RequestParam int pageNumber, @RequestParam int pageSize){
        return translateService.getTranslations(pageNumber, pageSize);
    }

//    @GetMapping("/sentence")
//    String translateSentence(@RequestBody SentenceDto sentenceDto){
//        return translateService.translateSentence(sentenceDto);
//    }
}
