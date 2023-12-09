package com.example.ApiRemedios.Remedio.Repositorios;

import com.example.ApiRemedios.Remedio.Entidades.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RemediosRepository extends JpaRepository<Remedio, Long> {

    List<Remedio> findAllByAtivoTrue();
}
