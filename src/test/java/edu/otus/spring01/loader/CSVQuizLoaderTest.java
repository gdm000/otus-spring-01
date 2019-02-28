package edu.otus.spring01.loader;

import edu.otus.spring01.domain.QuestionBundle;
import edu.otus.spring01.domain.QuizBundle;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import static org.junit.jupiter.api.Assertions.*;

public class CSVQuizLoaderTest {

    @Test
    public void testLoader() throws Exception {
        CSVQuizLoader loader = new CSVQuizLoader(new ClassPathResource("test_quiz.csv"));
        QuizBundle quizBundle = loader.load();
        assertEquals(3, quizBundle.getQuestions().size());
        for (QuestionBundle questionBundle: quizBundle.getQuestions()) {
            assertTrue(questionBundle.getOptions().size() > 0);
            assertNotNull(questionBundle.getQuestion());
        }
    }
}
