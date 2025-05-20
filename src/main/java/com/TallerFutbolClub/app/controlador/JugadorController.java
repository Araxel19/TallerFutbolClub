package com.TallerFutbolClub.app.controlador;

import com.TallerFutbolClub.app.entidades.Jugador;
import com.TallerFutbolClub.app.repositorio.JugadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorRepositorio jugadorRepositorio;

    @GetMapping
    public String listarJugadores(Model model) {
        model.addAttribute("jugadores", jugadorRepositorio.findAll());
        return "jugadores/lista";
    }

    @GetMapping("/nuevo")
    public String formularioNuevoJugador(Model model) {
        model.addAttribute("jugador", new Jugador());
        return "jugadores/formulario";
    }

    @PostMapping("/guardar")
    public String guardarJugador(@ModelAttribute Jugador jugador) {
        jugadorRepositorio.save(jugador);
        return "redirect:/jugadores";
    }

    @GetMapping("/editar/{id}")
    public String editarJugador(@PathVariable Long id, Model model) {
        Jugador jugador = jugadorRepositorio.findById(id).orElse(null);
        model.addAttribute("jugador", jugador);
        return "jugadores/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarJugador(@PathVariable Long id) {
        jugadorRepositorio.deleteById(id);
        return "redirect:/jugadores";
    }
}