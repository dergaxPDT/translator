package com.example.translator.actions;

import be.quodlibet.boxable.*;
import com.example.translator.data.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("/api/translator")
public class TranslatorController {

    @Autowired
    private TranslateService translateService;

    @GetMapping
    String getTranslation(@RequestParam String word){
        return translateService.getTranslation(word);
    }

    @PostMapping
    TranslateDictionary createTranslate(@RequestBody TranslateDictionaryDto newTranslation){
        return translateService.createTranslation(newTranslation);
    }

    @GetMapping("/list")
    Page<TranslateDictionary> listTranslations(@RequestParam int pageNumber, @RequestParam int pageSize){
        return translateService.getTranslations(pageNumber, pageSize);
    }

    @GetMapping("/sentence")
    String translateSentence(@RequestBody SentenceDto sentenceDto){
        return translateService.translateSentence(sentenceDto);
    }

    @GetMapping("/report")
    ReportDto getReport(){
        return translateService.getReport();
    }

    @PostMapping( value = "/report/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    byte[] getReportPdf() throws IOException {

        String pathname = "target/tmp.pdf";

        ReportDto reportDto = translateService.getReport();
        PdfService.createPdf(pathname, reportDto);

        try {
            FileInputStream fis= new FileInputStream(new File(pathname));
            byte[] targetArray = new byte[fis.available()];
            fis.read(targetArray);
            return targetArray;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
