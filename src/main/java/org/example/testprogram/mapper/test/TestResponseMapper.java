package org.example.testprogram.mapper.test;

import org.example.testprogram.dto.tech.TechResponseDTO;
import org.example.testprogram.dto.test.TestResponseDTO;
import org.example.testprogram.entity.Test;
import org.example.testprogram.mapper.ResponseMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TestResponseMapper implements ResponseMapper<TestResponseDTO, Test> {
    @Override
    public TestResponseDTO toDTO(Test test) {
        return TestResponseDTO.builder()
                .id(test.getId())
                .title(test.getTitle())
                .tech(TechResponseDTO.builder()
                        .id(test.getTech().getId())
                        .name(test.getTech().getName())
                        .build()
                )
                .build();
    }

    @Override
    public List<TestResponseDTO> toDTOs(List<Test> tests) {
        return tests.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
