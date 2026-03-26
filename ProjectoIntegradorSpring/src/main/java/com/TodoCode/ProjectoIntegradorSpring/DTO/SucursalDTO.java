package com.TodoCode.ProjectoIntegradorSpring.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SucursalDTO {

    private Long id;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String telefono;
}
