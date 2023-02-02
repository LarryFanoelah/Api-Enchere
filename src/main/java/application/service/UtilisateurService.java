package application.service;

import java.util.List;
import org.springframework.stereotype.Service;
import application.models.Utilisateur;
import application.repository.UtilisateurRepo;

@Service
public class UtilisateurService {

    private final UtilisateurRepo utilisateurRepo;

    public UtilisateurService(UtilisateurRepo utilisateurRepo) {
        this.utilisateurRepo = utilisateurRepo;
    }

    public List<Utilisateur> list() {
        return this.utilisateurRepo.findAll();
    }

    public Utilisateur login(Utilisateur utilisateur) {
        return utilisateurRepo.login(utilisateur.getEmail(), utilisateur.getMdp());
    }

    public Utilisateur findById(int idUtilisateur) {
        return utilisateurRepo.getById(idUtilisateur);
    }

    // public void generateToken(Utilisateur utilisateur) {
    // tokenRepo.insertToken(utilisateurRepo.generateToken(utilisateur.getId_utilisateur()),
    // LocalDateTime.now().plus(3, ChronoUnit.HOURS),
    // utilisateur.getId_utilisateur());
    // }
}
