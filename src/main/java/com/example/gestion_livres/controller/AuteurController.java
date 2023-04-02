package com.example.gestion_livres.controller;

import com.example.gestion_livres.entity.Auteur;
import com.example.gestion_livres.entity.Livre;
import com.example.gestion_livres.service.AuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/auteur")
public class AuteurController {


    @GetMapping("/auteur/{idAuteur}")
    public List<Livre> findAllLivresByAut(@PathVariable int idAuteur) {
        return auteurService.findAll().stream().filter(auteur -> auteur.getId()==idAuteur).findFirst().orElse(null).getLivreList();

    }

    @GetMapping("/datenaissance/{dateNaissance}")
    public List<Auteur> findByDateNaissance(@PathVariable Date dateNaissance) {
        return auteurService.findByDateNaissance(dateNaissance);
    }

    @Autowired
    private AuteurService auteurService;




    @GetMapping("/cin/{cin}")
    public Auteur findByCin(@PathVariable String cin) {
        return auteurService.findByCin(cin);
    }

    @PostMapping("/save")
    public Auteur save(@RequestBody Auteur auteur) {
        return auteurService.save(auteur);
    }

    @GetMapping("/")
    public List<Auteur> findAll() {
        return auteurService.findAll();
    }

    @GetMapping("/id/{id}")
    public Auteur findById(@PathVariable int id) {
        return auteurService.findById(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Integer id,@RequestBody Auteur auteurinfo) {
        auteurService.update(id, auteurinfo);
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable int id) {
        auteurService.delete(id);
    }



}
