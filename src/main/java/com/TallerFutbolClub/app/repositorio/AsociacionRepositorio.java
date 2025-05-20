package com.TallerFutbolClub.app.repositorio;

import com.TallerFutbolClub.app.entidades.Asociacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsociacionRepositorio extends JpaRepository<Asociacion, Long> {
}