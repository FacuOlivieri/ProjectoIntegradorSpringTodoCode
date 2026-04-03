package com.TodoCode.ProjectoIntegradorSpring.Service;

import com.TodoCode.ProjectoIntegradorSpring.DTO.DetalleVentaDTO;
import com.TodoCode.ProjectoIntegradorSpring.DTO.VentaDTO;
import com.TodoCode.ProjectoIntegradorSpring.Exception.NotFoundException;
import com.TodoCode.ProjectoIntegradorSpring.Mapper.Mapper;
import com.TodoCode.ProjectoIntegradorSpring.Model.DetalleVenta;
import com.TodoCode.ProjectoIntegradorSpring.Model.Producto;
import com.TodoCode.ProjectoIntegradorSpring.Model.Sucursal;
import com.TodoCode.ProjectoIntegradorSpring.Model.Venta;
import com.TodoCode.ProjectoIntegradorSpring.Repository.IProductoRepository;
import com.TodoCode.ProjectoIntegradorSpring.Repository.ISucursalRepository;
import com.TodoCode.ProjectoIntegradorSpring.Repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    public IVentaRepository ventaRepository;
    @Autowired
    public IProductoRepository productoRepository;
    @Autowired
    public ISucursalRepository sucursalRepository;


    @Override
    public List<VentaDTO> traerVentas() {
        return ventaRepository.findAll().stream().map(Mapper::toVentaDTO).toList();
    }

    @Override
    public VentaDTO crearVenta(VentaDTO ventaDTO) {

        //Validaciones
        if (ventaDTO == null) {throw new RuntimeException("VentaDTO es null");}
        if (ventaDTO.getNumeroSucursal() == null) {throw new RuntimeException("Debe ingresar el numero de sucursal");}
        if (ventaDTO.getDetalle() == null) {throw new RuntimeException("Debe ingresar al menos un producto");}

        //Buscamos Sucursal
        Sucursal sucursal = sucursalRepository.findById(ventaDTO.getNumeroSucursal()).orElse(null);
        if (sucursal == null) {throw new NotFoundException("Sucursal no encontrada");}


        //Creamos la Venta
        Venta venta = new Venta();
        venta.setFecha(ventaDTO.getFecha());
        venta.setEstado(ventaDTO.getEstado());
        venta.setSucursal(sucursal);
        venta.setPrecioTotalVenta(ventaDTO.getPrecioTotal());


        //Lista de DetalleVentaDTO a DetalleVenta
        List<DetalleVenta> listaDetalleVenta = new ArrayList<>();

        for (DetalleVentaDTO detalleVentaDTO : ventaDTO.getDetalle()) {
            Producto producto = productoRepository.findByNombreIgnoreCase(detalleVentaDTO.getNombreProductoAsociado()).orElse(null);
            if (producto == null) {throw new NotFoundException("Producto no encontrado: " +  detalleVentaDTO.getNombreProductoAsociado());}

            DetalleVenta detalleVenta = new DetalleVenta();
            detalleVenta.setProducto(producto);
            detalleVenta.setPrecioProducto(detalleVentaDTO.getPrecio());
            detalleVenta.setCantidadProducto(detalleVentaDTO.getCantidadProducto());
            detalleVenta.setVentaAsociada(venta);

            listaDetalleVenta.add(detalleVenta);
        }


        //Seteamos la lista de detalles venta
        venta.setDetalleDeVenta(listaDetalleVenta);

        //Guardamos en la BD
        ventaRepository.save(venta);


        return Mapper.toVentaDTO(venta);
    }

    @Override
    public VentaDTO actualizarVenta(Long id, VentaDTO  ventaModificada) {

        Venta ventaBuscada = ventaRepository.findById(id).orElseThrow(() -> new NotFoundException("VENTA no encontrada"));

        if (ventaModificada.getFecha() != null) {
            ventaBuscada.setFecha(ventaModificada.getFecha());
        }

        if (ventaModificada.getEstado() != null) {
            ventaBuscada.setEstado(ventaModificada.getEstado());
        }

        if (ventaModificada.getEstado() != null) {
            ventaBuscada.setEstado(ventaModificada.getEstado());
        }

        if (ventaModificada.getPrecioTotal() != null) {
            ventaBuscada.setPrecioTotalVenta(ventaModificada.getPrecioTotal());
        }

        if (ventaModificada.getNumeroSucursal() != null) {
            Sucursal sucursal = sucursalRepository.findById(ventaModificada.getNumeroSucursal()).orElse(null);
            if (sucursal == null) {throw new NotFoundException("Sucursal no encontrada");}
            ventaBuscada.setSucursal(sucursal);
        }

        ventaRepository.save(ventaBuscada);
        return Mapper.toVentaDTO(ventaBuscada);
    }

    @Override
    public void eliminarVenta(Long id) {
        Venta ventaAEliminar = ventaRepository.findById(id).orElseThrow(() -> new NotFoundException("VENTA no encontrada"));
        ventaRepository.delete(ventaAEliminar);
    }
}
