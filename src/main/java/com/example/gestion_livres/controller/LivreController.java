package com.example.gestion_livres.controller;

import com.example.gestion_livres.entity.Livre;
import com.example.gestion_livres.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/livres")
public class LivreController {




    @Autowired
    private LivreService livreService;
    @GetMapping("/datestart/{datest}/datefin/{datefi}")
    public List<Livre> findByDateEditionBetween(@PathVariable Date dateStart,@PathVariable Date dateEnd) {
        return livreService.findByDateEditionBetween(dateStart, dateEnd);
    }

 /*   @GetMapping("/datestart/{datest}/datefin/{datefi}")
    public List<Livre> findBetweenDates(@PathVariable Date datest,@PathVariable Date datefi) {
        return livreService.findBetweenDates(datest, datefi);
    }
*/
    @GetMapping("/isbn/{isbn}")
    public Livre findByIsbn(@PathVariable String isbn) {
        return livreService.findByIsbn(isbn);
    }



    @PostMapping("/save")
    public Livre save(@RequestBody Livre livre) {
        return livreService.save(livre);
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

    @PostMapping("/livre/{idLivre}/auteur/{idAuteur}")
    public void affecterLivre(@RequestBody int idLivre,@RequestBody int idAuteur) {
        livreService.affecterLivre(idLivre, idAuteur);
    }



}
