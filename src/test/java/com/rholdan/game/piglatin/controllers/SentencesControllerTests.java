package com.rholdan.game.piglatin.controllers;

import com.rholdan.game.piglatin.domain.Sentence;
import com.rholdan.game.piglatin.services.SentencesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebMvcTest(SentencesController.class)
public class SentencesControllerTests {

    @MockBean
    SentencesService service;

    @Autowired
    WebApplicationContext webApplicationContext;
    MockMvc mockMvc;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    private String OUTPUT = "Imetay iesflay enwhay ouyay areyay avinghay unfay ";


    @Test
    void callGetMessageOK() throws Exception {
        Sentence sentence = new Sentence();
        sentence.setText(OUTPUT);
        Mockito.when(service.translateSentence(ArgumentMatchers.anyString())).thenReturn(sentence);
        String response = mockMvc.perform(
                        MockMvcRequestBuilders.get("/play?input=Time flies when you are having fun"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        Assertions.assertTrue(response.contains(sentence.getText()));
    }

    @Test
    void callItNormal() {
        Sentence sentence = new Sentence();
        sentence.setText(OUTPUT);
        Mockito.when(service.translateSentence(ArgumentMatchers.anyString())).thenReturn(sentence);
        SentencesController controller = new SentencesController();
        ReflectionTestUtils.setField(controller, "service", service);
        Assertions.assertEquals(OUTPUT,
                controller.translateSentence("Time flies when you are having fun").getBody().getText());
    }
}
