package com.example.gestion_livres.dao;

import com.example.gestion_livres.entity.Auteur;
import com.example.gestion_livres.entity.Livre;

import java.util.List;

public interface IDAO<T>{
    T save (T o);
    List<T> findAll();
    T findById(int id);
    //void update(T o);

   // void update(Integer id, Auteur auteurinfo);

   // void update(Integer id, Livre livreinfo);

   // void delete(T o);

}
