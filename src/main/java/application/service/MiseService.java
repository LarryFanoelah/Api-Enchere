package application.service;

import java.util.ArrayList;

import application.models.Mise;
import application.models.Rencherir;
import application.repository.MiseRepo;

@org.springframework.stereotype.Service
public class MiseService {

    public final MiseRepo miseRepo;

    public MiseService(MiseRepo miseRepo) {
        this.miseRepo = miseRepo;
    }

    public Mise creer(Rencherir rencherir) throws Exception {
        Mise mise = new Mise();
        double max = this.miseRepo.maxMontant(rencherir.getLot().getId_lot());
        int idUserMaxMontant = this.miseRepo.getIdTop(rencherir.getLot().getId_lot());
        double userSolde = this.miseRepo.userSolde(rencherir.getUser().getId_utilisateur());
        if (rencherir.getMontant() < max) {
            throw new Exception("Montant insuffisant");
        } else if (idUserMaxMontant == rencherir.getUser().getId_utilisateur()) {
            throw new Exception("Vous etes le top");
        } else if (userSolde < rencherir.getMontant()) {
            throw new Exception("Solde insuffisant");
        } else {
            mise.setLot(rencherir.getLot());
            mise.setUtilisateur(rencherir.getUser());
            mise.setMontant(rencherir.getMontant());
            this.miseRepo.AddSoldeForAnotherUser(userSolde, idUserMaxMontant);
            this.miseRepo.minusSold(rencherir.getMontant(), rencherir.getUser().getId_utilisateur());
        }
        return miseRepo.save(mise);
    }

    public ArrayList<Mise> lire() {
        return (ArrayList<Mise>) miseRepo.findAll();
    }
}
