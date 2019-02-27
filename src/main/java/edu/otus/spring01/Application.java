package edu.otus.spring01;

import edu.otus.spring01.domain.QuizResult;
import edu.otus.spring01.presenter.QuizPresenter;
import edu.otus.spring01.service.QuizService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        QuizService quizService = context.getBean(QuizService.class);
        QuizPresenter quizPresenter = context.getBean(QuizPresenter.class);

        QuizResult quizResult = quizPresenter.present(quizService.getQuiz());
        System.out.printf(
                "Quiz Result for [%s %s]: Total: %d, Correct: %d",
                quizResult.getSecName(),
                quizResult.getName(),
                quizResult.getQuestionsTotal(),
                quizResult.getQuestionsCorrect()
        );
    }
}
