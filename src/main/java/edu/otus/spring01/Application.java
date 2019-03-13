package edu.otus.spring01;

import edu.otus.spring01.domain.QuizBundle;
import edu.otus.spring01.runner.QuizRunner;
import edu.otus.spring01.service.QuizService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext("edu.otus");
        QuizService quizService = context.getBean(QuizService.class);
        QuizRunner quizRunner = context.getBean(QuizRunner.class);
        QuizBundle quiz = quizService.getQuiz();
        quizRunner.runQuiz(quiz);
    }
}
