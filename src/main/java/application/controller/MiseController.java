package application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import application.models.Rencherir;
import application.service.MiseService;

@RestController
@RequestMapping("/mises")
@CrossOrigin("*")
public class MiseController {
    public final MiseService miseService;

    public MiseController(MiseService miseService) {
        this.miseService = miseService;
    }

    @PostMapping("")
    public ResponseEntity create(@RequestBody Rencherir rencherir) {
        return new ResponseEntity<>(this.miseService.insert(rencherir), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity read() {
        return new ResponseEntity<>(this.miseService.lire(), HttpStatus.OK);
    }

    @GetMapping("/{id_lot}")
    public ResponseEntity getUserMax(@PathVariable int id_lot) {
        return new ResponseEntity<>(this.miseService.getUserMaxMontant(id_lot), HttpStatus.OK);
    }
}