package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import javax.transaction.Transactional;
import java.util.List;
import application.models.Lot;
import application.models.Message;

public interface LotRepo extends JpaRepository<Lot, Integer> {
        @Query(value = "SELECT * FROM Lot WHERE statut = true", nativeQuery = true)
        public List<Lot> list();

        @Query(value = "SELECT * FROM Lot WHERE id_lot = :id ", nativeQuery = true)
        public Lot findById(@Param("id") int id);

        @Query(value = "SELECT * FROM Lot WHERE id_utilisateur = :id_user", nativeQuery = true)
        public List<Lot> myEnchere(@Param("id_user") int id);

        @Transactional
        @Modifying
        @Query(value = "insert into lot(duree,prix_minimal,id_utilisateur,nom, descri,statut,id_categorie) values (?1,?2,?3,?4,?5,?6,?7)", nativeQuery = true)
        public Message insertEnchere (int duree, Double prixMinimal,int utilisateur,String nom,String descri,boolean statut, int categorie  );

}
