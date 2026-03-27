package com.TodoCode.ProjectoIntegradorSpring.Service;

import com.TodoCode.ProjectoIntegradorSpring.DTO.SucursalDTO;
import com.TodoCode.ProjectoIntegradorSpring.Model.Sucursal;

import java.util.List;

public interface ISucursalService {

    void crearSucursal(Sucursal sucursalNueva);

    Sucursal encontrarSucursal(Long idSucursal);

    List<Sucursal> traerSucursales();

    Sucursal editarSucursal(Sucursal sucursalEditada);

    void eliminarSucursal(Long idSucursal);

    SucursalDTO devolverDatosSucursalDTO(Sucursal sucursal);

    Double calcularIngresoSucursalConcreta(Long idSucursal);

    Double calcularIngresoTotalSupermercado();
}
