package application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import application.models.Lot;
import application.models.Searching;
import application.models.Utilisateur;
import application.service.LotService;

@RestController
@RequestMapping("/encheres")
@CrossOrigin("*")
public class LotController {
    public final LotService lotService;

    public LotController(LotService lotService) {
        this.lotService = lotService;
    }

    @GetMapping("")
    public ResponseEntity selectAll() {
        return new ResponseEntity<>(this.lotService.list(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity searchAvance(@RequestBody Searching s) {
        return new ResponseEntity<>(this.lotService.search(s), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return new ResponseEntity<>(this.lotService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/mine")
    public ResponseEntity findById(@RequestBody Utilisateur u) {
        return new ResponseEntity<>(this.lotService.findById(u.getId_utilisateur()), HttpStatus.OK);
    }

    @PostMapping("/insertion")
    public ResponseEntity insertEnchere(@RequestBody Lot lot) {
        lotService.insertEnchere(lot);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    


}
