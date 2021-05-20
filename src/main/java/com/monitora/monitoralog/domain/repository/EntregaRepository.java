package com.monitora.monitoralog.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monitora.monitoralog.domain.model.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {

}
