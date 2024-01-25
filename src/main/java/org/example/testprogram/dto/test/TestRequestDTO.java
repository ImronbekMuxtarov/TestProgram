package org.example.testprogram.dto.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TestRequestDTO {
    private String title;
    private Integer tech_id;
}
