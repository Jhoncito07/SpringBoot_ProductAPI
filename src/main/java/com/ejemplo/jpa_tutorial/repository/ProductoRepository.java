package com.ejemplo.jpa_tutorial.repository;

import com.ejemplo.jpa_tutorial.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Aquí pueden añadirse métodos adicionales de consulta si es necesario
    List<Producto> findByNombreContaining(String nombre);
    List<Producto> findByPrecioBetween(Double precioMin, Double precioMax);
    
}
