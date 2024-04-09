package edu.phystech.hw2.analyzer;


import java.util.List;

public class NegativeTextAnalyzer extends KeywordAnalyzer {
    private static final List<String> NEGATIVE_SMILES = List.of(":(", "=(", ":|");

    public NegativeTextAnalyzer() {
        super(NEGATIVE_SMILES, Label.NEGATIVE);
    }

    @Override
    public Label processText(String text) {
        for (String banWord : this.getKeywords()) {
            if (text.indexOf(banWord) == text.length() - 2 && text.contains(' ' + banWord)) {
                return Label.NEGATIVE;
            } else if (text.indexOf(banWord) == 0 && text.contains(banWord + ' ')) {
                return Label.NEGATIVE;
            } else if (text.contains(' ' + banWord + ' ')) {
                return Label.NEGATIVE;
            }
        }
        return Label.OK;
    }
}

