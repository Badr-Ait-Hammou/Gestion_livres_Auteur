package com.example.gestion_livres.repository;
import com.example.gestion_livres.entity.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository

public interface AuteurRepository extends JpaRepository<Auteur,Integer> {
    Auteur findById(int id);
    List<Auteur> findByDateNaissance(Date dateNaissance);
    Auteur findByCin(String cin);

    ;
}
