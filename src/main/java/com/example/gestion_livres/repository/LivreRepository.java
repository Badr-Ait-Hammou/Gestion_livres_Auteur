package com.example.gestion_livres.repository;

import com.example.gestion_livres.entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository

public interface LivreRepository extends JpaRepository<Livre,Integer> {
  Livre findById(int id);
  List<Livre> findByDateEditionBetween(Date dateStart,Date dateEnd);
  Livre findByIsbn(String isbn);


}
