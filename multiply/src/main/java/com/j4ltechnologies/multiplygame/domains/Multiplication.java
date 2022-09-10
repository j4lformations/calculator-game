package com.j4ltechnologies.multiplygame.domains;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity(name = "T_MULTIPLICATION")
@ToString(of = {"facteurA", "facteurB"})
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@EqualsAndHashCode(of = {"id", "facteurA", "facteurB"})
public final class Multiplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MULTIPLICATION_ID")
    @Getter
    Integer id;

    @Getter
    final int facteurA;

    @Getter
    final int facteurB;

    public Multiplication() {
        this(0, 0);
    }
}
