package com.TodoCode.ProjectoIntegradorSpring.Controller;

import com.TodoCode.ProjectoIntegradorSpring.DTO.ProductoDTO;
import com.TodoCode.ProjectoIntegradorSpring.Model.Producto;
import com.TodoCode.ProjectoIntegradorSpring.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<ProductoDTO>> getProductos() {
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

        return ResponseEntity.ok(listaDeProductos);

    }

    ///////

    /*
    Metodo: POST
    Path: /api/productos
    Crear un nuevo producto con nombre, precio y categoria
     */

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        productoService.crearProducto(producto);
        return ResponseEntity.ok(producto);
    }

///////
    /*
    * Metodo: PUT
    * Path: /api/productos/{id}
      Modificar datos de un producto en especifico
     */

    @PutMapping
    public ResponseEntity<Producto> actualizarProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.editarProducto(producto));
    }
    ///////
    /*
     * Metodo: DELETE
     * Eliminar un producto
     * */

    @DeleteMapping
    public ResponseEntity<String> eliminarProducto(@RequestBody Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.ok("Producto eliminado");
    }

}
