package com.TodoCode.ProjectoIntegradorSpring.Service;

import com.TodoCode.ProjectoIntegradorSpring.DTO.ProductoDTO;
import com.TodoCode.ProjectoIntegradorSpring.Exception.NotFoundException;
import com.TodoCode.ProjectoIntegradorSpring.Mapper.Mapper;
import com.TodoCode.ProjectoIntegradorSpring.Model.Producto;
import com.TodoCode.ProjectoIntegradorSpring.Repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductoService implements IProductoService{

    @Autowired
    public IProductoRepository productoRepository;


    @Override
    public List<ProductoDTO> traerProductos() {
        return productoRepository.findAll().stream().map(Mapper::toProductoDTO).toList();
    }

    @Override
    public ProductoDTO crearProducto(Producto producto) {
        Producto product = Producto.builder()
                .nombreProducto(producto.getNombreProducto())
                .categoriaProducto(producto.getCategoriaProducto())
                .marcaProducto(producto.getMarcaProducto())
                .descripcionProducto(producto.getDescripcionProducto())
                .cantidadProducto(producto.getCantidadProducto())
                .precioProducto(producto.getPrecioProducto())
                .stockProducto(producto.getStockProducto())
                .build();

        return Mapper.toProductoDTO(productoRepository.save(product));
    }

    @Override
    public ProductoDTO modificarProducto(Long idProducto, Producto producto) {
        Producto productoBuscado = productoRepository.findById(idProducto)
                .orElseThrow(() -> new NotFoundException("Producto NO ENCONTRADO"));  //Uso de Excepciones

        productoBuscado.setNombreProducto(producto.getNombreProducto());
        productoBuscado.setCategoriaProducto(producto.getCategoriaProducto());
        productoBuscado.setMarcaProducto(producto.getMarcaProducto());
        productoBuscado.setDescripcionProducto(producto.getDescripcionProducto());
        productoBuscado.setPrecioProducto(producto.getPrecioProducto());
        productoBuscado.setCantidadProducto(producto.getCantidadProducto());
        productoBuscado.setStockProducto(producto.getStockProducto());




        return Mapper.toProductoDTO(productoBuscado);


    }

    @Override
    public void eliminarProducto(Long idProducto) {

        //Usualmente no se eliminan cosas de la BD, se lo marca como "NO DISPONIBLE". En este caso SI lo vamos a hacer

        if (!productoRepository.existsById(idProducto)){
            throw new NotFoundException("Producto NO ENCONTRADO para eliminar");
        }
        productoRepository.deleteById(idProducto);
    }
}
