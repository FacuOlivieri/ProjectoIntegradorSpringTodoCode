package com.TodoCode.ProjectoIntegradorSpring.Mapper;




/*
    En esta clase, realizaremos los correspondientes mapeos para pasar los datos de las entidadades
    a los objetosDTO para mostrarlos por pantalla a traves del uso de streams() de la programacion funcional
 */


import com.TodoCode.ProjectoIntegradorSpring.DTO.DetalleVentaDTO;
import com.TodoCode.ProjectoIntegradorSpring.DTO.ProductoDTO;
import com.TodoCode.ProjectoIntegradorSpring.DTO.SucursalDTO;
import com.TodoCode.ProjectoIntegradorSpring.DTO.VentaDTO;
import com.TodoCode.ProjectoIntegradorSpring.Model.DetalleVenta;
import com.TodoCode.ProjectoIntegradorSpring.Model.Producto;
import com.TodoCode.ProjectoIntegradorSpring.Model.Sucursal;
import com.TodoCode.ProjectoIntegradorSpring.Model.Venta;

import java.util.stream.Collectors;

public class Mapper {

    //Mapeo Producto a ProductoDTO
    public static ProductoDTO toProductoDTO(Producto producto) {
        if (producto == null) {return null;}

        return ProductoDTO.builder()
                .id(producto.getIdProducto())
                .nombre(producto.getNombreProducto())
                .categoria(producto.getCategoriaProducto())
                .marca(producto.getMarcaProducto())
                .subtotal(producto.getPrecioProducto())
                .cantidad(producto.getCantidadProducto())
                .build();

        /*
            Este choclo arma el productoDTO a devolver, y luego en el service usamos stream con referencia a metodo
            para devolver el objeto creado
        */
    }


    //Mapeo de Venta a VentaDTO
    public static VentaDTO toVentaDTO(Venta venta) {
        if (venta == null) {return null;}

        var detalle = venta.getDetalleDeVenta().stream().map(detail ->
                DetalleVentaDTO.builder()
                        .id(detail.getProducto().getIdProducto())
                        .nombreProductoAsociado(detail.getProducto().getNombreProducto())
                        .cantidadProducto(detail.getProducto().getCantidadProducto())
                        .precio(detail.getPrecioProducto())
                        .subtotal(detail.getPrecioProducto() * detail.getPrecioProducto())
                        .build()
        ).toList();


        var total = detalle.stream()
                .map(DetalleVentaDTO::getSubtotal)
                .reduce(0.0, Double::sum);
                //Para Doubles e Integers (BigNumber es diferente), se suma desde el 0 y va sumando cada detalle creado antes

        return VentaDTO.builder()
                .id(venta.getIdVenta())
                .fecha(venta.getFecha())
                .estado(venta.getEstado())
                .numeroSucursal(venta.getSucursal().getIdSucursal())
                .detalle(detalle)
                .precioTotal(total)
                .build();

    }

    //Mapeo de Sucursal a SucursalDTO
    public static SucursalDTO toSucursalDTO(Sucursal sucursal) {
        if (sucursal == null) {return null;}

        return SucursalDTO.builder()
                .id(sucursal.getIdSucursal())
                .nombre(sucursal.getNombreSucursal())
                .direccion(sucursal.getDireccionSucursal())
                .ciudad(sucursal.getCiudadSucursal())
                .telefono(sucursal.getTelefonoSucursal())
                .build();

    }





}
