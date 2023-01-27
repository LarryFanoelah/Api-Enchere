package application.repository;

// import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import application.models.Utilisateur;

@Repository
public interface TokenRepo extends JpaRepository<Utilisateur, Integer> {

    // @Query(value = "INSERT INTO token (token, date_perumption, id_utilisateur,
    // date_debut) VALUES (:token, :date_perumption, :id_utilisateur, now())",
    // nativeQuery = true)
    // public void insertToken(@Param("token") String token,@Param("date_peumption")
    // LocalDateTime dateFin,@Param("id_utilisateur") int id_utilisateur);

}