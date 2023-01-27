package application.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import application.models.Rechargement;
import application.repository.RechargementRepo;

@Service
public class RechargementService {

   
    private final RechargementRepo rechargementrepo;

    @PersistenceContext
    private EntityManager entityManager;

    public RechargementService(RechargementRepo rechargementrepo) {
        this.rechargementrepo = rechargementrepo;
    }

    public boolean recharger (Rechargement rechargement){
        rechargementrepo.recharger(
        rechargement.getMontant(),rechargement.getEtat());
        return true;
    }



}
