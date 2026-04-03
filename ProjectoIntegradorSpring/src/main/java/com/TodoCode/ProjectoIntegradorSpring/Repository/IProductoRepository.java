package com.TodoCode.ProjectoIntegradorSpring.Repository;

import com.TodoCode.ProjectoIntegradorSpring.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {

    //Aca podriamos poner metodos personalizados, para filtrados, etc


    //Buscar producto por nombre (en realidad habria que hacerlo con por id)
    Optional<Producto> findByNombreIgnoreCase(String nombre);

}
