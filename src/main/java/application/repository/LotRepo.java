package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import application.models.Lot;

public interface LotRepo extends JpaRepository<Lot, Integer> {
        @Query(value = "SELECT * FROM Lot WHERE statut = true", nativeQuery = true)
        public List<Lot> list();

        @Query(value = "SELECT * FROM Lot WHERE id_lot = :id ", nativeQuery = true)
        public Lot findById(@Param("id") int id);

        @Query(value = "SELECT * FROM Lot WHERE id_utilisateur = :id_user", nativeQuery = true)
        public List<Lot> myEnchere(@Param("id_user") int id);

}
