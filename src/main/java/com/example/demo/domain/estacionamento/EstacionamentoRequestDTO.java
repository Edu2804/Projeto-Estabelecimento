package com.example.demo.domain.estacionamento;

public record EstacionamentoRequestDTO(String nome, String cnpj, String endereco,String telefone, Integer qntVagaMoto, Integer qntVagaCarro) {
}
