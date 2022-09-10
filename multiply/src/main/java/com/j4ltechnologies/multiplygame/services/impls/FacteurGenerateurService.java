package com.j4ltechnologies.multiplygame.services.impls;

import com.j4ltechnologies.multiplygame.services.IFacteurGenerateurService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * Classe FacteurGenerateurService, créée le 09/09/2022 à 19:41
 *
 * @author Joachim Zadi
 * @version 1.0 du 09/09/2022
 */
@Service
@Transactional
public class FacteurGenerateurService implements IFacteurGenerateurService {

    private final int FACTEUR_MIN = 11;
    private final int FACTEUR_MAX = 99;

    @Override
    public int genererFacteur() {
        return new Random().nextInt((FACTEUR_MAX - FACTEUR_MIN) + 1) + FACTEUR_MIN;
    }
}
