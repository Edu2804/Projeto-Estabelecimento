package com.example.demo.controller;
import com.example.demo.domain.estacionamento.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("estacionamento")
public class EstaciomentoController {
    @Autowired
    private EstacionamentoRepository repository;
    @GetMapping
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Object> saveEstacionamento(@RequestBody EstacionamentoRequestDTO estacionamento) {
    Estacionamento estEntity = new Estacionamento();
        BeanUtils.copyProperties(estacionamento, estEntity);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(estEntity));
}



    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<Object> updateEst(PathVariable Long id, @RequestBody EstacionamentoUpdateDTO estacionamentoUpdateDTO) {
        Optional<Estacionamento> estaExists = repository.findById(id);

        if(!estaExists.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("parking not found");
        }
        Estacionamento estEntity = estaExists.get();
        BeanUtils.copyProperties(estacionamentoUpdateDTO, estEntity);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(estEntity));

    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> removeEst(Long id) {
    Optional<Estacionamento> estacionamento = repository.findById(id);
    if(!estacionamento.isPresent()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("parking not found");
    }
    repository.deleteById(id);
    return ResponseEntity.status(HttpStatus.OK).body("Park has been deleted");
    }

}
