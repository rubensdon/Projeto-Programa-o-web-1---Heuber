package com.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.stereotype.Repository;
import com.br.*;

public interface MarcaRepository extends JpaRepository<Marca, Long>{

}
