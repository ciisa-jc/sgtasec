package com.jc.sgtasec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jc.sgtasec.model.Llamada;

@Repository
public interface ILlamadaRepository extends JpaRepository<Llamada, Long> {

}
