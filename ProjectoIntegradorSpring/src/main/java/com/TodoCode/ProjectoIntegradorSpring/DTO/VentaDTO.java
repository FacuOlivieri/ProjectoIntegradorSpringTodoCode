package com.TodoCode.ProjectoIntegradorSpring.DTO;

import com.TodoCode.ProjectoIntegradorSpring.Enums.EstadoVenta;
import com.TodoCode.ProjectoIntegradorSpring.Model.DetalleVenta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VentaDTO {

    //Detalle Venta
    private Long id;
    private LocalDate fecha;
    private EstadoVenta estado;

    //Detalle SUCURSAL
    private Long numeroSucursal;

    //Detalle DETALLE VENTA
    private List<DetalleVenta> detalle;


    private Double precioTotal;

}
