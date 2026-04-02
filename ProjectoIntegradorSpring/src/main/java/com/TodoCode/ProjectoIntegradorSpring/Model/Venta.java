package com.TodoCode.ProjectoIntegradorSpring.Model;

import com.TodoCode.ProjectoIntegradorSpring.Enums.EstadoVenta;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Component
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;
    private LocalDate fecha;
    private EstadoVenta estado;
    private Double precioTotalVenta;

    @ManyToOne
    @JoinColumn(name = "idSucursal")
    private Sucursal sucursal;

    /*
     * Puedes hacer la relación bidireccional con List si quieres
     */


    @OneToMany(mappedBy = "ventaAsociada")
    private List<DetalleVenta> detalleDeVenta = new ArrayList<>();
    //Con esta bi direccionalidad, no hace falta hacer el Repository de DetalleVenta



}
