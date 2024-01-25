package org.example.testprogram.service;

import lombok.RequiredArgsConstructor;
import org.example.testprogram.dto.tech.TechRequestDTO;
import org.example.testprogram.dto.tech.TechResponseDTO;
import org.example.testprogram.mapper.tech.TechRequestMapper;
import org.example.testprogram.mapper.tech.TechResponseMapper;
import org.example.testprogram.repository.TechRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TechService {
    private final TechRepository repository;
    private final TechRequestMapper requestMapper;
    private final TechResponseMapper responseMapper;

    public List<TechResponseDTO> getTechs(){
        return responseMapper.toDTOs(
                repository.findAll()
        );
    }

    public TechResponseDTO getTech(Integer id){
        return responseMapper.toDTO(
                repository.getReferenceById(id)
        );
    }

    public TechResponseDTO addTech(TechRequestDTO requestDTO){
        return responseMapper.toDTO(
                repository.save(
                        requestMapper.toEntity(requestDTO)
                )
        );
    }

    public TechResponseDTO updateTech(Integer id, TechRequestDTO requestDTO){
        return responseMapper.toDTO(
                repository.save(
                        requestMapper.toEntityWithRefferance(
                                requestDTO,
                                repository.getReferenceById(id)
                        )
                )
        );
    }

    public void deleteTech(Integer id){
        repository.deleteById(id);
    }
}
