package com.example.demo.domain.estacionamento;

public record EstacionamentoUpdateDTO(Long id, String nome, String cnpj, String endereco, String telefone, Integer qntVagaMoto, Integer qntVagaCarro) {
}
