package edu.otus.spring01.cli;

import org.jline.utils.AttributedString;
import org.springframework.stereotype.Component;

@Component
public class PromptProvider implements org.springframework.shell.jline.PromptProvider {
    @Override
    public AttributedString getPrompt() {
        return new AttributedString("quiz:>");
    }
}
