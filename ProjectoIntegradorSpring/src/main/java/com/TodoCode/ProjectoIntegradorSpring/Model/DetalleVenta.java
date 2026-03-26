package com.TodoCode.ProjectoIntegradorSpring.Model;

import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.stereotype.Component;

@Entity
@Data
@Component
public class DetalleVenta {

    private Double precioTotal;

}
