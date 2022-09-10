package com.j4ltechnologies.multiplygame.services.impls;

import com.j4ltechnologies.multiplygame.domains.Multiplication;
import com.j4ltechnologies.multiplygame.domains.Tentative;
import com.j4ltechnologies.multiplygame.domains.User;
import com.j4ltechnologies.multiplygame.repositories.TentativeRepository;
import com.j4ltechnologies.multiplygame.repositories.UserRepository;
import com.j4ltechnologies.multiplygame.services.IFacteurGenerateurService;
import com.j4ltechnologies.multiplygame.services.IMultiplicationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Classe MultiplicationService, créée le 09/09/2022 à 19:36
 *
 * @author Joachim Zadi
 * @version 1.0 du 09/09/2022
 */
@Service
@Transactional
public class MultiplicationService implements IMultiplicationService {

    private IFacteurGenerateurService facteurGenerateur;
    private TentativeRepository tentativeRepository;
    private UserRepository userRepository;

    public MultiplicationService(final IFacteurGenerateurService facteurGenerateur, final TentativeRepository tentativeRepository, final UserRepository userRepository) {
        this.facteurGenerateur = facteurGenerateur;
        this.tentativeRepository = tentativeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Multiplication genererMultiplication() {
        int facteurA = facteurGenerateur.genererFacteur();
        int facteurB = facteurGenerateur.genererFacteur();
        return new Multiplication(facteurA, facteurB);
    }

    @Override
    public boolean reponse(Tentative tentative) {
        //On verifie si l'alias existe deja
        Optional<User> user = userRepository.findByAlias(tentative.getUser().getAlias());
        boolean isCorrect = tentative.getReponse() == tentative.getMultiplication().getFacteurA() * tentative.getMultiplication().getFacteurB();

        Tentative tentativeReponse = new Tentative(
                user.orElse(tentative.getUser()),
                tentative.getMultiplication(),
                tentative.getReponse(),
                isCorrect
        );

        //On persiste la tentative
        tentativeRepository.save(tentativeReponse);
        return isCorrect;
    }

    @Override
    public List<Tentative> tentativeByUser(String alias) {
        return tentativeRepository.findTop5ByUserAliasOrderByIdDesc(alias);
    }
}
