package com.TallerFutbolClub.app.repositorio;

import com.TallerFutbolClub.app.entidades.Competicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompeticionRepositorio extends JpaRepository<Competicion, Long> {
}