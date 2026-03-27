package com.TodoCode.ProjectoIntegradorSpring.Service;

import com.TodoCode.ProjectoIntegradorSpring.DTO.SucursalDTO;
import com.TodoCode.ProjectoIntegradorSpring.Model.Sucursal;
import com.TodoCode.ProjectoIntegradorSpring.Model.Venta;
import com.TodoCode.ProjectoIntegradorSpring.Repository.ISucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SucursalService implements ISucursalService {

    @Autowired
    public ISucursalRepository sucursalRepository;

    @Override
    public void crearSucursal(Sucursal sucursalNueva) {
        sucursalRepository.save(sucursalNueva);
    }

    @Override
    public Sucursal encontrarSucursal(Long idSucursal) {
        return sucursalRepository.findById(idSucursal).orElse(null);
    }

    @Override
    public List<Sucursal> traerSucursales() {
        return sucursalRepository.findAll();
    }

    @Override
    public Sucursal editarSucursal(Sucursal sucursalEditada) {
        sucursalRepository.save(sucursalEditada);
        return this.encontrarSucursal(sucursalEditada.getIdSucursal());
    }

    @Override
    public void eliminarSucursal(Long idSucursal) {
        sucursalRepository.deleteById(idSucursal);
    }

    @Override
    public SucursalDTO devolverDatosSucursalDTO(Sucursal sucursal) {
        SucursalDTO sucursalDTO = new SucursalDTO();

        sucursalDTO.setId(sucursal.getIdSucursal());
        sucursalDTO.setNombre(sucursal.getNombreSucursal());
        sucursalDTO.setDireccion(sucursal.getDireccionSucursal());
        sucursalDTO.setTelefono(sucursal.getTelefonoSucursal());
        sucursalDTO.setCiudad(sucursal.getCiudadSucursal());

        return sucursalDTO;
    }

    @Override
    public Double calcularIngresoSucursalConcreta(Long idSucursal) {
        Sucursal sucursalACalcular = sucursalRepository.findById(idSucursal).orElse(null);
        Double ingresosSucursalConcreta = 0.0;

        if (sucursalACalcular != null) {
            List<Venta> ventasRealizadas = sucursalACalcular.getListaVentas();
            for (Venta venta : ventasRealizadas) {
                ingresosSucursalConcreta += venta.getPrecioTotalVenta();
            }
        }

        return ingresosSucursalConcreta;
    }


    @Override
    public Double calcularIngresoTotalSupermercado() {
        Double ingresoTotal = 0.0;
        List<Sucursal> listaSucursales = this.traerSucursales();

        for (Sucursal sucursal : listaSucursales) {
            ingresoTotal += this.calcularIngresoSucursalConcreta(sucursal.getIdSucursal());
        }

        return ingresoTotal;
    }
}
