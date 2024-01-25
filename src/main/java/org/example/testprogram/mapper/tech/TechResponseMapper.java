package org.example.testprogram.mapper.tech;

import org.example.testprogram.dto.tech.TechResponseDTO;
import org.example.testprogram.entity.Tech;
import org.example.testprogram.mapper.ResponseMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TechResponseMapper implements ResponseMapper<TechResponseDTO, Tech> {
    @Override
    public TechResponseDTO toDTO(Tech tech) {
        return TechResponseDTO.builder()
                .id(tech.getId())
                .name(tech.getName())
                .build();
    }

    @Override
    public List<TechResponseDTO> toDTOs(List<Tech> techs) {
        return techs.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
