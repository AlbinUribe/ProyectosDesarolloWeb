package com.empresa.sistema_inventario.controller;

import com.empresa.sistema_inventario.entity.Categoria;
import com.empresa.sistema_inventario.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.dao.DataIntegrityViolationException;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("categorias", categoriaService.obtenerTodas());
        return "categorias/lista";
    }

    @GetMapping("/nueva")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/formulario";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("categoria", categoriaService.obtenerPorId(id));
        return "categorias/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Categoria categoria, RedirectAttributes redirectAttributes) {
        boolean esNueva = categoria.getId() == null;
        categoriaService.guardar(categoria);
        redirectAttributes.addFlashAttribute("mensaje",
                esNueva ? "Categoría agregada correctamente." : "Categoría actualizada correctamente.");
        return "redirect:/categorias";
    }

@GetMapping("/eliminar/{id}")
public String eliminar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
    try {
        categoriaService.eliminar(id);
        redirectAttributes.addFlashAttribute("mensaje", "Categoría eliminada correctamente.");
    } catch (DataIntegrityViolationException e) {
        redirectAttributes.addFlashAttribute("error",
                "No se puede eliminar esta categoría porque tiene productos asociados.");
    }
    return "redirect:/categorias";
}
}