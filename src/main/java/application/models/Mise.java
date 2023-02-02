package application.models;

import javax.persistence.*;
import application.utils.annotation.IdTable;
import lombok.*;

@Entity
@IdTable
@Setter
@Getter
@Table(name = "mise")
public class Mise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_mise;

    @Column(name = "montant")
    private double montant;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_lot")
    private Lot lot;
}
