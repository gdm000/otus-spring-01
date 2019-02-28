package edu.otus.spring01.runner;

import edu.otus.spring01.domain.QuestionBundle;
import edu.otus.spring01.domain.QuizBundle;
import edu.otus.spring01.domain.QuizResult;
import edu.otus.spring01.presenter.QuizPresenter;

public class QuizRunnerImpl implements QuizRunner {
    private final QuizPresenter presenter;

    public QuizRunnerImpl(QuizPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public QuizResult runQuiz(QuizBundle quiz) throws Exception {
        QuizResult result = new QuizResult();
        result = presenter.initQuiz(result);
        for (int i = 0; i < quiz.getQuestions().size(); i++) {
            QuestionBundle question = quiz.getQuestions().get(i);
            presenter.present(question);
            int idx = getAnswer(question);
            result.setQuestionsTotal(result.getQuestionsTotal() + 1);
            result.setQuestionsCorrect(result.getQuestionsCorrect() + (idx == question.getValidOptIdx() ? 1 : 0));
        }
        return result;
    }

    private int getAnswer(QuestionBundle question) throws Exception {
        while (true) {
            int idx = presenter.getAnswer();
            if (idx >= 0 & idx < question.getOptions().size())
                return idx;
            presenter.presentInputErr();
        }
    }

}
