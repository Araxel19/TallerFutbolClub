package com.TallerFutbolClub.app.controlador;

import com.TallerFutbolClub.app.entidades.Competicion;
import com.TallerFutbolClub.app.repositorio.CompeticionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/competiciones")
public class CompeticionController {

    @Autowired
    private CompeticionRepositorio competicionRepositorio;

    @GetMapping
    public String listarCompeticiones(Model model) {
        model.addAttribute("competiciones", competicionRepositorio.findAll());
        return "competiciones/lista";
    }

    @GetMapping("/nuevo")
    public String formularioNuevaCompeticion(Model model) {
        model.addAttribute("competicion", new Competicion());
        return "competiciones/formulario";
    }

    @PostMapping("/guardar")
    public String guardarCompeticion(@ModelAttribute Competicion competicion) {
        competicionRepositorio.save(competicion);
        return "redirect:/competiciones";
    }

    @GetMapping("/editar/{id}")
    public String editarCompeticion(@PathVariable Long id, Model model) {
        Competicion competicion = competicionRepositorio.findById(id).orElse(null);
        model.addAttribute("competicion", competicion);
        return "competiciones/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCompeticion(@PathVariable Long id) {
        competicionRepositorio.deleteById(id);
        return "redirect:/competiciones";
    }
}