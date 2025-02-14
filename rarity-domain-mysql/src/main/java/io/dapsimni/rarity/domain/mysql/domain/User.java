package io.dapsimni.rarity.domain.mysql.domain;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String name;

    @Builder
    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}
