package com.example.demo.controller;
import com.example.demo.domain.estacionamento.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("estacionamento")
public class estaciomentoController {
    @Autowired
private EstacionamentoRepository repository;
    @PostMapping
    @Transactional
    public void saveEstacionamento(@RequestBody EstacionamentoRequestDTO data) {
    Estacionamento est = new Estacionamento(data);
    repository.save(est);
}

    public List<EstacionamentoResponseDTO> getAll() {
    List<EstacionamentoResponseDTO> lista = repository.findAll().stream().map(EstacionamentoResponseDTO::new).toList();
    return lista;
    }

    @PutMapping
    @Transactional
    public void updateEst(@RequestBody EstacionamentoUpdateDTO d) {
        var e = repository.getReferenceById(d.id());
        e.atualizaDados(d);

    }
    @DeleteMapping("/{id}")
    @Transactional
    public String removeEst(Long id) {
    repository.deleteById(id);
        return "redirect:/estacionamento";
    }

}
