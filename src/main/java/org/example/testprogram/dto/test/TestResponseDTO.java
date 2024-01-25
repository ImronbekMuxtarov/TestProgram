package org.example.testprogram.dto.test;

import lombok.*;
import org.example.testprogram.dto.tech.TechResponseDTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TestResponseDTO {
    private Integer id;
    private String title;
    private TechResponseDTO tech;
}
