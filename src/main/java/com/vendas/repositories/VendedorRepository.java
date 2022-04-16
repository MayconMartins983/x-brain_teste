package com.vendas.repositories;

import com.vendas.entities.Venda;
import com.vendas.entities.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
    @Query("select vd from Vendedor vd left join vd.vendas v where v.data between :dataInicio and :dataFim")
    Set<Vendedor> buscarListaPeriodo(@Param("dataInicio") LocalDateTime dataInicio, @Param("dataFim") LocalDateTime dataFim);
}
