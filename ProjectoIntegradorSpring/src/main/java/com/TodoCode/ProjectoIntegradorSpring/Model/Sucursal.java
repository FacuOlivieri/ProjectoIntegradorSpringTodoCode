package com.TodoCode.ProjectoIntegradorSpring.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Data
@Component
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSucursal;
    private String nombreSucursal;
    private String direccionSucursal;
    private String ciudadSucursal;
    private String telefonoSucursal;
    private Double ingresosSucursal;

    /*
     * Puedes hacer la relación bidireccional con List si quieres
     */

    @OneToMany(mappedBy = "sucursal")
    private List<Venta> listaVentas;


}
