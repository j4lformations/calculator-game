package com.j4ltechnologies.multiplygame.services.impls;

import com.j4ltechnologies.multiplygame.domains.Multiplication;
import com.j4ltechnologies.multiplygame.domains.Tentative;
import com.j4ltechnologies.multiplygame.domains.User;
import com.j4ltechnologies.multiplygame.repositories.TentativeRepository;
import com.j4ltechnologies.multiplygame.repositories.UserRepository;
import com.j4ltechnologies.multiplygame.services.IFacteurGenerateurService;
import com.j4ltechnologies.multiplygame.services.IMultiplicationService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * Classe MultiplicationServiceTest, créée le 09/09/2022 à 22:09
 *
 * @author Joachim Zadi
 * @version 1.0 du 09/09/2022
 */
@SpringBootTest
class MultiplicationServiceTest {

    @Mock
    private IFacteurGenerateurService facteurGenerateur;
    private IMultiplicationService multiplicationService;

    @Mock
    private UserRepository userRepository;
    @Mock
    private TentativeRepository tentativeRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        multiplicationService = new MultiplicationService(
                facteurGenerateur,
                tentativeRepository,
                userRepository
        );
    }

    @Test
    public void genererMultiplication() {
        given(facteurGenerateur.genererFacteur()).willReturn(15, 11);
        Multiplication multiplication = multiplicationService.genererMultiplication();
        assertThat(multiplication.getFacteurA()).isEqualTo(15);
        assertThat(multiplication.getFacteurB()).isEqualTo(11);
    }

    @Test
    public void testBonneReponse() {
        given(facteurGenerateur.genererFacteur()).willReturn(30, 50);
        Multiplication multiplication = multiplicationService.genererMultiplication();
        User user = new User("Joachim");
        Tentative tentative = new Tentative(user, multiplication, 1500, true);

        given(userRepository.findByAlias("Joachim")).willReturn(Optional.empty());
        boolean response = multiplicationService.reponse(tentative);
        assertThat(response).isTrue();
        verify(tentativeRepository).save(tentative);
    }

    @Test
    public void testMauvaiseReponse() {
        given(facteurGenerateur.genererFacteur()).willReturn(40, 50);
        Multiplication multiplication = multiplicationService.genererMultiplication();
        User user = new User("Joachim");
        Tentative tentative = new Tentative(user, multiplication, 2010, false);

        given(userRepository.findByAlias("Joachim")).willReturn(Optional.empty());
        boolean response = multiplicationService.reponse(tentative);
        assertThat(response).isFalse();
        verify(tentativeRepository).save(tentative);
    }

    @Test
    public void testStatsTentatives() {
        Multiplication multiplication = new Multiplication(50, 30);
        User user = new User("Joachim");
        Tentative tentative1 = new Tentative(user, multiplication, 1510, false);
        Tentative tentative2 = new Tentative(user, multiplication, 1501, false);

        List<Tentative> dernieresTentatives = Lists.newArrayList(tentative1, tentative2);

        given(userRepository.findByAlias("Joachim")).willReturn(Optional.empty());
        given(tentativeRepository.findTop5ByUserAliasOrderByIdDesc("Joachim")).willReturn(dernieresTentatives);

        List<Tentative> dernieresTentativesUser = multiplicationService.tentativeByUser("Joachim");

        assertThat(dernieresTentativesUser).isEqualTo(dernieresTentatives);
    }
}