package com.j4ltechnologies.multiplygame.domains;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity(name = "T_USER")
@ToString(of = {"id", "alias"})
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@EqualsAndHashCode(of = {"alias"})
public final class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Column(name = "USER_ID")
    Integer id;

    @Getter
    @Setter
    final String alias;

    public User() {
        this(null);
    }
}
