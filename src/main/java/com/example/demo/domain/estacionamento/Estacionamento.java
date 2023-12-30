package com.example.demo.domain.estacionamento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name= "estacionamento")
@Table(name = "estacionamento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Estacionamento {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    private Integer qntVagaMoto;
    private Integer qntVagaCarro;

    public Estacionamento(EstacionamentoRequestDTO data) {
        this.nome = data.nome();
        this.cnpj = data.cnpj();
        this.endereco = data.endereco();
        this.telefone = data.telefone();
        this.qntVagaMoto = data.qntVagaMoto();
        this.qntVagaCarro = data.qntVagaCarro();
    }

    public void atualizaDados(EstacionamentoUpdateDTO dados) {
        this.id = dados.id();
        this.nome = dados.nome();
        this.cnpj = dados.cnpj();
        this.endereco = dados.endereco();
        this.telefone = dados.telefone();
        this.qntVagaMoto = dados.qntVagaMoto();
        this.qntVagaCarro = dados.qntVagaCarro();

    }

}
