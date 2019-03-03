package edu.otus.spring01.runner;

import edu.otus.spring01.domain.QuestionBundle;
import edu.otus.spring01.domain.QuizBundle;
import edu.otus.spring01.domain.QuizResult;
import edu.otus.spring01.presenter.QuizPresenter;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class QuizRunnerImplTest {

    @Test
    public void testRunner() throws Exception {
        QuizBundle quizBundle = new QuizBundle(Arrays.asList(
                new QuestionBundle("1", 0, Arrays.asList("")),
                new QuestionBundle("2", 1, Arrays.asList("", "")),
                new QuestionBundle("3", 2, Arrays.asList("", "", ""))
        ));
        QuizPresenter presenterMock = mock(QuizPresenter.class);
        when(presenterMock.initQuiz(any())).then(i -> i.getArguments()[0]);
        when(presenterMock.getAnswer()).thenReturn(0, 1, 1);
        QuizRunner runner = new QuizRunnerImpl(presenterMock);
        QuizResult result = runner.runQuiz(quizBundle);
        assertAll(
                () -> assertEquals(3, result.getQuestionsTotal()),
                () -> assertEquals(2, result.getQuestionsCorrect())
                );
    }


}
