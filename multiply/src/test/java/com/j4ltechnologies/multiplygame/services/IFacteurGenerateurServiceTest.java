package com.j4ltechnologies.multiplygame.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Classe IFacteurGenerateurServiceTest, créée le 09/09/2022 à 21:00
 *
 * @author Joachim Zadi
 * @version 1.0 du 09/09/2022
 */
@SpringBootTest
class IFacteurGenerateurServiceTest {

    @Autowired
    private IFacteurGenerateurService generateurService;

    @Test
    void genererFacteur() {
        List<Integer> facteursGeneres = IntStream.range(0, 1000)
                .map(i -> generateurService.genererFacteur())
                .boxed()
                .collect(toList());

        assertThat(facteursGeneres)
                .containsAnyElementsOf(
                        IntStream.range(11, 100).boxed().collect(toList())
                );
    }
}