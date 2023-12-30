package com.example.demo.domain.veiculo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "veiculo")
@Table(name = "veiculo")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Veiculo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private String cor;
    private String placa;
    private String tipo;

    public Veiculo(VeiculoRequestDTO data) {
        this.marca = data.marca();
        this.modelo = data.modelo();
        this.cor = data.cor();
        this.placa = data.placa();
        this.tipo =data.tipo();
    }

    public void atualizaDados(VeiculoUpdateDTO data) {
        this.id = data.id();
        this.marca = data.marca();
        this.modelo = data.modelo();
        this.cor = data.cor();
        this.placa = data.placa();
        this.tipo =data.tipo();
    }

}

