package org.example.testprogram.controller;

import lombok.RequiredArgsConstructor;
import org.example.testprogram.dto.test.TestRequestDTO;
import org.example.testprogram.dto.test.TestResponseDTO;
import org.example.testprogram.service.TestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class TestController {
    private final TestService service;

    @GetMapping
    public List<TestResponseDTO> getTests(){
        return service.getTests();
    }

    @GetMapping("/{id}")
    public TestResponseDTO getTest(@PathVariable Integer id){
        return service.getTest(id);
    }

    @PostMapping
    public TestResponseDTO addTest(@RequestBody TestRequestDTO requestDTO){
        return service.addTest(requestDTO);
    }

    @PutMapping("/{id}")
    public TestResponseDTO updateTest(@PathVariable Integer id, @RequestBody TestRequestDTO requestDTO){
        return service.updateTest(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTest(@PathVariable Integer id){
        service.deleteTest(id);
    }
}
