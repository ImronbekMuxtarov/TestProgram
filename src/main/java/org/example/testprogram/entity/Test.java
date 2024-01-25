package org.example.testprogram.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "tests")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "tech_id")
    private Tech tech;
}
