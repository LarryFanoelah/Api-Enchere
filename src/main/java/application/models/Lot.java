package application.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import application.utils.annotation.IdTable;
import lombok.*;

@Entity
@IdTable
@Setter
@Getter
@Table(name = "lot")
public class Lot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_lot;

    @Column(name = "date_debut")
    private LocalDate dateDebut;

    @Column(name = "duree")
    private int dure;

    @Column(name = "prix_minimal")
    private double prixMinimal;

    @Column(name = "nom")
    private String nom;

    @Column(name = "descri")
    private String descri;

    @Column(name = "statut")
    private boolean statut;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_categorie")
    private Categorie categorie;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id_images")
    private List<Image> images;
}
