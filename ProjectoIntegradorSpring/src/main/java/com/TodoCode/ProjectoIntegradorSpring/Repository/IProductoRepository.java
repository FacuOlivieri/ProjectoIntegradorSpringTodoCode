package com.TodoCode.ProjectoIntegradorSpring.Repository;

import com.TodoCode.ProjectoIntegradorSpring.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {
}
