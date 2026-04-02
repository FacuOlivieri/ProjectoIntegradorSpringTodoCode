package com.TodoCode.ProjectoIntegradorSpring.Exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String mensaje) {
        super(mensaje);
    }
}
