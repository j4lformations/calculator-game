package com.j4ltechnologies.multiplygame.repositories;

import com.j4ltechnologies.multiplygame.domains.Multiplication;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : Crée par Joachim le 09/09/2022 à 16:57
 * @version : 1.0
 */
public interface MultiplicationRepository extends CrudRepository<Multiplication, Integer> {
}
