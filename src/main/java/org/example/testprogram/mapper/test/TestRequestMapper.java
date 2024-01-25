package org.example.testprogram.mapper.test;

import org.example.testprogram.dto.test.TestRequestDTO;
import org.example.testprogram.entity.Test;
import org.example.testprogram.mapper.RequestMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TestRequestMapper implements RequestMapper<TestRequestDTO, Test> {
    @Override
    public Test toEntity(TestRequestDTO requestDTO) {
        return Test.builder()
                .title(requestDTO.getTitle())
                .build();
    }

    @Override
    public Test toEntityWithRefferance(TestRequestDTO requestDTO, Test test) {
        test.setTitle(requestDTO.getTitle());
        return test;
    }

    @Override
    public List<Test> toEntities(List<TestRequestDTO> requestDTOS) {
        return requestDTOS.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
