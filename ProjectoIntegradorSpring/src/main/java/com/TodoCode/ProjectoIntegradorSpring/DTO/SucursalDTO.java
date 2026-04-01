package com.TodoCode.ProjectoIntegradorSpring.DTO;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SucursalDTO {

    private Long id;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String telefono;
}
