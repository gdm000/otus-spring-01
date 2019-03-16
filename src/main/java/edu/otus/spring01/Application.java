package edu.otus.spring01;

import edu.otus.spring01.domain.QuizBundle;
import edu.otus.spring01.runner.QuizRunner;
import edu.otus.spring01.service.QuizService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        QuizService quizService = context.getBean(QuizService.class);
        QuizRunner quizRunner = context.getBean(QuizRunner.class);
        QuizBundle quiz = quizService.getQuiz();
        quizRunner.runQuiz(quiz);
        context.close();
    }
}
