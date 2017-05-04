package com.aidar.util;

/**
 * @author Aidar Shaifutdinov.
 */
public enum ZodiacSign {

    /**
     * Between 21.01 - 19.02
     */
    AQUARIUS("Водолей", 21),
    /**
     * Between 20.02 - 20.03
     */
    PISCES("Рыбы", 20),
    /**
     * Between 21.03 - 20.04
     */
    ARIES("Овен", 21),
    /**
     * Between 21.04 - 21.05
     */
    TAURUS("Телец", 21),
    /**
     * Between 22.05 - 21.06
     */
    GEMINI("Близнецы", 22),
    /**
     * Between 22.06 - 22.07
     */
    CANCER("Рак", 22),
    /**
     * Between 23.07 - 21.08
     */
    LEO("Лев", 23),
    /**
     * Between 22.08 - 23.09
     */
    VIRGO("Дева", 22),
    /**
     * Between 24.09 - 23.10
     */
    LIBRA("Весы", 24),
    /**
     * Between 24.10 - 22.11
     */
    SCORPIO("Скорпион", 24),
    /**
     * Between 23.11 - 22.12
     */
    SAGITTARIUS("Стрелец", 23),
    /**
     * Between 23.12 - 20.01
     */
    CAPRICORN("Козерог", 23);

    public static ZodiacSign of(int month, int day) {
        int ordinal = month - 1;
        ZodiacSign sign = values()[ordinal];
        if (day < sign.fromDay) {
            sign = values()[ordinal != 0 ? ordinal - 1 : 11];
        }
        return sign;
    }

    private final String alias;
    private final int fromDay;

    ZodiacSign(String alias, int fromDay) {
        this.alias = alias;
        this.fromDay = fromDay;
    }

    public String getAlias() {
        return alias;
    }

    public int getFromDay() {
        return fromDay;
    }

}
