package com.jc.sgtasec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jc.sgtasec.model.Atencion;

@Repository
public interface IAtencionRepository extends JpaRepository<Atencion, Long> {

}
