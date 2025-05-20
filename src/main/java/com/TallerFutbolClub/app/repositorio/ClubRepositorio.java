package com.TallerFutbolClub.app.repositorio;

import com.TallerFutbolClub.app.entidades.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepositorio extends JpaRepository<Club, Long> {
}
