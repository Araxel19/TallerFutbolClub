package com.TallerFutbolClub.app.entidades;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "asociaciones")
public class Asociacion {
	
	@OneToMany(mappedBy = "asociacion")
	private List<Club> clubes;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String pais;
    private String presidente;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getPresidente() {
		return presidente;
	}
	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}
    
	public List<Club> getClubes() {
	    return clubes;
	}

	public void setClubes(List<Club> clubes) {
	    this.clubes = clubes;
	}
    
}
