package org.example.testprogram.service;

import lombok.RequiredArgsConstructor;
import org.example.testprogram.dto.test.TestRequestDTO;
import org.example.testprogram.dto.test.TestResponseDTO;
import org.example.testprogram.entity.Test;
import org.example.testprogram.mapper.test.TestRequestMapper;
import org.example.testprogram.mapper.test.TestResponseMapper;
import org.example.testprogram.repository.TechRepository;
import org.example.testprogram.repository.TestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository repository;
    private final TestRequestMapper requestMapper;
    private final TestResponseMapper responseMapper;
    private final TechRepository techRepository;

    public List<TestResponseDTO> getTests(){
        return responseMapper.toDTOs(
                repository.findAll()
        );
    }

    public TestResponseDTO getTest(Integer id){
        return responseMapper.toDTO(
                repository.getReferenceById(id)
        );
    }

    public TestResponseDTO addTest(TestRequestDTO requestDTO){
        Test test = new Test();
        test.setTech(
                techRepository.getReferenceById(requestDTO.getTech_id())
        );
        return responseMapper.toDTO(
                repository.save(
                        requestMapper.toEntityWithRefferance(requestDTO, test)
                )
        );
    }

    public TestResponseDTO updateTest(Integer id, TestRequestDTO requestDTO){
        Test test = repository.getReferenceById(id);
        test.setId(id);
        test.setTech(
                techRepository.getReferenceById(requestDTO.getTech_id())
        );
        return responseMapper.toDTO(
                repository.save(
                        requestMapper.toEntityWithRefferance(requestDTO, test)
                )
        );
    }

    public void deleteTest(Integer id){
        repository.deleteById(id);
    }
}
