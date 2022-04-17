package com.vendas.services;

import com.vendas.dtos.VendaDto;
import com.vendas.entities.Venda;
import com.vendas.entities.Vendedor;
import com.vendas.repositories.VendaRepository;
import com.vendas.repositories.VendedorRepository;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;
    
    @Autowired
    private VendedorRepository vendedorRepository;

    public List<Venda> findAll() {
        return vendaRepository.findAll();
    }

    public Venda inserir(VendaDto vendaDto) {
        Venda venda = new Venda();
        venda.setData(vendaDto.getData());
        venda.setValor(vendaDto.getValor());

        Vendedor vendedor = vendedorRepository.getById(vendaDto.getVendedorId());
        venda.setVendedor(vendedor);
        return vendaRepository.save(venda);
    }

    public Venda findById(Long id) throws ObjectNotFoundException {
        return vendaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(null,     "objeto não encontrado pelo Id"));
    }

    public void deleteById(Long id) {
        vendaRepository.deleteById(id);
    }

}
