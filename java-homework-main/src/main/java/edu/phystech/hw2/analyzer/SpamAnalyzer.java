package edu.phystech.hw2.analyzer;

import java.util.List;

public class SpamAnalyzer extends KeywordAnalyzer {
    public SpamAnalyzer(List<String> keywords) {
        super(keywords, Label.SPAM);
    }

    @Override
    public Label processText(String text) {
        for (String forbiddenWord : this.getKeywords()) {
            if (text.contains(forbiddenWord)) {
                return Label.SPAM;
            }
        }
        return Label.OK;
    }
}
