package io.dapsimni.rarity.domain.mysql.domain;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "win")
public class Win extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String rareId;

    @Builder
    public Win(String userId, String rareId) {
        this.userId = userId;
        this.rareId = rareId;
    }
}
