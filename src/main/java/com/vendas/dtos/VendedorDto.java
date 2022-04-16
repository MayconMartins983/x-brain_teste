package com.vendas.dtos;

public class VendedorDto {
    private String nome;
    private Integer totalVendas;
    private Double mediaDiaria;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(Integer totalVendas) {
        this.totalVendas = totalVendas;
    }

    public Double getMediaDiaria() {
        return mediaDiaria;
    }

    public void setMediaDiaria(Double mediaDiaria) {
        this.mediaDiaria = mediaDiaria;
    }
}
