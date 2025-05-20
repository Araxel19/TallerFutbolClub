package com.TallerFutbolClub.app.repositorio;

import com.TallerFutbolClub.app.entidades.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepositorio extends JpaRepository<Jugador, Long> {
}