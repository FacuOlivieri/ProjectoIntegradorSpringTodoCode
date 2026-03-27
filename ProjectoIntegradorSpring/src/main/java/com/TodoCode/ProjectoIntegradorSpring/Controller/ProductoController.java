package com.TodoCode.ProjectoIntegradorSpring.Controller;

import com.TodoCode.ProjectoIntegradorSpring.DTO.ProductoDTO;
import com.TodoCode.ProjectoIntegradorSpring.Model.Producto;
import com.TodoCode.ProjectoIntegradorSpring.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    /*
    Método: GET
    Path: /api/productos
    Listar productos registrados
     */
    @GetMapping()
    public List<ProductoDTO> getProductos() {
        List<Producto> listadoCompleto = productoService.traerListaProductos();
        List<ProductoDTO> listaDeProductos = new ArrayList<>();

        for (Producto productoDatosCompletos : listadoCompleto) {
            ProductoDTO producto = new ProductoDTO();
            producto.setId(productoDatosCompletos.getIdProducto());
            producto.setNombre(productoDatosCompletos.getNombreProducto());
            producto.setCategoria(productoDatosCompletos.getCategoriaProducto());
            producto.setMarca(productoDatosCompletos.getMarcaProducto());
            producto.setSubtotal(productoDatosCompletos.getPrecioProducto());
            producto.setCantidad(productoDatosCompletos.getCantidadProducto());

            listaDeProductos.add(producto);
        }

        return listaDeProductos;

    }

    ///////

    /*
    Metodo: POST
    Path: /api/productos
    Crear un nuevo producto con nombre, precio y categoria
     */
///////
    /*
    * Metodo: PUT
    * Path: /api/productos/{id}
      Modificar datos de un producto en especifico
     */
    ///////
    /*
     * Metodo: DELETE
     * Eliminar un producto
     * */

}
