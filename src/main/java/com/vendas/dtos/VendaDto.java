package com.vendas.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

public class VendaDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idVenda;
    private LocalDateTime data;
    private Double valor;
    private Long vendedorId;

    public VendaDto(){}

    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Long getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(Long vendedorId) {
        this.vendedorId = vendedorId;
    }
}
