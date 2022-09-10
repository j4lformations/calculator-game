package com.j4ltechnologies.multiplygame.services;

import com.j4ltechnologies.multiplygame.domains.Multiplication;
import com.j4ltechnologies.multiplygame.domains.Tentative;

import java.util.List;

/**
 * Classe IMultiplicationService, créée le 09/09/2022 à 19:28
 *
 * @author Joachim Zadi
 * @version 1.0 du 09/09/2022
 */
public interface IMultiplicationService {
    /**
     * Permet de generer une operation de multiplication avec de facteurs
     * aléatoires compris entre 11 & 99
     *
     * @return Un Objet Multiplication avec des facteurs aleatoires
     * compris entre 11 & 99
     */
    Multiplication genererMultiplication();

    /**
     * Permet d'evaluer une tentative de multiplication
     *
     * @param tentative, la tentative à evaluer
     * @return true si le resultat de la tentative est bonne, sinon false
     */
    boolean reponse(final Tentative tentative);

    /**
     * Permet de recuperer la liste des tentatives d'un user
     *
     * @param alias, l'alias du user correspondant aux tentatives recherchées
     * @return La liste des tentatives correspond au user dont l'alias est passé en parametre
     */
    List<Tentative> tentativeByUser(String alias);
}
