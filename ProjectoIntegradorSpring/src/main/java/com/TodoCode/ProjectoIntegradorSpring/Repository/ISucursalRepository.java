package com.TodoCode.ProjectoIntegradorSpring.Repository;

import com.TodoCode.ProjectoIntegradorSpring.Model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISucursalRepository extends JpaRepository<Sucursal, Long> {
}
