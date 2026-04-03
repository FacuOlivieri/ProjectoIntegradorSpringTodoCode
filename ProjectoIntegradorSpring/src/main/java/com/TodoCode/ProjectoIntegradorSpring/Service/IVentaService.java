package com.TodoCode.ProjectoIntegradorSpring.Service;


import com.TodoCode.ProjectoIntegradorSpring.DTO.VentaDTO;

import java.util.List;

public interface IVentaService {
    List<VentaDTO> traerVentas();
    VentaDTO crearVenta(VentaDTO ventaNueva);
    VentaDTO actualizarVenta(Long id, VentaDTO ventaAActualizar);
    void eliminarVenta(Long id);
}
