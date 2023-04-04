package com.example.translator.actions;

import com.example.translator.data.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.MediaTray;
import java.io.IOException;

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
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        contentStream.setFont(PDType1Font.COURIER, 12);
        contentStream.beginText();
        contentStream.showText("Hello World");
        contentStream.endText();
        contentStream.close();

//        document.save("pdfBoxHelloWorld.pdf");
        document.close();
        return document.t;
//        return translateService.getReport();
    }
}
