package com.example.gestion_livres.service;

import com.example.gestion_livres.dao.IDAO;
import com.example.gestion_livres.entity.Auteur;
import com.example.gestion_livres.repository.AuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AuteurService implements IDAO<Auteur> {

    @Autowired
    private AuteurRepository auteurRepository;


    public List<Auteur> findByDateNai(Date dateNaissance) {
        return auteurRepository.findByDateNai(dateNaissance);
    }

    public Auteur findByCin(String cin) {
        return auteurRepository.findByCin(cin);
    }



    @Override
    public Auteur save(Auteur auteur) {
        return auteurRepository.save(auteur);
    }


    @Override
    public List<Auteur> findAll() {
        return auteurRepository.findAll();
    }

    @Override
    public Auteur findById(int id) {
        return auteurRepository.findById(id);
    }




    public void update(Integer id, Auteur auteurinfo) {
    Auteur auteur=auteurRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("auteur not found with id " + id));
    auteur.setEmail(auteurinfo.getEmail());
    auteur.setLivreList(auteurinfo.getLivreList());
    auteurRepository.save(auteur);
    }


    public void delete(int id){
    Auteur auteur=auteurRepository.findById(id);
    auteurRepository.delete(auteur);
    }
}
