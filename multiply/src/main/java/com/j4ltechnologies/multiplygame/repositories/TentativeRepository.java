package com.j4ltechnologies.multiplygame.repositories;

import com.j4ltechnologies.multiplygame.domains.Tentative;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author : Crée par Joachim le 09/09/2022 à 16:56
 * @version : 1.0
 */
public interface TentativeRepository extends CrudRepository<Tentative, Integer> {
    List<Tentative> findTop5ByUserAliasOrderByIdDesc(String alias);
}