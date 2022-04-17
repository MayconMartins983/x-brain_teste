package com.vendas;

import com.vendas.entities.Venda;
import com.vendas.entities.Vendedor;
import com.vendas.repositories.VendaRepository;
import com.vendas.repositories.VendedorRepository;
import com.vendas.services.VendaService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ActiveProfiles("test")
class VendaServiceTests {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private VendaService vendaService;

    @Test
    void vendaFindByIdTest() {
        Venda venda = new Venda();
        venda.setData(LocalDateTime.now());
        venda.setValor(1234.0);
        Vendedor vendedor = vendedorRepository.getById(1L);
        venda.setVendedor(vendedor);
        Venda vendaSave = vendaRepository.save(venda);
        Venda vendaFind = vendaService.findById(vendaSave.getIdVenda());

        assertNotNull(vendaSave);
        assertNotNull(vendaFind);
        assertEquals(vendaSave.getIdVenda(), vendaFind.getIdVenda());
        
        vendaService.deleteById(vendaSave.getIdVenda());
    }

}