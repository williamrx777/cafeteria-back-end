package com.cafeteria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafeteria.models.CompraConfirmado;

@Repository
public interface CompraConfirmadaRepository extends JpaRepository<CompraConfirmado, Long>{

}
