package com.example.gestion_livres.service;

import com.example.gestion_livres.dao.IDAO;
import com.example.gestion_livres.entity.Auteur;
import com.example.gestion_livres.entity.Livre;
import com.example.gestion_livres.repository.AuteurRepository;
import com.example.gestion_livres.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

@Service
public class LivreService implements IDAO<Livre> {



    @Autowired
    private LivreRepository livreRepository;

    @Autowired
    private AuteurRepository auteurRepository;

    public List<Livre> findByDateEditionBetween(Date dateStart, Date dateEnd) {
        return livreRepository.findByDateEditionBetween(dateStart, dateEnd);
    }

    /*public List<Livre> findBetweenDates(  Date datest,   Date datefi) {
        return livreRepository.findBetweenDates(datest, datefi);
    }*/


    public Livre findByIsbn(String isbn) {
        return livreRepository.findByIsbn(isbn);
    }



    @Override
    public Livre save(Livre livre) {
        return livreRepository.save(livre);
    }

    @Override
    public List<Livre> findAll() {
        return livreRepository.findAll();
    }

    @Override
    public Livre findById(int id) {
        return livreRepository.findById(id);
    }


    public void update(Integer id, Livre livreinfo) {
        Livre  livre=livreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("livre not found with id " + id));
        livre.setIsbn(livreinfo.getIsbn());
        livre.setDateEdition(livreinfo.getDateEdition());
        livre.setTitre(livreinfo.getTitre());
        livreRepository.save(livre);

    }




    public void delete(int id ) {
        Livre livre=livreRepository.findById(id);
        livreRepository.delete(livre);
    }

    public void affecterLivre(int idLivre,int idAuteur){
        Livre livre =livreRepository.findById(idLivre);
        Auteur auteur=auteurRepository.findById(idAuteur);
        auteur.getLivreList().add(livre);
        auteurRepository.save(auteur);

    }
}
