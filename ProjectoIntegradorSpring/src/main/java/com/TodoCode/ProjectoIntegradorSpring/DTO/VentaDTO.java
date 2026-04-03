package com.TodoCode.ProjectoIntegradorSpring.DTO;

import com.TodoCode.ProjectoIntegradorSpring.Enums.EstadoVenta;
import com.TodoCode.ProjectoIntegradorSpring.Model.DetalleVenta;
import com.TodoCode.ProjectoIntegradorSpring.Model.Venta;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VentaDTO {

    //Detalle Venta
    private Long id;
    private LocalDate fecha;
    private EstadoVenta estado;
    private Long numeroSucursal;            //Detalle SUCURSAL
    private List<DetalleVentaDTO> detalle;  //Detalle DETALLE VENTA
    private Double precioTotal;


    public void calcularTotal(List<DetalleVentaDTO> listaItems){
        for (DetalleVentaDTO item: listaItems){
            precioTotal += item.getSubtotal();
        }
    }

/*    public void asignarValoresVentaDTO(VentaDTO ventaDTO, Venta ventaAsociada){


        ventaDTO.setId(ventaAsociada.getIdVenta());
        ventaDTO.setFecha(ventaAsociada.getFecha());
        ventaDTO.setEstado(ventaAsociada.getEstado());
        ventaDTO.setNumeroSucursal(ventaAsociada.getSucursal().getIdSucursal());

        if (ventaAsociada.getDetalleDeVenta() != null){
            for (DetalleVenta detalleVenta : ventaAsociada.getDetalleDeVenta()) {
                DetalleVentaDTO detalleVentaDTO = new DetalleVentaDTO();
                detalleVentaDTO.setId(detalleVenta.getIdDetalleVenta());
                detalleVentaDTO.setNombreProductoAsociado(detalleVenta.getProducto().getNombreProducto());
                detalleVentaDTO.setCantidadProducto(detalleVenta.getCantidadProducto());
                detalleVentaDTO.setPrecio(detalleVenta.getPrecioProducto());
                detalleVentaDTO.calcularSubtotal();
                detalle.add(detalleVentaDTO);
            }

            this.calcularTotal(detalle);
        }




    }*/
}
