package com.TodoCode.ProjectoIntegradorSpring.Service;


import com.TodoCode.ProjectoIntegradorSpring.DTO.VentaDTO;
import com.TodoCode.ProjectoIntegradorSpring.Model.Venta;

import java.util.List;

public interface IVentaService {
    List<VentaDTO> traerVentas();
    VentaDTO crearVenta(Venta ventaNueva);
    VentaDTO actualizarVenta(Long id, VentaDTO ventaAActualizar);
    void eliminarVenta(Long id);
}
