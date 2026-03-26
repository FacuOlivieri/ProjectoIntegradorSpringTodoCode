package com.TodoCode.ProjectoIntegradorSpring.Service;

import com.TodoCode.ProjectoIntegradorSpring.Model.Sucursal;
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
}
