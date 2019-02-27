package edu.otus.spring01.loader;

import com.opencsv.CSVReader;
import edu.otus.spring01.domain.QuestionBundle;
import edu.otus.spring01.domain.QuizBundle;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CSVQuizLoader implements QuizLoader {
    private final Resource csvResource;

    public CSVQuizLoader(Resource csvResource) {
        this.csvResource = csvResource;
    }

    @Override
    public QuizBundle load() throws Exception {
        try (Reader reader = new InputStreamReader(csvResource.getInputStream())) {
            return rowsToBundle(readRows(reader));
        }
    }

    private List<String[]> readRows(Reader reader) throws IOException {
        try (CSVReader csvReader = new CSVReader(reader)) {
            return csvReader.readAll();
        }
    }

    private QuizBundle rowsToBundle(List<String[]> rows) {
        return new QuizBundle(rows.stream().map(this::toQuestion).collect(Collectors.toList()));
    }

    private QuestionBundle toQuestion(String[] row) {
        if (row.length < 3) {
            throw new IllegalArgumentException("Not enough data in row");
        }
        String question = row[0];
        Integer answerIdx = Integer.parseInt(row[1]);
        List<String> options = new ArrayList<>();
        for (int i = 2; i < row.length; i++) {
            options.add(row[i]);
        }
        return new QuestionBundle(question, answerIdx, options);
    }
}
