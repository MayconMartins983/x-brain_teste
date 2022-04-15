package com.vendas.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.time.LocalDateTime;

@Entity
@Table(name= "venda")
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenda;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(nullable = false)
    private Double valor;

    //LáToCá
    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL) //Tipo de relação de busca ao DB, todas vendas tem que ter um vendedor, é a melhor opção o cascadeTypeAll
    @JoinColumn(name="vendedor_id", referencedColumnName = "idVendedor")
    @JsonBackReference
    private Vendedor vendedor;

    public Venda(){}

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

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
