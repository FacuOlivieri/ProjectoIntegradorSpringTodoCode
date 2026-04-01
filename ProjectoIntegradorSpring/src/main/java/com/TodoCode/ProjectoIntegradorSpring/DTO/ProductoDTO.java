package com.TodoCode.ProjectoIntegradorSpring.DTO;

import com.TodoCode.ProjectoIntegradorSpring.Model.Producto;
import lombok.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoDTO {

    private Long id;
    private String nombre;
    private String categoria;
    private String marca;
    private Double subtotal;
    private Integer cantidad;


}
