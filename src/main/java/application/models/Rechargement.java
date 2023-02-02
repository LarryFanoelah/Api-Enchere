package application.models;

import java.time.LocalDateTime;
import javax.persistence.*;
import application.utils.annotation.IdTable;
import lombok.*;

@Entity
@IdTable
@Setter
@Getter
@Table(name = "rechargement")
public class Rechargement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "montant")
    private double montant;

    @Column(name = "date_heure")
    private LocalDateTime dateHeure;
    
    @Column(name = "etat")
    private int etat;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_utilisateur")
    Utilisateur utilisateur;

}
