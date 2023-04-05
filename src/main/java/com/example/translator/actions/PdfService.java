package com.example.translator.actions;

import be.quodlibet.boxable.*;
import com.example.translator.data.ReportDto;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;

public class PdfService {
    public static void createPdf(String pathname, ReportDto reportDto) throws IOException {
        // Set margins
        float margin = 10;

        // Initialize Document
        PDDocument doc = new PDDocument();
        PDPage page = addNewPage(doc);

        // Initialize table
        float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
        float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
        boolean drawContent = true;
        boolean drawLines = true;
        float yStart = yStartNewPage;
        float bottomMargin = 70;
        BaseTable table = new BaseTable(yStart, yStartNewPage, bottomMargin, tableWidth, margin, doc, page, drawLines,
                drawContent);

        // Create Header row
        Row<PDPage> row = table.createRow(5f);
        Cell<PDPage> cell = row.createCell((100 /   10f), "liczba tlumaczen", HorizontalAlignment.CENTER,
                VerticalAlignment.MIDDLE);
        cell.setTextRotated(false);
        cell.setFont(PDType1Font.HELVETICA);
        cell.setFontSize(6);

        Cell<PDPage> cell2 = row.createCell((100 / 10f), "liczba slow angielskich do 10 znakow", HorizontalAlignment.get("center"),
                VerticalAlignment.get("middle"));
        cell2.setTextRotated(false);
        cell2.setFont(PDType1Font.HELVETICA);
        cell2.setFontSize(6);

        Cell<PDPage> cell3 = row.createCell((100 / 10f), "liczba slow angielskich miedzy 10 a 20 znakow", HorizontalAlignment.get("center"),
                VerticalAlignment.get("middle"));
        cell3.setTextRotated(false);
        cell3.setFont(PDType1Font.HELVETICA);
        cell3.setFontSize(6);

        Cell<PDPage> cell4 = row.createCell((100 / 10f), "liczba slow angielskich ponad 20 znakow", HorizontalAlignment.get("center"),
                VerticalAlignment.get("middle"));
        cell4.setTextRotated(false);
        cell4.setFont(PDType1Font.HELVETICA);
        cell4.setFontSize(6);

        Cell<PDPage> cell5= row.createCell((100 / 10f), "liczba slow polskich do 10 znakow", HorizontalAlignment.get("center"),
                VerticalAlignment.get("middle"));
        cell5.setTextRotated(false);
        cell5.setFont(PDType1Font.HELVETICA);
        cell5.setFontSize(6);

        Cell<PDPage> cell6 = row.createCell((100 / 10f), "liczba slow polskich miedzy 10 a 20 znakow", HorizontalAlignment.get("center"),
                VerticalAlignment.get("middle"));
        cell6.setTextRotated(false);
        cell6.setFont(PDType1Font.HELVETICA);
        cell6.setFontSize(6);

        Cell<PDPage> cell7 = row.createCell((100 / 10f), "liczba slow polskich ponad 20 znakow", HorizontalAlignment.get("center"),
                VerticalAlignment.get("middle"));
        cell7.setTextRotated(false);
        cell7.setFont(PDType1Font.HELVETICA);
        cell7.setFontSize(6);

        Cell<PDPage> cell8= row.createCell((100 / 10f), "srednia dlugosc slow polskich", HorizontalAlignment.get("center"),
                VerticalAlignment.get("middle"));
        cell8.setTextRotated(false);
        cell8.setFont(PDType1Font.HELVETICA);
        cell8.setFontSize(6);

        Cell<PDPage> cell9 = row.createCell((100 / 10f), "srednia dlugosc slow angielskich", HorizontalAlignment.get("center"),
                VerticalAlignment.get("middle"));
        cell9.setTextRotated(false);
        cell9.setFont(PDType1Font.HELVETICA);
        cell9.setFontSize(6);

        Cell<PDPage> cell10 = row.createCell((100 / 10f), "liczba slow nie przetlumaczonych", HorizontalAlignment.get("center"),
                VerticalAlignment.get("middle"));
        cell10.setTextRotated(false);
        cell10.setFont(PDType1Font.HELVETICA);
        cell10.setFontSize(6);

        Row<PDPage> row2 = table.createRow(15f);

        Cell<PDPage> cell11 = row2.createCell((100 /   10f), reportDto.getCountAllWords().toString(), HorizontalAlignment.CENTER,
                VerticalAlignment.MIDDLE);
        cell11.setTextRotated(false);
        cell11.setFont(PDType1Font.HELVETICA);
        cell11.setFontSize(6);

        Cell<PDPage> cell12 = row2.createCell((100 / 10f), reportDto.getCountWordsSize0To10Eng().toString(), HorizontalAlignment.get("center"),
                VerticalAlignment.get("middle"));
        cell12.setTextRotated(false);
        cell12.setFont(PDType1Font.HELVETICA);
        cell12.setFontSize(6);

        Cell<PDPage> cell13 = row2.createCell((100 / 10f), reportDto.getCountWordsSize10To20Eng().toString(), HorizontalAlignment.get("center"),
                VerticalAlignment.get("middle"));
        cell13.setTextRotated(false);
        cell13.setFont(PDType1Font.HELVETICA);
        cell13.setFontSize(6);

        Cell<PDPage> cell14 = row2.createCell((100 / 10f), reportDto.getCountWordsSizeOver20Eng().toString(), HorizontalAlignment.get("center"),
                VerticalAlignment.get("middle"));
        cell14.setTextRotated(false);
        cell14.setFont(PDType1Font.HELVETICA);
        cell14.setFontSize(6);

        Cell<PDPage> cell15= row2.createCell((100 / 10f), reportDto.getCountWordsSize0To10Pl().toString(), HorizontalAlignment.get("center"),
                VerticalAlignment.get("middle"));
        cell15.setTextRotated(false);
        cell15.setFont(PDType1Font.HELVETICA);
        cell15.setFontSize(6);

        Cell<PDPage> cell16 = row2.createCell((100 / 10f), reportDto.getCountWordsSize10To20Pl().toString(), HorizontalAlignment.get("center"),
                VerticalAlignment.get("middle"));
        cell16.setTextRotated(false);
        cell16.setFont(PDType1Font.HELVETICA);
        cell16.setFontSize(6);

        Cell<PDPage> cell17 = row2.createCell((100 / 10f), reportDto.getCountWordsSizeOver20Pl().toString(), HorizontalAlignment.get("center"),
                VerticalAlignment.get("middle"));
        cell17.setTextRotated(false);
        cell17.setFont(PDType1Font.HELVETICA);
        cell17.setFontSize(6);

        Cell<PDPage> cell18= row2.createCell((100 / 10f), reportDto.getAverageSizeWordPl().toString(), HorizontalAlignment.get("center"),
                VerticalAlignment.get("middle"));
        cell18.setTextRotated(false);
        cell18.setFont(PDType1Font.HELVETICA);
        cell18.setFontSize(6);

        Cell<PDPage> cell19 = row2.createCell((100 / 10f), reportDto.getAverageSizeWordEng().toString(), HorizontalAlignment.get("center"),
                VerticalAlignment.get("middle"));
        cell19.setTextRotated(false);
        cell19.setFont(PDType1Font.HELVETICA);
        cell19.setFontSize(6);

        Cell<PDPage> cell20 = row2.createCell((100 / 10f), reportDto.getCountUntranslatedWords().toString(), HorizontalAlignment.get("center"),
                VerticalAlignment.get("middle"));
        cell20.setTextRotated(false);
        cell20.setFont(PDType1Font.HELVETICA);
        cell20.setFontSize(6);
        table.draw();

        // Save the document
        File file = new File(pathname);
        System.out.println("Sample file saved at : " + file.getAbsolutePath());
        file.getParentFile().mkdirs();
        doc.save(file);
        doc.close();
    }

    private static PDPage addNewPage(PDDocument doc) {
        PDPage page = new PDPage();
        doc.addPage(page);
        return page;
    }
}
