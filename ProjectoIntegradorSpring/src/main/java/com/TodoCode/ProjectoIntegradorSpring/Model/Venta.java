package com.TodoCode.ProjectoIntegradorSpring.Model;

import com.TodoCode.ProjectoIntegradorSpring.Enums.EstadoVenta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Entity
@Component
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;
    private LocalDate fecha;
    private EstadoVenta estado;

    @ManyToOne
    @JoinColumn(name = "idSucursal")
    private Sucursal sucursal;
    private List<Producto> listaProductosAVender;



}
