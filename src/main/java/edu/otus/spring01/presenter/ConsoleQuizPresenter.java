package edu.otus.spring01.presenter;

import edu.otus.spring01.domain.QuestionBundle;
import edu.otus.spring01.domain.QuizResult;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class ConsoleQuizPresenter implements QuizPresenter {
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public QuizResult initQuiz(QuizResult result) throws Exception {
        System.out.println("New quiz!!!");
        System.out.print("Enter name:");
        result.setName(in.readLine());
        System.out.print("Enter sec name:");
        result.setSecName(in.readLine());
        return result;
    }

    @Override
    public void presentInputErr() throws Exception {
        System.out.println("Incorrect input.");
    }

    @Override
    public void present(QuestionBundle question) throws Exception {
        System.out.println(question.getQuestion());
        System.out.println("Options:");
        IntStream.range(0, question.getOptions().size()).forEach(i -> System.out.printf("%d) %s\n", i, question.getOptions().get(i)));
    }

    @Override
    public int getAnswer() throws Exception {
        while (true) {
            System.out.print("Your answer:");
            try {
                return Integer.parseInt(in.readLine());
            } catch (NumberFormatException e) {
                presentInputErr();
            }
        }
    }
}
