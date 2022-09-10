package com.j4ltechnologies.multiplygame.services.impls;

import com.j4ltechnologies.multiplygame.services.IFacteurGenerateurService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Classe FacteurGenerateurServiceTest, créée le 09/09/2022 à 22:06
 *
 * @author Joachim Zadi
 * @version 1.0 du 09/09/2022
 */
@SpringBootTest
class FacteurGenerateurServiceTest {
    private IFacteurGenerateurService generateurService;

    @BeforeEach
    public void init() {
        generateurService = new FacteurGenerateurService();
    }

    @Test
    public void genererFacteur() {
        List<Integer> facteurGeneres = IntStream.range(0, 1000)
                .map(i -> generateurService.genererFacteur())
                .boxed()
                .collect(Collectors.toList());

        assertThat(facteurGeneres).containsAnyElementsOf(
                IntStream.range(11, 100).boxed().collect(Collectors.toList())
        );
    }
}