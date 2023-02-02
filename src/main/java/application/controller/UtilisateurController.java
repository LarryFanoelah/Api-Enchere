package application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import application.models.ErrorMessage;
import application.models.Utilisateur;
import application.service.UtilisateurService;

@RestController
@RequestMapping("/utilisateurs")
@CrossOrigin("*")
public class UtilisateurController {
    public final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("")
    public ResponseEntity list(){
        return new ResponseEntity<>(this.utilisateurService.list(), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Utilisateur utilisateur){
        Utilisateur u = utilisateurService.login(utilisateur);
        if(u != null){
            return new ResponseEntity<>(u, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new ErrorMessage(101, "Utilisateur not found"), HttpStatus.NOT_FOUND);
        }
    }
}
    