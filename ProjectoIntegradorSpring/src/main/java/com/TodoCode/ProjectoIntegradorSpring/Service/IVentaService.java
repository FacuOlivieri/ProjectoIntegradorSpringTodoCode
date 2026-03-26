package com.TodoCode.ProjectoIntegradorSpring.Service;


import com.TodoCode.ProjectoIntegradorSpring.Model.Venta;

import java.util.List;

public interface IVentaService {

    void crearVenta(Venta VentaNueva);

    Venta encontrarVenta(Long idVenta);

    List<Venta> traerVentas();

    Venta editarVenta(Venta ventaEditada);

    void eliminarVenta(Long idVenta);

}
