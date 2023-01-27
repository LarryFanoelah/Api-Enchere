package application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import application.models.Mise;
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
        try {
            return new ResponseEntity<>(this.miseService.creer(rencherir), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.OK);
        }
    }

    @GetMapping("")
    public ResponseEntity read() {
        return new ResponseEntity<>(this.miseService.lire(), HttpStatus.OK);
    }
}