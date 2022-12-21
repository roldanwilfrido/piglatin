package com.rholdan.game.piglatin.services;

import com.rholdan.game.piglatin.domain.RuleType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WordServiceTests {

    WordService wordService;

    @Test
    void translateWordWithConsonantRule() {
        String word = "Pleased";
        wordService = new WordService();
        Assertions.assertEquals("Easedplay", wordService.translateWordByRule(word, RuleType.CONSONANT));
    }

    @Test
    void translateWordWithVowelRule() {
        String word = "elements";
        wordService = new WordService();
        Assertions.assertEquals("elementsyay", wordService.translateWordByRule(word, RuleType.VOWEL));
    }

    @Test
    void translateWordWithAllWordsUppercase() {
        String word = "BINARY";
        wordService = new WordService();
        Assertions.assertEquals("INARYBAY", wordService.translateWordByRule(word, RuleType.CONSONANT));
    }
}
