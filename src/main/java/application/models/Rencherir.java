package application.models;

import lombok.*;

@Setter
@Getter
public class Rencherir {

    private double montant;
    private Utilisateur user;
    private Lot lot;

}
