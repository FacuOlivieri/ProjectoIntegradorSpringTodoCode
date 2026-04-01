package com.TodoCode.ProjectoIntegradorSpring.DTO;

import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleVentaDTO {

    private Long id;
    private String nombreProductoAsociado;
    private Integer cantidadProducto;
    private Double precio;
    private Double subtotal;

}
