package application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import application.models.Rechargement;
import application.service.RechargementService;



@RestController
@RequestMapping("/rechargement")
@CrossOrigin("*")
public class RechargementController {

    public final RechargementService rechargementService;

    public RechargementController(RechargementService rechargementService) {
        this.rechargementService = rechargementService;
    }


    @PostMapping("")
    public ResponseEntity recharger(@RequestBody Rechargement rechargement){
        return new ResponseEntity(this.rechargementService.recharger(rechargement), HttpStatus.OK);

    }
}
