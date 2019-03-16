package edu.otus.spring01.config;

import edu.otus.spring01.loader.CSVQuizLoader;
import edu.otus.spring01.loader.QuizLoader;
import edu.otus.spring01.presenter.ConsoleQuizPresenter;
import edu.otus.spring01.presenter.QuizPresenter;
import edu.otus.spring01.runner.QuizRunner;
import edu.otus.spring01.runner.QuizRunnerImpl;
import edu.otus.spring01.service.QuizService;
import edu.otus.spring01.service.QuizServiceImpl;
import edu.otus.spring01.validator.QuizValidator;
import edu.otus.spring01.validator.QuizValidatorImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

@Configuration
@EnableAspectJAutoProxy
/*@PropertySource("classpath:application.properties")*/
public class ApplicationConfig {

    @Bean
    public QuizLoader quizLoader(ApplicationContext context, @Value("${quiz.resource}") String resource) {
        return new CSVQuizLoader(context.getResource(resource));
    }

    @Bean
    public QuizValidator quizValidator() {
        return new QuizValidatorImpl();
    }

    @Bean
    public QuizPresenter quizPresenter(MessageSource messageSource, @Value("${quiz.locale}") String locale) {
        return new ConsoleQuizPresenter(messageSource, Locale.forLanguageTag(locale));
    }

    @Bean
    public QuizRunner quizRunner(QuizPresenter quizPresenter) {
        return new QuizRunnerImpl(quizPresenter);
    }

    @Bean
    public QuizService quizService(QuizLoader loader, QuizValidator validator) {
        return new QuizServiceImpl(loader, validator);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public static ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.addBasenames("messages", "quiz");
        return source;
    }
}
