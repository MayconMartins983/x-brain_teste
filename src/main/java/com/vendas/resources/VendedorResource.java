package com.vendas.resources;

import com.vendas.dtos.VendedorDto;
import com.vendas.entities.Vendedor;
import com.vendas.services.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/vendedor")
public class VendedorResource {

    @Autowired
    private VendedorService vendedorService;

    @GetMapping()
    public ResponseEntity<List<Vendedor>> findAll() {
        return ResponseEntity.ok().body(vendedorService.findAll());
    }

    @GetMapping("/periodo")
    public ResponseEntity<List<VendedorDto>> buscarListaPeriodo(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                                         LocalDateTime dataInicio,
                                                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                                         LocalDateTime dataFim) {
        return ResponseEntity.ok().body(vendedorService.findByPeriodo(dataInicio, dataFim));
    }

    @PostMapping
    public ResponseEntity<?> inserirVendedor(@RequestBody VendedorDto vendedorDto) {
        return ResponseEntity.created(null).body(vendedorService.inserirVendedor(vendedorDto));
    }
}
