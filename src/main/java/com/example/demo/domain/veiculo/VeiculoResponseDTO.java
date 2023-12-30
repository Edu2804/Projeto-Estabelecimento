package com.example.demo.domain.veiculo;

public record VeiculoResponseDTO(String marca, String modelo, String cor, String placa, String tipo) {

    public VeiculoResponseDTO(Veiculo ve) {
        this(ve.getMarca(), ve.getModelo(), ve.getCor(), ve.getPlaca(), ve.getTipo());
    }
}
