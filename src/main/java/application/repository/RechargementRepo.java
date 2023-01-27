package application.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import application.models.Rechargement;

@Repository
public interface RechargementRepo extends JpaRepository<Rechargement, Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into rechargement(montant,etat,id_utilisateur) values (?1,?2,2)", nativeQuery = true)
    public void recharger(Double montant, int etat);

}
