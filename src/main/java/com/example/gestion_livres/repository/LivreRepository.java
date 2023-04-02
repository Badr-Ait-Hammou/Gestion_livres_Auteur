package com.example.gestion_livres.repository;

import com.example.gestion_livres.entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface LivreRepository extends JpaRepository<Livre,Integer> {
  Livre findById(int id);
  List<Livre> findBetweenDates(Date datest, Date datefi);
  Livre findByIsbn(String isbn);
}
