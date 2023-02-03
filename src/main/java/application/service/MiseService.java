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

    public String insert(Rencherir rencherir) {
        String succes = "";
        Mise mise = new Mise();
        int count = this.miseRepo.countIdMise(rencherir.getLot().getId_lot());
        if (count == 0) {
            mise.setLot(rencherir.getLot());
            mise.setUtilisateur(rencherir.getUtilisateur());
            mise.setMontant(rencherir.getMontant());
            this.miseRepo.save(mise);
            succes = "inssertion completer";
        } else {
            System.out.println(rencherir.getMontant());
            System.out.println(rencherir.getLot().getPrixMinimal());
            if (rencherir.getUtilisateur().getId_utilisateur() != rencherir.getLot().getUtilisateur()
                    .getId_utilisateur()) {
                if (this.miseRepo.count() == 0) {
                    mise.setMontant(rencherir.getMontant());
                    mise.setUtilisateur(rencherir.getUtilisateur());
                    mise.setLot(rencherir.getLot());
                    this.miseRepo.save(mise);
                } else {
                    double max = this.miseRepo.maxMontant(rencherir.getLot().getId_lot());
                    int idUserMaxMontant = this.miseRepo.getIdTop(rencherir.getLot().getId_lot());
                    double userSolde = this.miseRepo.userSolde(rencherir.getUtilisateur().getId_utilisateur());
                    if (rencherir.getMontant() <= max) {
                        succes = "Montant insuffisant";
                    } else if (idUserMaxMontant == rencherir.getUtilisateur().getId_utilisateur()) {
                        succes = "Vous etes l'entête";
                    } else if (userSolde < rencherir.getMontant()) {
                        succes = "Votre solde est insuffisant";
                    } else {
                        mise.setLot(rencherir.getLot());
                        mise.setUtilisateur(rencherir.getUtilisateur());
                        mise.setMontant(rencherir.getMontant());
                        this.miseRepo.AddSoldeForAnotherUser(max, idUserMaxMontant);
                        this.miseRepo.minusSold(rencherir.getMontant(),rencherir.getUtilisateur().getId_utilisateur());
                        this.miseRepo.save(mise);
                        succes = "inssertion completer";
                    }
                }
            } else {
                succes = "vous etes la propriete de cette enchere";
            }
        }
        return succes;
    }

    public ArrayList<Mise> lire() {
        return (ArrayList<Mise>) miseRepo.findAll();
    }
}
