package com.vendas.resources;

import com.vendas.dtos.VendaDto;
import com.vendas.entities.Venda;
import com.vendas.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venda")
public class VendaResource {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public ResponseEntity<List<Venda>> findAll() {
        return ResponseEntity.ok().body(vendaService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> inserir(@RequestBody VendaDto vendaDto) {
        return ResponseEntity.created(null).body(vendaService.inserir(vendaDto));
    }
}
