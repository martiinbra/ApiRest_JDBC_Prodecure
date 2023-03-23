package com.example.demo.models.repository;

import com.example.demo.models.entity.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Integer>{

    @Query(value = "{call lista_procedure}", nativeQuery = true)
    List<Auto> listaProcedure();

    @Query(value = "{call marca_procedure(:marcaIn)}", nativeQuery = true)
    List<Auto> marcaProcedure(@Param("marcaIn") String marcaIn);

    @Query(value = "{call id_procedure(:idIn)}", nativeQuery = true)
    Optional<Auto> idProcedure(@Param("idIn") int idIn);
}
