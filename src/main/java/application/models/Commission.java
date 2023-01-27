package application.models;

import java.time.LocalDateTime;
import javax.persistence.*;
import application.utils.annotation.IdTable;
import lombok.*;

@Entity
@IdTable
@Setter
@Getter
@Table(name = "commission")
public class Commission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "montant")
    private double montant;

    @Column(name = "date_com")
    private LocalDateTime dateCom;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_mise")
    private Mise mise;
    
}
