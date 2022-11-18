package com.project.seed.model;

import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


@Entity
@Table(name = "entity")
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_entity", nullable = false)
    private Integer codEntity;

    @Column(length = 250, nullable = false)
    private String name;


}