package application.models;

import javax.persistence.*;
import application.utils.annotation.IdTable;
import lombok.*;

@Entity
@IdTable
@Setter
@Getter
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_utilisateur;

    @Column(name = "nom")
    private String nom;

    @Column(name = "email")
    private String email;
    
    @Column(name = "mdp")
    private String mdp;

    @Column(name = "administrateur")
    private boolean administrateur;

    @Column(name = "solde")
    private double solde;

}
