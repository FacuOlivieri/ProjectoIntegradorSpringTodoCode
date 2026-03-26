package com.TodoCode.ProjectoIntegradorSpring.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVentaDTO {

    private Long id;
    private String nombreProductoAsociado;
    private Integer cantidadProducto;
    private Double precio;
    private Double subtotal;        /// Campo calculado (cantidad * precio)
}
