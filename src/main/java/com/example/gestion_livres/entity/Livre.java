package com.example.gestion_livres.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String isbn;
    private String titre;
    @Temporal(TemporalType.DATE)
    private Date dateEdition;

    @ManyToMany(mappedBy = "livreList",fetch = FetchType.EAGER)
    @JsonIgnore
    List<Auteur> auteurList;


}
