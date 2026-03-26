package com.TodoCode.ProjectoIntegradorSpring.Service;

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
    public void crearVenta(Venta ventaNueva) {
        ventaRepository.save(ventaNueva);
    }

    @Override
    public Venta encontrarVenta(Long idVenta) {
        return ventaRepository.findById(idVenta).orElse(null);
    }

    @Override
    public List<Venta> traerVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta editarVenta(Venta ventaEditada) {
        ventaRepository.save(ventaEditada);
        return this.encontrarVenta(ventaEditada.getIdVenta());
    }

    @Override
    public void eliminarVenta(Long idVenta) {
        ventaRepository.deleteById(idVenta);
    }
}
