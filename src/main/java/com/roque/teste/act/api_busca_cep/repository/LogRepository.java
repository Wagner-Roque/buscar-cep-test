package com.roque.teste.act.api_busca_cep.repository;

import com.roque.teste.act.api_busca_cep.model.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<LogEntity, Long> {
}
