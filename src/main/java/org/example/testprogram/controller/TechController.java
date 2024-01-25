package org.example.testprogram.controller;

import lombok.RequiredArgsConstructor;
import org.example.testprogram.dto.tech.TechRequestDTO;
import org.example.testprogram.dto.tech.TechResponseDTO;
import org.example.testprogram.service.TechService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tech")
@RequiredArgsConstructor
public class TechController {
    private final TechService service;

    @GetMapping
    public List<TechResponseDTO> getTechs(){
        return service.getTechs();
    }

    @GetMapping("/{id}")
    public TechResponseDTO getTech(@PathVariable Integer id){
        return service.getTech(id);
    }

    @PostMapping
    public TechResponseDTO addTech(@RequestBody TechRequestDTO requestDTO){
        return service.addTech(requestDTO);
    }

    @PutMapping("/{id}")
    public TechResponseDTO updateTech(@PathVariable Integer id, @RequestBody TechRequestDTO requestDTO){
        return service.updateTech(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTech(@PathVariable Integer id){
        service.deleteTech(id);
    }
}
