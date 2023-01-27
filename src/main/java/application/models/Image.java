package application.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import application.utils.annotation.IdTable;
import lombok.*;

@Entity
@IdTable
@Setter
@Getter
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_images;

    @Column(name = "src")
    private String src;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_lot")
    @MapsId("id_images")
    @JsonIgnore
    private Lot lot;
}
