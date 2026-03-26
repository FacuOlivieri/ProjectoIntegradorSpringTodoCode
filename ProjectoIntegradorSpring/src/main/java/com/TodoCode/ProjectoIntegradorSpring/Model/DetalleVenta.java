package com.TodoCode.ProjectoIntegradorSpring.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Data
@Component
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor

    /*
     Es cada renglón de la Factura
     */

public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleVenta;

    @ManyToOne
    @JoinColumn(name = "idVenta")
    private Venta ventaAsociada;

    /*
     * Puedes hacer la relación bidireccional con List si quieres
     */

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    private Integer cantidadProducto;
    private Double precioUnitarioProducto;

}
