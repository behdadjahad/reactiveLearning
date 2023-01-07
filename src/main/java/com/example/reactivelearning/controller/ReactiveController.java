package com.example.reactivelearning.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/reactive")
public class ReactiveController {


    @GetMapping
    public Flux<String> getAllCourses() {

        List<String> data = new ArrayList<>();
        data.add("this is reactive.\n");
        data.add("this is really fun.\n");
        data.add("wow!\n");
        data.add("how cool is this!\n");
        Flux flux = Flux.fromIterable(data).delayElements(Duration.of(2, ChronoUnit.SECONDS));
        return flux.map(value -> {
            System.out.println(value);
            return value;});
    }

}