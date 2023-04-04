package com.example.translator.data;

public class ReportDto {
    private int countAllWords;
    private int countWordsSize0To10Eng;
    private int countWordsSize10To20Eng;
    private int countWordsSizeOver20Eng;
    private int countWordsSize0To10Pl;
    private int countWordsSize10To20Pl;
    private int countWordsSizeOver20Pl;
    private double averageSizeWordEng;
    private double averageSizeWordPl;
    private int countUntranslatedWords;

    public int getCountAllWords() {
        return countAllWords;
    }

    public void setCountAllWords(int countAllWords) {
        this.countAllWords = countAllWords;
    }

    public int getCountWordsSize0To10Eng() {
        return countWordsSize0To10Eng;
    }

    public void setCountWordsSize0To10Eng(int countWordsSize0To10Eng) {
        this.countWordsSize0To10Eng = countWordsSize0To10Eng;
    }

    public int getCountWordsSize10To20Eng() {
        return countWordsSize10To20Eng;
    }

    public void setCountWordsSize10To20Eng(int countWordsSize10To20Eng) {
        this.countWordsSize10To20Eng = countWordsSize10To20Eng;
    }

    public int getCountWordsSizeOver20Eng() {
        return countWordsSizeOver20Eng;
    }

    public void setCountWordsSizeOver20Eng(int countWordsSizeOver20Eng) {
        this.countWordsSizeOver20Eng = countWordsSizeOver20Eng;
    }

    public int getCountWordsSize0To10Pl() {
        return countWordsSize0To10Pl;
    }

    public void setCountWordsSize0To10Pl(int countWordsSize0To10Pl) {
        this.countWordsSize0To10Pl = countWordsSize0To10Pl;
    }

    public int getCountWordsSize10To20Pl() {
        return countWordsSize10To20Pl;
    }

    public void setCountWordsSize10To20Pl(int countWordsSize10To20Pl) {
        this.countWordsSize10To20Pl = countWordsSize10To20Pl;
    }

    public int getCountWordsSizeOver20Pl() {
        return countWordsSizeOver20Pl;
    }

    public void setCountWordsSizeOver20Pl(int countWordsSizeOver20Pl) {
        this.countWordsSizeOver20Pl = countWordsSizeOver20Pl;
    }

    public double getAverageSizeWordEng() {
        return averageSizeWordEng;
    }

    public void setAverageSizeWordEng(double averageSizeWordEng) {
        this.averageSizeWordEng = averageSizeWordEng;
    }

    public double getAverageSizeWordPl() {
        return averageSizeWordPl;
    }

    public void setAverageSizeWordPl(double averageSizeWordPl) {
        this.averageSizeWordPl = averageSizeWordPl;
    }

    public int getCountUntranslatedWords() {
        return countUntranslatedWords;
    }

    public void setCountUntranslatedWords(int countUntranslatedWords) {
        this.countUntranslatedWords = countUntranslatedWords;
    }

    public ReportDto(int countAllWords, int countWordsSize0To10Eng, int countWordsSize10To20Eng, int countWordsSizeOver20Eng, int countWordsSize0To10Pl, int countWordsSize10To20Pl, int countWordsSizeOver20Pl, double averageSizeWordEng, double averageSizeWordPl, int countUntranslatedWords) {
        this.countAllWords = countAllWords;
        this.countWordsSize0To10Eng = countWordsSize0To10Eng;
        this.countWordsSize10To20Eng = countWordsSize10To20Eng;
        this.countWordsSizeOver20Eng = countWordsSizeOver20Eng;
        this.countWordsSize0To10Pl = countWordsSize0To10Pl;
        this.countWordsSize10To20Pl = countWordsSize10To20Pl;
        this.countWordsSizeOver20Pl = countWordsSizeOver20Pl;
        this.averageSizeWordEng = averageSizeWordEng;
        this.averageSizeWordPl = averageSizeWordPl;
        this.countUntranslatedWords = countUntranslatedWords;
    }
}
