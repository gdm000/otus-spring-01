package edu.otus.spring01.loader;

import edu.otus.spring01.domain.QuizBundle;

public interface QuizLoader {
    QuizBundle load() throws Exception;
}
