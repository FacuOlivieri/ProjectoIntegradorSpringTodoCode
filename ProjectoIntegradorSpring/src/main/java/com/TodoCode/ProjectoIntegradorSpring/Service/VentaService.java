package com.TodoCode.ProjectoIntegradorSpring.Service;

import com.TodoCode.ProjectoIntegradorSpring.DTO.VentaDTO;
import com.TodoCode.ProjectoIntegradorSpring.Exception.NotFoundException;
import com.TodoCode.ProjectoIntegradorSpring.Mapper.Mapper;
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
        return ventaRepository.findAll().stream().map(Mapper::toVentaDTO).toList();
    }

    @Override
    public VentaDTO crearVenta(Venta venta) {
        Venta ventaNueva = ventaRepository.save(venta);
        return Mapper.toVentaDTO(ventaNueva);
    }

    @Override
    public VentaDTO actualizarVenta(Long id, VentaDTO  ventaAActualizar) {
        Venta ventaBuscada = ventaRepository.findById(id).orElseThrow(() -> new NotFoundException("VENTA no encontrada"));

       ventaBuscada.setFecha(ventaAActualizar.getFecha());
       ventaBuscada.setEstado(ventaAActualizar.getEstado());
       ventaBuscada.setSucursal();

        return null;
    }

    @Override
    public void eliminarVenta(Long id) {

    }
}
