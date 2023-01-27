package application.models;

import java.time.LocalDateTime;
import lombok.*;

@Setter
@Getter
public class Searching {
    private String motCle;
    private LocalDateTime date;
    private int id_categorie;
    private double prix_min;
    private double prix_max;
    private boolean statut;
}
