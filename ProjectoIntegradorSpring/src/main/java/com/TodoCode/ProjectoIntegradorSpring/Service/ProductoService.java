package com.TodoCode.ProjectoIntegradorSpring.Service;

import com.TodoCode.ProjectoIntegradorSpring.DTO.ProductoDTO;
import com.TodoCode.ProjectoIntegradorSpring.Mapper.Mapper;
import com.TodoCode.ProjectoIntegradorSpring.Model.Producto;
import com.TodoCode.ProjectoIntegradorSpring.Repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    public IProductoRepository productoRepository;


    @Override
    public List<ProductoDTO> traerProductos() {
        return productoRepository.findAll().stream().map(Mapper::toProductoDTO).toList();
    }

    @Override
    public ProductoDTO crearProducto(ProductoDTO productoDTO) {
        return
    }

    @Override
    public ProductoDTO modificarProducto(Long idProducto, ProductoDTO productoDTO) {
        return null;
    }

    @Override
    public void eliminarProducto(Long idProducto) {

    }
}
