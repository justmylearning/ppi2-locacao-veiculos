package com.ppi2.ppi2.v1.repositories;

import com.ppi2.ppi2.v1.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{
}
