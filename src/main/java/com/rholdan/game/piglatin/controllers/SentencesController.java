package com.rholdan.game.piglatin.controllers;

import com.rholdan.game.piglatin.domain.Sentence;
import com.rholdan.game.piglatin.services.SentencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentencesController {

    @Autowired
    SentencesService service;

    @GetMapping("/play")
    public ResponseEntity<Sentence> translateSentence(@RequestParam String input) {
        return ResponseEntity.ok(service.translateSentence(input));
    }
}
