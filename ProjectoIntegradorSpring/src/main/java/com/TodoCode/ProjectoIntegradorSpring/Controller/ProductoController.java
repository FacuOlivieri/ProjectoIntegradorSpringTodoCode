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

    ///////

    /*
    Método: POST
    Path: /api/productos
    Crear un nuevo producto con nombre, precio y categoria
     */



///////
    /*
    * Método: PUT
    * Path: /api/productos/{id}
      Modificar datos de un producto en específico
     */

    ///////
    /*
     * Método: DELETE
     * Eliminar un producto
     * */



}
