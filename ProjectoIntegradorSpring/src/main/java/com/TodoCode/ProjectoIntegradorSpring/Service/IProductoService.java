package com.TodoCode.ProjectoIntegradorSpring.Service;

import com.TodoCode.ProjectoIntegradorSpring.Model.Producto;

import java.util.List;

public interface IProductoService {

    void crearProducto(Producto productoNuevo);

    Producto encontrarProducto(Long idProducto);

    List<Producto> traerListaProductos();

    Producto editarProducto(Producto productoEditado);

    void eliminarProducto(Long idProducto);

}
