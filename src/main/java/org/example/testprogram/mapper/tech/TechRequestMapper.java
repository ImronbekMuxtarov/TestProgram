package org.example.testprogram.mapper.tech;

import org.example.testprogram.dto.tech.TechRequestDTO;
import org.example.testprogram.entity.Tech;
import org.example.testprogram.mapper.RequestMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TechRequestMapper implements RequestMapper<TechRequestDTO, Tech> {
    @Override
    public Tech toEntity(TechRequestDTO techRequestDTO) {
        return Tech.builder()
                .name(techRequestDTO.getName())
                .build();
    }

    @Override
    public Tech toEntityWithRefferance(TechRequestDTO requestDTO, Tech tech) {
        tech.setName(requestDTO.getName());
        return tech;
    }

    @Override
    public List<Tech> toEntities(List<TechRequestDTO> techRequestDTOS) {
        return techRequestDTOS.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
