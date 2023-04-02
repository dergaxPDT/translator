package com.example.translator;

import org.springframework.beans.factory.annotation.Autowired;
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
}
