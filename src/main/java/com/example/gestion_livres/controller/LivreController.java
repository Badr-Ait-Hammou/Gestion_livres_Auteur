package com.example.gestion_livres.controller;

import com.example.gestion_livres.entity.Livre;
import com.example.gestion_livres.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/livres")
public class LivreController {




    @Autowired
    private LivreService livreService;


    @GetMapping("/datestart/{dateStart}/datefin/{dateEnd}")
    public List<Livre> findByDateEditionBetween(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateStart,@PathVariable  @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateEnd) {
        return livreService.findByDateEditionBetween(dateStart, dateEnd);
    }


    @GetMapping("/isbn/{isbn}")
    public Livre findByIsbn(@PathVariable String isbn) {
        return livreService.findByIsbn(isbn);
    }



    @PostMapping("/save")
    public void save(@RequestBody Livre livre) {
         livreService.save(livre);
    }

    @GetMapping("/")
    public List<Livre> findAll() {
        return livreService.findAll();
    }

    @GetMapping("/id/{id}")
    public Livre findById(@PathVariable int id) {
        return livreService.findById(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Integer id,@RequestBody Livre livreinfo) {
        livreService.update(id, livreinfo);
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable int id) {
        livreService.delete(id);
    }

    @PostMapping("/affecter/livre/{idLivre}/auteur/{idAuteur}")
    public void affecterLivre(@PathVariable int idLivre,@PathVariable int idAuteur) {
        livreService.affecterLivre(idLivre, idAuteur);
    }



}
