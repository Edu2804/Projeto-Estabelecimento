package com.example.demo.domain.estacionamento;

public record EstacionamentoResponseDTO(String nome, String cnpj, String endereco, String telefone, Integer qntVagaMoto, Integer qntVagaCarro) {
    public EstacionamentoResponseDTO(Estacionamento es) {
        this(es.getNome(), es.getCnpj(), es.getEndereco(), es.getTelefone(), es.getQntVagaMoto(), es.getQntVagaCarro());
    }
}
