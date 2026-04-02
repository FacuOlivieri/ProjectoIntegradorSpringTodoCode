package com.TodoCode.ProjectoIntegradorSpring.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.stereotype.Component;

@Entity
@Data
@RequiredArgsConstructor
@Component
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
    private String nombreProducto;
    private String categoriaProducto;
    private String marcaProducto;       //En el futuro, ¿Marca como nueva Entidad?
    private String descripcionProducto;
    private Double precioProducto;
    private Integer cantidadProducto;
    private Integer stockProducto;

}
