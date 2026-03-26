package com.TodoCode.ProjectoIntegradorSpring.Service;

import com.TodoCode.ProjectoIntegradorSpring.Model.Producto;
import com.TodoCode.ProjectoIntegradorSpring.Repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    public IProductoRepository productoRepository;

    @Override
    public void crearProducto(Producto productoNuevo) {
        productoRepository.save(productoNuevo);
    }

    @Override
    public Producto encontrarProducto(Long idProducto) {
        return productoRepository.findById(idProducto).orElse(null);
    }

    @Override
    public List<Producto> traerListaProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto editarProducto(Producto productoEditado) {
        productoRepository.save(productoEditado);
        return this.encontrarProducto(productoEditado.getIdProducto());
    }

    @Override
    public void eliminarProducto(Long idProducto) {
        productoRepository.deleteById(idProducto);
    }
}
