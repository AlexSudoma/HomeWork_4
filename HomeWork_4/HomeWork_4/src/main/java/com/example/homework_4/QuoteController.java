package com.example.homework_4;


import jakarta.annotation.PostConstruct;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class QuoteController {
    private int id = 10;

    private Map<Integer, String> quoteMap = new HashMap<>();

    // Получение всех цитат
    @GetMapping("/quotes")
    public List<String> getAllQuotes() {
        return new ArrayList<>(quoteMap.values());
    }

    // Получение цитаты по id
    @GetMapping("/quotes/{id}")
    public String getQuoteById(@PathVariable int id) {
        return quoteMap.get(id);
    }

    // Добавление одной цитаты
    @PostMapping("/quotes")
    public Quote addQuote(@RequestBody @Validated Quote quote) {
        int id = quote.getId();
        quoteMap.put(id, String.valueOf(quote));
        return quote;
    }

    // Добавление множества цитат
    @PostMapping("/quotes/batch")
    public List<Quote> addQuotes(@RequestBody @Validated List<Quote> quotes) {
        for (Quote quote : quotes) {
            int id = quote.getId();
            quoteMap.put(id, String.valueOf(quote));
        }
        return quotes;
    }

    // Обновление цитаты
    @PutMapping("/quotes/{id}")
    public Quote updateQuote(@PathVariable int id, @RequestBody Quote quote) {
        quoteMap.put(id, String.valueOf(quote));
        return quote;
    }

    // Удаление цитаты по id
    @DeleteMapping("/quotes/{id}")
    public void deleteQuote(@PathVariable int id) {
        quoteMap.remove(id);
    }

    @PostConstruct
    public void init() {
        quoteMap.put(1, "Життя - це подорож, яку варто насолоджуватися кожним кроком.");
        quoteMap.put(2, "У житті немає гарантій, тому слід вірити у себе і йти вперед незалежно від усього.");
        quoteMap.put(3, "Кожен день - це нова можливість для досягнення успіху і зростання.");
        quoteMap.put(4, "Насправді важливе у житті - це люди, яких ми зустрічаємо на своєму шляху, тому слід поважати і цінувати їх.");
        quoteMap.put(5, "У житті не обов'язково бути найкращим, достатньо бути найкращим версією самого себе.");
        quoteMap.put(6, "Навіть у найскладніші моменти життя слід запам'ятовувати, що кожна проблема має своє рішення.");
        quoteMap.put(7, "Життя - це не про те, щоб чекати на чудо, а про те, щоб створювати його самому.");
        quoteMap.put(8, "Найбільші перемоги в житті належать тим, хто не боїться ризикувати і йти за своїми мріями.");
        quoteMap.put(9, "Життя - це подарунок, тому слід вміти насолоджуватися кожною митью і цінувати кожен день.");
    }

}