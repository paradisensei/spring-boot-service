package com.aidar.controller;

import com.aidar.util.ZodiacSign;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * @author Aidar Shaifutdinov.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String main() {
        return "main";
    }

    @RequestMapping("/zodiac")
    public String zodiac(@RequestParam("date") String strDate, Model model) {
        LocalDate date = LocalDate.parse(strDate);
        ZodiacSign sign = ZodiacSign.of(date.getMonthValue(), date.getDayOfMonth());
        model.addAttribute("zodiac", sign.getAlias());
        return "main";
    }

    @ExceptionHandler(DateTimeParseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleException() {
        return "4xx";
    }

}
