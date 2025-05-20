package com.TallerFutbolClub.app.entidades;

import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name = "clubes")
public class Club {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String Nombre;

    @OneToOne
    @JoinColumn(name = "id_entrenador")
    private Entrenador entrenador;

    @OneToMany
    @JoinColumn(name = "id_club")
    private List<Jugador> jugadores;

    @ManyToOne
    @JoinColumn(name = "id_asociacion")
    private Asociacion asociacion;

    @ManyToOne
    @JoinColumn(name = "competicion_id")
    private Competicion competicion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public Asociacion getAsociacion() {
		return asociacion;
	}

	public void setAsociacion(Asociacion asociacion) {
		this.asociacion = asociacion;
	}

	public Competicion getCompeticion() {
	    return competicion;
	}

	public void setCompeticion(Competicion competicion) {
	    this.competicion = competicion;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	
    
    
}
