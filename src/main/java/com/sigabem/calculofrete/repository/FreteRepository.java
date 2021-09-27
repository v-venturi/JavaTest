package com.sigabem.calculofrete.repository;

import com.sigabem.calculofrete.model.Frete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Long> {

}
