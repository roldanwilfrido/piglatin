package com.rholdan.game.piglatin.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SentencesServiceTests {

    WordService wordService;

    SentencesService service;

    @Test
    void translateSentenceWithFirstWordCapitalized() {
        String input = "Pleased to meet you";
        wordService = new WordService();
        service = new SentencesService(wordService);
        Assertions.assertEquals("Easedplay otay eetmay ouyay ",
                service.translateSentence(input).getText());
    }

    @Test
    void translateSentenceWithVowelAsSingleLetter() {
        String input = "i would rather be at the beach";
        wordService = new WordService();
        service = new SentencesService(wordService);
        Assertions.assertEquals("iyay ouldway atherray ebay atyay ethay eachbay ",
                service.translateSentence(input).getText());
    }

    @Test
    void translateSentenceWithAllWordsInLowercase() {
        String input = "how much does it cost";
        wordService = new WordService();
        service = new SentencesService(wordService);
        Assertions.assertEquals("owhay uchmay oesday ityay ostcay ",
                service.translateSentence(input).getText());
    }

    @Test
    void translateSentenceWithWordsWhoContainsAllInUppercase() {
        String input = "A tree whose elements have at most two children is called a BINARY TREE";
        wordService = new WordService();
        service = new SentencesService(wordService);
        Assertions.assertEquals(
                "Ayay eetray osewhay elementsyay avehay atyay ostmay otway " +
                        "ildrenchay isyay alledcay ayay INARYBAY EETRAY ",
                service.translateSentence(input).getText());
    }
}
