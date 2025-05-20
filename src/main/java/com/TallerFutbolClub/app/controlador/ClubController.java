package com.TallerFutbolClub.app.controlador;

import com.TallerFutbolClub.app.entidades.Club;
import com.TallerFutbolClub.app.entidades.Jugador;
import com.TallerFutbolClub.app.repositorio.AsociacionRepositorio;
import com.TallerFutbolClub.app.repositorio.JugadorRepositorio;
import com.TallerFutbolClub.app.repositorio.ClubRepositorio;
import com.TallerFutbolClub.app.repositorio.CompeticionRepositorio;
import com.TallerFutbolClub.app.repositorio.EntrenadorRepositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clubes")
public class ClubController {

	@Autowired
	private ClubRepositorio clubRepositorio;

	@Autowired
	private EntrenadorRepositorio entrenadorRepositorio;

	@Autowired
	private JugadorRepositorio jugadorRepositorio;

	@Autowired
	private AsociacionRepositorio asociacionRepositorio;

	@Autowired
	private CompeticionRepositorio competicionRepositorio;

	// 1. Mostrar lista de clubes
	@GetMapping
	public String listarClubes(Model model) {
		model.addAttribute("clubes", clubRepositorio.findAll());
		return "clubes/lista"; // → templates/clubes/lista.html
	}

	// 2. Mostrar formulario para nuevo club
	@GetMapping("/nuevo")
	public String formularioNuevoClub(Model model) {
		model.addAttribute("club", new Club());
		cargarDatosRelacionados(model);
		return "clubes/formulario";
	}

	// 3. Guardar club nuevo o actualizado
	@PostMapping("/guardar")
	public String guardarClub(@ModelAttribute Club club,
			@RequestParam(value = "jugadorIds", required = false) List<Long> jugadorIds) {
		// Guardar el club
		Club clubGuardado = clubRepositorio.save(club);

		// Si hay jugadores seleccionados, asociarlos
		if (jugadorIds != null && !jugadorIds.isEmpty()) {
			List<Jugador> jugadores = jugadorRepositorio.findAllById(jugadorIds);
			for (Jugador jugador : jugadores) {
				jugador.setClub(clubGuardado);
			}
			jugadorRepositorio.saveAll(jugadores);
		}

		return "redirect:/clubes";
	}

	// 4. Mostrar formulario de edición
	@GetMapping("/editar/{id}")
	public String editarClub(@PathVariable Long id, Model model) {
		Club club = clubRepositorio.findById(id).orElse(null);
		model.addAttribute("club", club);
		cargarDatosRelacionados(model);
		return "clubes/formulario";
	}

	// 5. Eliminar club
	@GetMapping("/eliminar/{id}")
	public String eliminarClub(@PathVariable Long id) {
		clubRepositorio.deleteById(id);
		return "redirect:/clubes";
	}

	private void cargarDatosRelacionados(Model model) {
		model.addAttribute("entrenadores", entrenadorRepositorio.findAll());
		model.addAttribute("jugadores", jugadorRepositorio.findAll());
		model.addAttribute("asociaciones", asociacionRepositorio.findAll());
		model.addAttribute("competiciones", competicionRepositorio.findAll());
	}
}
