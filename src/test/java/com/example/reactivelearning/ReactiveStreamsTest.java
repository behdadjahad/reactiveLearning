package com.example.reactivelearning;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


@ExtendWith(MockitoExtension.class)
public class ReactiveStreamsTest {


    @Test
    public void test() {
        Flux<String> fruitFlux = Flux
                .just("Apple", "Orange", "Grape", "Banana", "Strawberry");
        fruitFlux.subscribe(
                f -> System.out.println("Here's some fruit: " + f)
        );

        StepVerifier.create(fruitFlux)
                .expectNext("Apple")
                .expectNext("Orange")
                .expectNext("Grape")
                .expectNext("Banana")
                .expectNext("Strawberry")
                .verifyComplete();

        String [] arr = new String[] {"1", "2", "3"};
        Flux<String> fluxFromArray = Flux.fromArray(arr);

        StepVerifier.create(fluxFromArray)
                .expectNext("1")
                .expectNext("2")
                .expectNext("3")
                .verifyComplete();

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        Flux<String> fluxFromIterable = Flux.fromIterable(list);

        StepVerifier.create(fluxFromIterable)
                .expectNext("a")
                .expectNext("b")
                .expectNext("c")
                .verifyComplete();

        Stream<String> stream = Stream.of("!", "@", "#");
        Flux<String> fluxFromStream = Flux.fromStream(stream);

        StepVerifier.create(fluxFromStream)
                .expectNext("!")
                .expectNext("@")
                .expectNext("#")
                .verifyComplete();

    }
}
