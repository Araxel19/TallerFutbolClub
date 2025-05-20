package com.TallerFutbolClub.app.controlador;

import com.TallerFutbolClub.app.entidades.Asociacion;
import com.TallerFutbolClub.app.repositorio.AsociacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/asociaciones")
public class AsociacionController {

    @Autowired
    private AsociacionRepositorio asociacionRepositorio;

    @GetMapping
    public String listarAsociaciones(Model model) {
        model.addAttribute("asociaciones", asociacionRepositorio.findAll());
        return "asociaciones/lista";
    }

    @GetMapping("/nuevo")
    public String formularioNuevaAsociacion(Model model) {
        model.addAttribute("asociacion", new Asociacion());
        return "asociaciones/formulario";
    }

    @PostMapping("/guardar")
    public String guardarAsociacion(@ModelAttribute Asociacion asociacion) {
        asociacionRepositorio.save(asociacion);
        return "redirect:/asociaciones";
    }

    @GetMapping("/editar/{id}")
    public String editarAsociacion(@PathVariable Long id, Model model) {
        Asociacion asociacion = asociacionRepositorio.findById(id).orElse(null);
        model.addAttribute("asociacion", asociacion);
        return "asociaciones/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarAsociacion(@PathVariable Long id) {
        asociacionRepositorio.deleteById(id);
        return "redirect:/asociaciones";
    }
}