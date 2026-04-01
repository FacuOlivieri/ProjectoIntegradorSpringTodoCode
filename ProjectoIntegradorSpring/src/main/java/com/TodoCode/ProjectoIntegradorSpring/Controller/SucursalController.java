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



}
