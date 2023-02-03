package application.models;

import java.time.LocalDate;
import lombok.*;

@Setter
@Getter
public class Searching {
    private String motCle;
    private LocalDate dateFin;
    private LocalDate dateDebut;
    private int id_categorie;
    private double prix_min;
    private double prix_max;
    private String statut;
}
