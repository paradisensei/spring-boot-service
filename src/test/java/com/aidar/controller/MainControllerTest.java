package com.aidar.controller;

import com.aidar.util.ZodiacSign;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Aidar Shaifutdinov.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void zodiacShouldRenderMainViewWithZodiacSignCorrespondingToBirthDate()
            throws Exception {
        String date = "1995-12-09";
        ZodiacSign expected = ZodiacSign.SAGITTARIUS;
        mvc.perform(get("/zodiac").param("date", date))
                .andExpect(status().isOk())
                .andExpect(view().name("main"))
                .andExpect(model().attribute("zodiac", expected.getAlias()));
    }

    @Test
    public void zodiacShouldRender4xxViewUponReceivingInvalidRequest()
            throws Exception {
        String invalidDate = "1995-13-09";
        mvc.perform(get("/zodiac").param("date", invalidDate))
                .andExpect(status().isBadRequest())
                .andExpect(view().name("4xx"));
    }

}
