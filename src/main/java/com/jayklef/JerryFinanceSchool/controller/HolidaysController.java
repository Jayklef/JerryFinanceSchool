package com.jayklef.JerryFinanceSchool.controller;

import com.jayklef.JerryFinanceSchool.model.Holiday;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
public class HolidaysController {
    @GetMapping("/holidays")
    public String displayHolidays(Model model){
        List<Holiday> holidays = Arrays.asList(
                new Holiday("1st January", "New Year", Holiday.Type.FESTIVE),
                new Holiday("31st October", "Halloween", Holiday.Type.FESTIVE),
                new Holiday("24th November", "Thanksgiving", Holiday.Type.FESTIVE),
                new Holiday("25th December", "Christmas", Holiday.Type.RELIGIOUS),
                new Holiday("5th September", "Labor Day", Holiday.Type.FEDERAL)
        );

        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types){
            model.addAttribute(type.toString(),
                    holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList()));
        }
        return "holidays.html";
    }
}
