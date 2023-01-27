package application.models;

import javax.persistence.*;
import application.utils.annotation.IdTable;
import lombok.*;

@Entity
@IdTable
@Setter
@Getter
@Table(name = "categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_categorie;

    @Column(name = "intitule")
    private String intitule;

}
