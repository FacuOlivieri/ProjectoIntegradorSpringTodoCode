package com.TodoCode.ProjectoIntegradorSpring.Service;

import com.TodoCode.ProjectoIntegradorSpring.DTO.SucursalDTO;
import com.TodoCode.ProjectoIntegradorSpring.Exception.NotFoundException;
import com.TodoCode.ProjectoIntegradorSpring.Mapper.Mapper;
import com.TodoCode.ProjectoIntegradorSpring.Model.Sucursal;
import com.TodoCode.ProjectoIntegradorSpring.Model.Venta;
import com.TodoCode.ProjectoIntegradorSpring.Repository.ISucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SucursalService implements ISucursalService {

    @Autowired
    public ISucursalRepository sucursalRepository;


    @Override
    public SucursalDTO crearSucursal(SucursalDTO sucursalNueva) {
        Sucursal sucursal = Sucursal.builder()
                .idSucursal(sucursalNueva.getId())
                .nombreSucursal(sucursalNueva.getNombre())
                .direccionSucursal(sucursalNueva.getDireccion())
                .ciudadSucursal(sucursalNueva.getCiudad())
                .telefonoSucursal(sucursalNueva.getTelefono())
                .ingresosSucursal(0D)
                .build();

        return Mapper.toSucursalDTO(sucursalRepository.save(sucursal));
    }

    @Override
    public Sucursal encontrarSucursal(Long idSucursal) {
        return sucursalRepository.findById(idSucursal).orElseThrow(() -> new NotFoundException("Sucursal no encontrada"));
    }

    @Override
    public List<SucursalDTO> traerSucursales() {
        return sucursalRepository.findAll().stream()
                .map(Mapper::toSucursalDTO)
                .toList();
    }

    @Override
    public SucursalDTO editarSucursal(Long id, SucursalDTO sucursalEditada) {
        Sucursal sucursalAEditar = this.encontrarSucursal(id);
        sucursalAEditar.setNombreSucursal(sucursalEditada.getNombre());
        sucursalAEditar.setDireccionSucursal(sucursalEditada.getDireccion());
        sucursalAEditar.setCiudadSucursal(sucursalEditada.getCiudad());
        sucursalAEditar.setTelefonoSucursal(sucursalEditada.getTelefono());

        return Mapper.toSucursalDTO(sucursalRepository.save(sucursalAEditar));
    }

    @Override
    public void eliminarSucursal(Long idSucursal) {
        if (!sucursalRepository.existsById(idSucursal)) {
            throw new NotFoundException("Sucursal no encontrada");
        }
        sucursalRepository.deleteById(idSucursal);
    }
}
