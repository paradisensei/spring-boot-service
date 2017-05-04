package com.aidar.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author Aidar Shaifutdinov.
 */
@RunWith(SpringRunner.class)
public class ZodiacSignTest {

    @Test
    public void ofShouldReturnZodiacSignCorrespondingToBirthDate() {
        ZodiacSign[] signs = ZodiacSign.values();
        for (ZodiacSign sign : signs) {
            int ordinal = sign.ordinal();
            ZodiacSign prevSign = signs[ordinal != 0 ? ordinal - 1 : 11];
            for (int i = 1; i <= 31; i++) {
                ZodiacSign expected = i < sign.getFromDay() ? prevSign : sign;
                assertEquals(expected, ZodiacSign.of(ordinal + 1, i));
            }
        }
    }

}
