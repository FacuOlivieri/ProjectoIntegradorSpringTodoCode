package com.TodoCode.ProjectoIntegradorSpring.Service;

import com.TodoCode.ProjectoIntegradorSpring.DTO.VentaDTO;
import com.TodoCode.ProjectoIntegradorSpring.Model.Venta;
import com.TodoCode.ProjectoIntegradorSpring.Repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    public IVentaRepository ventaRepository;


    @Override
    public List<VentaDTO> traerVentas() {
        return List.of();
    }

    @Override
    public VentaDTO crearVenta(VentaDTO ventaNueva) {
        return null;
    }

    @Override
    public VentaDTO actualizarVenta(Long id, VentaDTO ventaAActualizar) {
        return null;
    }

    @Override
    public void eliminarVenta(Long id) {

    }
}
