package com.jc.sgtasec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jc.sgtasec.model.Turno;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Long> {

}
