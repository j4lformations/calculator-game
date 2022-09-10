package com.j4ltechnologies.multiplygame.domains;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

/**
 * @author : Crée par Joachim le 09/09/2022 à 15:14
 * @version : 1.0
 */
@Entity(name = "T_TENTATIVE")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public final class Tentative {
    @Id
    @GeneratedValue
    Integer id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "USER_ID")
    final User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MULTIPLICATION_ID")
    final Multiplication multiplication;

    final int reponse;
    final boolean correct;

    public Tentative() {
        this(null, null, 0, false);
    }
}
