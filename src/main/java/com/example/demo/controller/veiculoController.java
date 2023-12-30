package com.example.demo.controller;
import com.example.demo.domain.veiculo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("veiculo")
public class veiculoController {
    @Autowired
    private VeiculoRepository repository;

    @GetMapping
    public List<VeiculoResponseDTO> getVeic() {
        List<VeiculoResponseDTO> lista = repository.findAll().stream().map(VeiculoResponseDTO::new).toList();
        return lista;
    }

    @PostMapping
    @Transactional
    public void salvaVeiculo(@RequestBody VeiculoRequestDTO dados) {
        var v = new Veiculo(dados);
        repository.save(v);
    }

    @PutMapping
    @Transactional
    public void updateVeiculo(@RequestBody VeiculoUpdateDTO dados) {
        var veiculo = repository.getReferenceById(dados.id());
        veiculo.atualizaDados(dados);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public String removeVeiculo(Long id) {
        repository.deleteById(id);
        return "redirect:/veiculo";
    }


}
