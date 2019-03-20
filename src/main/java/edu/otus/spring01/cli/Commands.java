package edu.otus.spring01.cli;

import edu.otus.spring01.domain.QuizBundle;
import edu.otus.spring01.domain.QuizResult;
import edu.otus.spring01.presenter.QuizPresenter;
import edu.otus.spring01.runner.QuizRunner;
import edu.otus.spring01.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class Commands {

    public static final String QUIZ_PASSED = "Quiz passed";
    public static final String QUIZ_FAILED = "Quiz failed";


    private final QuizService quizService;

    private final QuizRunner quizRunner;

    private final QuizPresenter quizPresenter;

    private QuizResult quizResult;

    @Autowired
    public Commands(QuizService quizService, QuizRunner quizRunner, QuizPresenter quizPresenter) {
        this.quizService = quizService;
        this.quizRunner = quizRunner;
        this.quizPresenter = quizPresenter;
    }

    @ShellMethod("Start quiz")
    public String start() throws Exception {
        QuizBundle quiz = quizService.getQuiz();
        quizResult = quizRunner.runQuiz(quiz);
        return  (quizResult.getQuestionsTotal() == quizResult.getQuestionsCorrect()) ? QUIZ_PASSED : QUIZ_FAILED;
    }

    @ShellMethod("Quiz result")
    public void result() {
        quizPresenter.presentResult(quizResult);
    }

    public Availability resultAvailability() {
        return quizResult != null ? Availability.available() : Availability.unavailable("No quiz finished");
    }
}
