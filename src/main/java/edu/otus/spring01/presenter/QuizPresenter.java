package edu.otus.spring01.presenter;

import edu.otus.spring01.domain.QuestionBundle;
import edu.otus.spring01.domain.QuizResult;

import java.io.IOException;

public interface QuizPresenter {
    QuizResult initQuiz(QuizResult result) throws Exception;
    void present(QuestionBundle question) throws Exception;
    void presentInputErr() throws Exception;
    int getAnswer() throws Exception;
    void presentResult(QuizResult result);
}
