package com.alg.proyectoLibreria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import com.alg.proyectoLibreria.domain.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
        
    @Query("from Libro l where l.nombre like %?1% ") // este usando SpringData
    List<Libro> buscar(String nombre);
    
    List<Libro> findByNombreContaining(String nombre);

}
