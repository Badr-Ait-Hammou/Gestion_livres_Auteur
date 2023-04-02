package com.example.gestion_livres.repository;

import com.example.gestion_livres.entity.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AuteurRepository extends JpaRepository<Auteur,Integer> {
    Auteur findById(int id);
    List<Auteur> findByDateNai(Date dateNaissance);
    Auteur findByCin(String cin);
}
