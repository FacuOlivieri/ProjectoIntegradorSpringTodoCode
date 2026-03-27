package com.TodoCode.ProjectoIntegradorSpring.Controller;

import com.TodoCode.ProjectoIntegradorSpring.DTO.SucursalDTO;
import com.TodoCode.ProjectoIntegradorSpring.Model.Sucursal;
import com.TodoCode.ProjectoIntegradorSpring.Service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sucursal")
public class SucursalController {

    @Autowired
    public SucursalService sucursalService;

    @GetMapping
    public ResponseEntity<List<SucursalDTO>> verListaDeSucursales() {
        List<Sucursal> sucursales = sucursalService.traerSucursales();
        List<SucursalDTO> sucursalesDTOS = new ArrayList<>();

        for(Sucursal sucursal: sucursales) {
            SucursalDTO sucursalDTO = sucursalService.devolverDatosSucursalDTO(sucursal);
            sucursalesDTOS.add(sucursalDTO);
        }

        return ResponseEntity.ok(sucursalesDTOS);
    }

    @GetMapping("/verSucursal/{id}")
    public ResponseEntity<SucursalDTO> verSucursalPorId(@PathVariable Long id) {
        Sucursal sucursal = sucursalService.encontrarSucursal(id);

        return ResponseEntity.ok(sucursalService.devolverDatosSucursalDTO(sucursal));
    }

    @PostMapping
    public ResponseEntity<SucursalDTO> crearSucursal(@RequestBody Sucursal sucursal) {
        sucursalService.crearSucursal(sucursal);

        //Aca chequea que este y devuelve DTO
        List<Sucursal> sucursales = sucursalService.traerSucursales();
        for(Sucursal suc: sucursales) {
            if (suc.getIdSucursal().equals(sucursal.getIdSucursal())) {
                return ResponseEntity.ok(sucursalService.devolverDatosSucursalDTO(sucursal));
            }
        }
        return ResponseEntity.notFound().build();
    }


    @PutMapping
    public ResponseEntity<Sucursal> actualizarSucursal(@RequestBody Sucursal sucursal) {
        return ResponseEntity.ok(sucursalService.editarSucursal(sucursal));
    }

    @DeleteMapping
    public ResponseEntity<String> eliminarSucursal(@PathVariable Long id) {
        sucursalService.eliminarSucursal(id);
        return ResponseEntity.ok("Sucursal eliminada con éxito");
    }

    @GetMapping("/traerIngresosSucursal/{id}")
    public ResponseEntity<String> traerIngresoSucursalConcreta(@PathVariable Long id) {
        Sucursal sucursal = sucursalService.encontrarSucursal(id);
        Double ingresos = sucursalService.calcularIngresoSucursalConcreta(id);

        return ResponseEntity.ok("Sucursal: " + sucursal.getNombreSucursal() + " - Ingresos: " + ingresos);
    }

    @GetMapping("/traerIngresoTotal")
    public ResponseEntity<List<String>> traerIngresoTotal() {

        List<String> ingresos = new ArrayList<>();
        List<Sucursal> sucursales = sucursalService.traerSucursales();
        for(Sucursal suc: sucursales) {
            ingresos.add(suc.getNombreSucursal() + ": " + suc.getIngresosSucursal() + "\n");
        }

        ingresos.add( "-----------------\n" +"INGRESO TOTAL: " + sucursalService.calcularIngresoTotalSupermercado());

        return ResponseEntity.ok(ingresos);
    }


    //////// Filtrar PRODUCTOS POR SUCURSAL??

}
