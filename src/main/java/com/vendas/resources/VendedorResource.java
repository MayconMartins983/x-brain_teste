package com.vendas.resources;

import com.vendas.entities.Venda;
import com.vendas.entities.Vendedor;
import com.vendas.services.VendaService;
import com.vendas.services.VendedoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vendedor")
public class VendedorResource {

    @Autowired
    private VendedoreService vendedoreService;

    @GetMapping()
    public ResponseEntity<List<Vendedor>> findAll() {
        return ResponseEntity.ok().body(vendedoreService.findAll());
    }
}
