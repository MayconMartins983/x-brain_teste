package com.vendas.resources;

import com.vendas.dtos.VendedorDto;
import com.vendas.entities.Vendedor;
import com.vendas.services.VendedoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/vendedor")
public class VendedorResource {

    @Autowired
    private VendedoreService vendedoreService;

    @GetMapping()
    public ResponseEntity<List<Vendedor>> findAll() {
        return ResponseEntity.ok().body(vendedoreService.findAll());
    }

    @GetMapping("/periodo")
    public ResponseEntity<List<VendedorDto>> buscarListaPeriodo(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                                         LocalDateTime dataInicio,
                                                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                                         LocalDateTime dataFim) {
        return ResponseEntity.ok().body(vendedoreService.findByPeriodo(dataInicio, dataFim));
    }
}
