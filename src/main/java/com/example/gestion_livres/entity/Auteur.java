package com.example.gestion_livres.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.sql.results.graph.Fetch;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Auteur extends Personne{

    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinTable(
            name = "livre_auteur",
            joinColumns = @JoinColumn(name = "auteur_id"),
            inverseJoinColumns = @JoinColumn(name = "livre_id"))
    List<Livre> livreList;
}
