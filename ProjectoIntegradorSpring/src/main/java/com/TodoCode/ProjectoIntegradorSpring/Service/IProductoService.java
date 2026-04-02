package com.TodoCode.ProjectoIntegradorSpring.Service;

import com.TodoCode.ProjectoIntegradorSpring.DTO.ProductoDTO;
import com.TodoCode.ProjectoIntegradorSpring.Model.Producto;

import java.util.List;

public interface IProductoService {

    List<ProductoDTO> traerProductos();
    ProductoDTO crearProducto(Producto producto);
    ProductoDTO modificarProducto(Long idProducto, Producto producto);
    void eliminarProducto(Long idProducto);
}
