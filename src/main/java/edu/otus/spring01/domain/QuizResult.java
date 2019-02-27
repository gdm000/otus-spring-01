package edu.otus.spring01.domain;

public class QuizResult {
    private String name;
    private String secName;
    private int questionsTotal;
    private int questionsCorrect;

    public void setName(String name) {
        this.name = name;
    }

    public void setSecName(String secName) {
        this.secName = secName;
    }

    public void setQuestionsTotal(int questionsTotal) {
        this.questionsTotal = questionsTotal;
    }

    public void setQuestionsCorrect(int questionsCorrect) {
        this.questionsCorrect = questionsCorrect;
    }

    public String getName() {
        return name;
    }

    public String getSecName() {
        return secName;
    }

    public int getQuestionsTotal() {
        return questionsTotal;
    }

    public int getQuestionsCorrect() {
        return questionsCorrect;
    }


}
