package com.example.translator.data;

public class ReportDto {
    private Integer countAllWords;
    private Integer countWordsSize0To10Eng;
    private Integer countWordsSize10To20Eng;
    private Integer countWordsSizeOver20Eng;
    private Integer countWordsSize0To10Pl;
    private Integer countWordsSize10To20Pl;
    private Integer countWordsSizeOver20Pl;
    private Double averageSizeWordEng;
    private Double averageSizeWordPl;
    private Integer countUntranslatedWords;

    public Integer getCountAllWords() {
        return countAllWords;
    }

    public void setCountAllWords(Integer countAllWords) {
        this.countAllWords = countAllWords;
    }

    public Integer getCountWordsSize0To10Eng() {
        return countWordsSize0To10Eng;
    }

    public void setCountWordsSize0To10Eng(Integer countWordsSize0To10Eng) {
        this.countWordsSize0To10Eng = countWordsSize0To10Eng;
    }

    public Integer getCountWordsSize10To20Eng() {
        return countWordsSize10To20Eng;
    }

    public void setCountWordsSize10To20Eng(int countWordsSize10To20Eng) {
        this.countWordsSize10To20Eng = countWordsSize10To20Eng;
    }

    public Integer getCountWordsSizeOver20Eng() {
        return countWordsSizeOver20Eng;
    }

    public void setCountWordsSizeOver20Eng(Integer countWordsSizeOver20Eng) {
        this.countWordsSizeOver20Eng = countWordsSizeOver20Eng;
    }

    public Integer getCountWordsSize0To10Pl() {
        return countWordsSize0To10Pl;
    }

    public void setCountWordsSize0To10Pl(Integer countWordsSize0To10Pl) {
        this.countWordsSize0To10Pl = countWordsSize0To10Pl;
    }

    public Integer getCountWordsSize10To20Pl() {
        return countWordsSize10To20Pl;
    }

    public void setCountWordsSize10To20Pl(Integer countWordsSize10To20Pl) {
        this.countWordsSize10To20Pl = countWordsSize10To20Pl;
    }

    public Integer getCountWordsSizeOver20Pl() {
        return countWordsSizeOver20Pl;
    }

    public void setCountWordsSizeOver20Pl(Integer countWordsSizeOver20Pl) {
        this.countWordsSizeOver20Pl = countWordsSizeOver20Pl;
    }

    public Double getAverageSizeWordEng() {
        return averageSizeWordEng;
    }

    public void setAverageSizeWordEng(Double averageSizeWordEng) {
        this.averageSizeWordEng = averageSizeWordEng;
    }

    public Double getAverageSizeWordPl() {
        return averageSizeWordPl;
    }

    public void setAverageSizeWordPl(double averageSizeWordPl) {
        this.averageSizeWordPl = averageSizeWordPl;
    }

    public Integer getCountUntranslatedWords() {
        return countUntranslatedWords;
    }

    public void setCountUntranslatedWords(int countUntranslatedWords) {
        this.countUntranslatedWords = countUntranslatedWords;
    }

    public ReportDto(Integer countAllWords, Integer countWordsSize0To10Eng, Integer countWordsSize10To20Eng, Integer countWordsSizeOver20Eng, Integer countWordsSize0To10Pl, Integer countWordsSize10To20Pl, Integer countWordsSizeOver20Pl, Double averageSizeWordEng, Double averageSizeWordPl, Integer countUntranslatedWords) {
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
