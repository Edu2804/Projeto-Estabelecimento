package com.example.demo.controller;
import com.example.demo.domain.veiculo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("veiculo")
public class VeiculoController {
    @Autowired
    private VeiculoRepository repository;

    @GetMapping
    public ResponseEntity<Object> getVeiculo() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Object> saveVeiculo(@RequestBody VeiculoRequestDTO veiculoDto) {
        Veiculo veic = new Veiculo();
        BeanUtils.copyProperties(veiculoDto, veic);

        return ResponseEntity.status(HttpStatus.OK).body(repository.save(veic));
    }

    @PutMapping("{/id}")
    @Transactional
    public ResponseEntity<Object> updateVeiculo(@PathVariable Long id, @RequestBody VeiculoUpdateDTO veiculoDTO) {
       Optional<Veiculo> vehicleExists = repository.findById(id);

       if(!vehicleExists.isPresent()) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("vehicle has not found");
       }
       Veiculo vehicleEntity = vehicleExists.get();
       BeanUtils.copyProperties(veiculoDTO, vehicleEntity);
       return ResponseEntity.status(HttpStatus.OK).body(repository.save(vehicleEntity);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity removeVeiculo(@PathVariable Long id) {
        Optional<Veiculo> veiculo = repository.findById(id);

        if(!veiculo.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("vehicle has not found");
        }

        repository.deleteById(id);
        return status(HttpStatus.OK).body("vehicle has been deleted");
    }


}
