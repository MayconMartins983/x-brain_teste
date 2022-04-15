package com.vendas.services;

import com.vendas.dtos.VendaDto;
import com.vendas.entities.Venda;
import com.vendas.entities.Vendedor;
import com.vendas.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> findAll() {
        return vendaRepository.findAll();
    }

    public Venda inserir(VendaDto vendaDto) {
        Venda venda = new Venda();
        venda.setData(vendaDto.getData());
        venda.setValor(vendaDto.getValor());
        Vendedor vendedor = new Vendedor();
        vendedor.setIdVendedor(vendaDto.getVendedorId());
        venda.setVendedor(vendedor);
        return vendaRepository.save(venda);
    }
}
