package com.TodoCode.ProjectoIntegradorSpring.Repository;

import com.TodoCode.ProjectoIntegradorSpring.Model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta,Long> {
}
