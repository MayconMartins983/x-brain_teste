package com.vendas.dtos;

import com.vendas.entities.Venda;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class VendedorVendasDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idVendedor;
    private String nome;

    public List<Venda> vendas;

    public VendedorVendasDto(){}
}
