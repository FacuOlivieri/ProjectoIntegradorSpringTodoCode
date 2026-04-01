package com.TodoCode.ProjectoIntegradorSpring.Service;

import com.TodoCode.ProjectoIntegradorSpring.DTO.ProductoDTO;
import com.TodoCode.ProjectoIntegradorSpring.Model.Producto;

import java.util.List;

public interface IProductoService {

    List<ProductoDTO> traerProductos();
    ProductoDTO crearProducto(ProductoDTO productoDTO);
    ProductoDTO modificarProducto(Long idProducto, ProductoDTO productoDTO);
    void eliminarProducto(Long idProducto);
}
