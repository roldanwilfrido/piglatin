package com.rholdan.game.piglatin.services;

import com.rholdan.game.piglatin.domain.RuleType;
import org.springframework.stereotype.Service;

import static com.rholdan.game.piglatin.utils.Constants.APPEND_CONSONANT_WORD;
import static com.rholdan.game.piglatin.utils.Constants.APPEND_VOWEL_WORD;
import static com.rholdan.game.piglatin.utils.Constants.VOWELS;

@Service
public class WordService {

    public String translateWordByRule(String word, RuleType rule) {
        return switch (rule) {
            case VOWEL ->  word + APPEND_VOWEL_WORD;
            case CONSONANT -> translateWordConsonantRule(word);
        };
    }

    private String translateWordConsonantRule(String word) {
        String response = "";
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!VOWELS.contains(String.valueOf(letter))) {
                response +=letter;
            } else {
                response = letter + word.substring(i + 1) + response.toLowerCase() + APPEND_CONSONANT_WORD;
                break;
            }
        }
        if (isAllLetterCapitalized(word)) {
            return response.toUpperCase();
        } else {
            return isCapitalized(word) ? capitalizeWord(response) : response;
        }

    }

    private boolean isAllLetterCapitalized(String word) {
        String uppercaseStr = word.toUpperCase();
        return word.equals(uppercaseStr);
    }

    private boolean isCapitalized(String word) {
        return Character.isUpperCase(word.charAt(0));
    }

    private String capitalizeWord(String word) {
        if (word.length() > 1) {
            return String.valueOf(word.charAt(0)).toUpperCase() + word.substring(1);
        }
        return word.toUpperCase();
    }
}
