package com.empresa.sistema_inventario.service;

import com.empresa.sistema_inventario.entity.Categoria;
import java.util.List;

public interface CategoriaService {
    List<Categoria> obtenerTodas();
    Categoria obtenerPorId(Long id);
    Categoria guardar(Categoria categoria);
    void eliminar(Long id);
}