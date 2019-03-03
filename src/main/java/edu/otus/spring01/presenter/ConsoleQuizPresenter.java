package edu.otus.spring01.presenter;

import edu.otus.spring01.domain.QuestionBundle;
import edu.otus.spring01.domain.QuizResult;
import org.springframework.context.MessageSource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.stream.IntStream;

public class ConsoleQuizPresenter implements QuizPresenter {
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private final MessageSource messageSource;
    private final Locale locale;

    public ConsoleQuizPresenter(MessageSource messageSource, Locale locale) {
        this.messageSource = messageSource;
        this.locale = locale;
    }

    @Override
    public QuizResult initQuiz(QuizResult result) throws Exception {
        System.out.println(messageSource.getMessage("present.welcome", null, locale));
        System.out.print(messageSource.getMessage("present.name", null, locale));
        result.setName(in.readLine());
        System.out.print(messageSource.getMessage("present.sec_name", null, locale));
        result.setSecName(in.readLine());
        return result;
    }

    @Override
    public void presentInputErr() throws Exception {
        System.out.println(messageSource.getMessage("present.err", null, locale));
    }

    @Override
    public void present(QuestionBundle question) throws Exception {
        System.out.println(messageSource.getMessage(question.getQuestion(), null, question.getQuestion(), locale));
        System.out.println(messageSource.getMessage("present.options", null, locale));
        IntStream.range(0, question.getOptions().size()).forEach(i -> System.out.printf("%d) %s\n", i, question.getOptions().get(i)));
    }

    @Override
    public int getAnswer() throws Exception {
        while (true) {
            System.out.print(messageSource.getMessage("present.answer", null, locale));
            try {
                return Integer.parseInt(in.readLine());
            } catch (NumberFormatException e) {
                presentInputErr();
            }
        }
    }

    @Override
    public void presentResult(QuizResult result) {
        System.out.println(
                messageSource.getMessage("present.result", new Object[]{
                        result.getSecName(),
                        result.getName(),
                        result.getQuestionsTotal(),
                        result.getQuestionsCorrect()}, locale)
        );
    }
}
