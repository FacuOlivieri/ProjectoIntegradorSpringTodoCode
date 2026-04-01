package com.TodoCode.ProjectoIntegradorSpring.Service;

import com.TodoCode.ProjectoIntegradorSpring.DTO.SucursalDTO;
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
        return null;
    }

    @Override
    public Sucursal encontrarSucursal(Long idSucursal) {
        return sucursalRepository.findById(idSucursal).orElse(null);
    }

    @Override
    public List<SucursalDTO> traerSucursales() {
        List<Sucursal> sucursales = sucursalRepository.findAll();
        List<SucursalDTO> sucursalDTOS = new ArrayList<>();

        for (Sucursal sucursal : sucursales) {
            SucursalDTO sucursalDTO = new SucursalDTO();
            sucursalDTO.setId(sucursal.getIdSucursal());
            sucursalDTO.setNombre(sucursal.getNombreSucursal());
            sucursalDTO.setDireccion(sucursal.getDireccionSucursal());
            sucursalDTO.setCiudad(sucursal.getCiudadSucursal());
            sucursalDTO.setTelefono(sucursal.getTelefonoSucursal());
            sucursalDTOS.add(sucursalDTO);
        }

        return sucursalDTOS;
    }

    @Override
    public SucursalDTO editarSucursal(Long id, SucursalDTO sucursalEditada) {
        Sucursal sucursalAEditar = this.encontrarSucursal(id);

        return null;
    }

    @Override
    public void eliminarSucursal(Long idSucursal) {

    }
}
