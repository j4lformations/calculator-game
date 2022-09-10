package com.j4ltechnologies.multiplygame.repositories;

import com.j4ltechnologies.multiplygame.domains.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author : Cr�e par Joachim le 09/09/2022 � 15:41
 * @version : 1.0
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByAlias(final String alias);
}
