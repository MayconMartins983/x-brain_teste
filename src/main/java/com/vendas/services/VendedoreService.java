package com.vendas.services;

import com.vendas.entities.Venda;
import com.vendas.entities.Vendedor;
import com.vendas.repositories.VendaRepository;
import com.vendas.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedoreService {
    @Autowired
    private VendedorRepository vendedorRepository;

    public List<Vendedor> findAll() {
        return vendedorRepository.findAll();
    }
}
