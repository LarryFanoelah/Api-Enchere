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

        // @Query(value = "select * from lot where id_lot = :sql", nativeQuery = true)
        // public List<Lot> searchAvance(@Param("sql") String sql);

        // @Query(value = "SELECT * FROM Lot WHERE 1=1 AND (nom LIKE %:keyword% " +
        // "OR descri LIKE %:keyword%) AND date_debut <= :date AND id_categorie
        // =:id_categorie" +
        // " AND (prix_minimal >= :prix_min AND prix_minimal <= :prix_max) AND statut
        // =:statut", nativeQuery = true)
        // public List<Lot> findByMultipleCriteria(@Param("keyword") String keyword,
        // @Param("date") LocalDateTime date,
        // @Param("id_categorie") int id_categorie,
        // @Param("prix_min") double prix_min, @Param("prix_max") double prix_max,
        // @Param("statut") boolean statut);

        @Query(value = "SELECT * FROM Lot WHERE id_utilisateur = :id_user", nativeQuery = true)
        public List<Lot> myEnchere(@Param("id_user") int id);

}
