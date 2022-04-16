package com.vendas.services;

import com.vendas.dtos.VendedorDto;
import com.vendas.entities.Vendedor;
import com.vendas.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//MUDAR O NOME DA CLASSE VENMDEDORE
@Service
public class VendedoreService {
    @Autowired
    private VendedorRepository vendedorRepository;

    public List<Vendedor> findAll() {
        return vendedorRepository.findAll();
    }

    public List<VendedorDto> findByPeriodo(LocalDateTime dataInicio, LocalDateTime dataFim) {
        Set<Vendedor> vendedores = vendedorRepository.buscarListaPeriodo(dataInicio, dataFim);
        Integer totalDias = this.calculaTotalDias(dataInicio, dataFim);
        List<VendedorDto> listaVendedores = this.calculandoVendas(vendedores, totalDias);
        return listaVendedores;
    }

    private List<VendedorDto> calculandoVendas(Set<Vendedor> vendedores, Integer totalDias) {
        List<VendedorDto> listaVendedores = new ArrayList<>();
        vendedores.forEach(vendedor -> {
            VendedorDto vendedorDto = new VendedorDto();
            vendedorDto.setNome(vendedor.getNome());
            Integer totalVendas = (int) vendedor.getVendas().stream().count();
            vendedorDto.setTotalVendas(totalVendas);
            vendedorDto.setMediaDiaria((double) totalVendas / totalDias);
            listaVendedores.add(vendedorDto);
        });
        return listaVendedores;
    }
    
    private Integer calculaTotalDias(LocalDateTime dataInicio, LocalDateTime dataFim) {
        return dataFim.getDayOfYear() - dataInicio.getDayOfYear();
    }
}
