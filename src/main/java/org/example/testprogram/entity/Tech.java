package org.example.testprogram.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity @Table(name = "techs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Tech {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "tech")
    private List<Test> tests;
}
