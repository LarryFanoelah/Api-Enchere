package application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import application.models.Searching;
import application.service.LotService;
import application.models.Lot;

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

    @GetMapping("/mine/{id}")
    public ResponseEntity mine(@PathVariable int id) {
        return new ResponseEntity<>(this.lotService.myEnchere(id), HttpStatus.OK);
    }

    @PostMapping("/insertion")
    public ResponseEntity insertEnchere(@RequestBody Lot lot) throws Exception {
                
        return new ResponseEntity<>(this.lotService.save(lot),HttpStatus.OK);

    }
}