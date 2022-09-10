package com.j4ltechnologies.multiplygame.services;

import com.j4ltechnologies.multiplygame.domains.Multiplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Classe IMultiplicationServiceTest, créée le 09/09/2022 à 21:53
 *
 * @author Joachim Zadi
 * @version 1.0 du 09/09/2022
 */
@SpringBootTest
class IMultiplicationServiceTest {

    @MockBean
    private IFacteurGenerateurService facteurGenerateur;

    @Autowired
    private IMultiplicationService multiplicationService;

    @Test
    void genererMultiplication() {
        //On simule une generation de facteurs aleatoires de valeur 30 & 50
        given(facteurGenerateur.genererFacteur()).willReturn(30, 50);

        //On créé une multiplication
        Multiplication multiplication = multiplicationService.genererMultiplication();

        assertThat(multiplication.getFacteurA()).isEqualTo(30);
        assertThat(multiplication.getFacteurB()).isEqualTo(50);
    }
}