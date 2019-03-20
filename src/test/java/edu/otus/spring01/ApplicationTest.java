package edu.otus.spring01;

import edu.otus.spring01.cli.Commands;
import edu.otus.spring01.presenter.QuizPresenter;
import edu.otus.spring01.runner.QuizRunner;
import edu.otus.spring01.service.QuizService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static edu.otus.spring01.cli.Commands.QUIZ_PASSED;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
@ExtendWith(SpringExtension.class)
public class ApplicationTest {
    @Autowired
    QuizService quizService;
    @Autowired
    QuizRunner quizRunner;
    @MockBean
    QuizPresenter quizPresenter;

    @Test
    public void test() throws Exception {
        when(quizPresenter.initQuiz(any())).then(AdditionalAnswers.returnsFirstArg());
        when(quizPresenter.getAnswer()).thenReturn(0, 1, 2, 3, 4);
        Commands commands = new Commands(quizService, quizRunner, quizPresenter);
        Assertions.assertEquals(QUIZ_PASSED, commands.start());
    }
}
