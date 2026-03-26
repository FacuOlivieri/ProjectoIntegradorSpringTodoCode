package com.TodoCode.ProjectoIntegradorSpring.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Data
@Component
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSucursal;
    private String nombreSucursal;
    private String direccionSucursal;
    private String ciudadSucursal;
    private String telefonoSucursal;

    @OneToMany(mappedBy = "sucursal")
    private List<Venta> listaVentas;

    private Double ingresosSucursal;


}
