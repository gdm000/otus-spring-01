package edu.otus.spring01.validator;

import edu.otus.spring01.domain.QuestionBundle;
import edu.otus.spring01.domain.QuizBundle;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

import static java.util.Arrays.asList;

public class QuizValidatorTest {
    QuizValidator validator = new QuizValidatorImpl();

    @Test
    public void testNoQuestions() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate(new QuizBundle(asList())));
    }

    @Test
    public void testBadIdx() {
        QuestionBundle questionBundle = new QuestionBundle("", -1, new ArrayList<>());
        QuizBundle bundle = new QuizBundle(IntStream.range(0, QuizValidatorImpl.minQuestionsCount).mapToObj(i -> questionBundle).collect(Collectors.toList()));
        assertThrows(IllegalArgumentException.class, () -> validator.validate(bundle));
    }

    @Test
    public void testOutOfBoundsIdx() {
        QuestionBundle questionBundle = new QuestionBundle("", 2, asList("", ""));
        QuizBundle bundle = new QuizBundle(IntStream.range(0, QuizValidatorImpl.minQuestionsCount).mapToObj(i -> questionBundle).collect(Collectors.toList()));
        assertThrows(IllegalArgumentException.class, () -> validator.validate(bundle));
    }

    @Test
    public void testOk() throws Exception {
        QuestionBundle questionBundle = new QuestionBundle("", 1, asList("", ""));
        QuizBundle bundle = new QuizBundle(IntStream.range(0, QuizValidatorImpl.minQuestionsCount).mapToObj(i -> questionBundle).collect(Collectors.toList()));
        validator.validate(bundle);
    }
}
