package edu.otus.spring01.presenter;

import edu.otus.spring01.domain.QuestionBundle;
import edu.otus.spring01.domain.QuizBundle;
import edu.otus.spring01.domain.QuizResult;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class ConsoleQuizPresenter implements QuizPresenter {
    @Override
    public QuizResult present(QuizBundle quiz) throws IOException {
        System.out.println("New quiz!!!");
        int total = 0, correct = 0;
        for (int i = 0; i < quiz.getQuestions().size(); i++) {
            QuestionBundle question = quiz.getQuestions().get(i);
            printQuestion(question);
            total++;
            correct += question.getValidOptIdx() == getAnswer(question) ? 1 : 0;
        }
        return new QuizResult(total, correct);
    }

    private int getAnswer(QuestionBundle question) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("Your answer:");
            try {
                int idx = Integer.parseInt(in.readLine());
                if (idx >= 0 & idx < question.getOptions().size())
                    return idx;
            } catch (NumberFormatException e) {
            }
            System.out.println("Incorrect, retry.");
        }
    }

    private void printQuestion(QuestionBundle question) {
        System.out.println(question.getQuestion());
        System.out.println("Options:");
        IntStream.range(0, question.getOptions().size()).forEach( i -> System.out.printf("%d) %s\n", i, question.getOptions().get(i)));
    }
}
