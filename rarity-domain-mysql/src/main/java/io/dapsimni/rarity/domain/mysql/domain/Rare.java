package io.dapsimni.rarity.domain.mysql.domain;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "rare")
public class Rare extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rareId;
    private String name;
    private int quantity;

    @Builder
    public Rare(String rareId, String name, int quantity) {
        this.rareId = rareId;
        this.name = name;
        this.quantity = quantity;
    }
}
