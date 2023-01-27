package application.models;

import java.time.LocalDateTime;
import javax.persistence.*;
import application.utils.annotation.IdTable;
import lombok.*;

@Entity
@IdTable
@Setter
@Getter
@Table(name = "token")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_token;

    @Column(name = "token")
    private String token;

    @Column(name = "date_perumption")
    private LocalDateTime date_perumption;

    @Column(name = "date_debut")
    private LocalDateTime date_debut;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur id_utilisateur;
}
