package com.rholdan.game.piglatin.services;

import com.rholdan.game.piglatin.domain.RuleType;
import com.rholdan.game.piglatin.domain.Sentence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.rholdan.game.piglatin.utils.Constants.BLANK;
import static com.rholdan.game.piglatin.utils.Constants.VOWELS;

@Service
public class SentencesService {

    private final WordService wordService;

    @Autowired
    public SentencesService(WordService wordService) {
        this.wordService = wordService;
    }

    public Sentence translateSentence(String input) {
        StringBuilder outputSentence = new StringBuilder();
        String[] words = input.split(BLANK);
        for (String word: words) {
            if (!VOWELS.contains(String.valueOf(word.charAt(0)))) {
                outputSentence.append(wordService.translateWordByRule(word, RuleType.CONSONANT)).append(BLANK);
            } else {
                outputSentence.append(wordService.translateWordByRule(word, RuleType.VOWEL)).append(BLANK);
            }
        }
        Sentence sentence = new Sentence();
        sentence.setText(outputSentence.toString());
        return sentence;
    }
}
