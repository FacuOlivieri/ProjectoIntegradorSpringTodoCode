package com.TodoCode.ProjectoIntegradorSpring.Service;

import com.TodoCode.ProjectoIntegradorSpring.DTO.SucursalDTO;
import com.TodoCode.ProjectoIntegradorSpring.Model.Sucursal;

import java.util.List;

public interface ISucursalService {

    SucursalDTO crearSucursal(SucursalDTO sucursalNueva);
    Sucursal encontrarSucursal(Long idSucursal);
    List<SucursalDTO> traerSucursales();
    SucursalDTO editarSucursal(Long id, SucursalDTO sucursalEditada);
    void eliminarSucursal(Long idSucursal);



    //Double calcularIngresoSucursalConcreta(Long idSucursal);

    //Double calcularIngresoTotalSupermercado();
}
