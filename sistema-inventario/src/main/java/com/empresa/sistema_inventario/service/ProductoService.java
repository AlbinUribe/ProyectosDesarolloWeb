package com.empresa.sistema_inventario.service;

import com.empresa.sistema_inventario.entity.Producto;
import java.util.List;

public interface ProductoService {
    List<Producto> obtenerTodos();
    Producto obtenerPorId(Long id);
    Producto guardar(Producto producto);
    void eliminar(Long id);
}