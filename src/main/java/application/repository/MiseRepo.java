package application.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import application.models.Mise;
import application.models.Utilisateur;

public interface MiseRepo extends JpaRepository<Mise, Integer> {

    @Query(value = "SELECT count(id_mise) FROM mise where id_lot = :id_lot", nativeQuery = true)
    public int countIdMise(@Param("id_lot") int id_lot);

    @Query(value = "SELECT max(montant) FROM mise WHERE id_lot = :id_lot", nativeQuery = true)
    public double maxMontant(@Param("id_lot") int id_lot);

    @Query(value = "select id_utilisateur from mise where id_lot = :id_lot order by montant desc LIMIT 1", nativeQuery = true)
    public int getIdTop(@Param("id_lot") int id_lot);

    @Query(value = "SELECT  solde from utilisateur WHERE id_utilisateur = :id_utilisateur", nativeQuery = true)
    public double userSolde(@Param("id_utilisateur") int id_utilisateur);

    @Modifying
    @Transactional
    @Query(value = " UPDATE utilisateur set solde  = solde + :solde where id_utilisateur  = :id_utilisateur", nativeQuery = true)
    public void AddSoldeForAnotherUser(@Param("solde") double solde, @Param("id_utilisateur") int id_utilisateur);

    @Modifying
    @Transactional
    @Query(value = " UPDATE utilisateur set solde  = solde - :solde where id_utilisateur  = :id_utilisateur", nativeQuery = true)
    public void minusSold(@Param("solde") double solde, @Param("id_utilisateur") int id_utilisateur);

}