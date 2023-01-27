package application.utils;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class Controller<M, R extends JpaRepository<M, Integer>, S extends Service<M, R>> {
    protected S service;

    public Controller(S service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody M model) {
        return new ResponseEntity<>(this.service.saveOrUpdate(model), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody M model) {
        return new ResponseEntity<>(this.service.saveOrUpdate(model), HttpStatus.OK);
    }

    @DeleteMapping("")
    public void delete(@RequestBody M model) {
        this.service.delete(model);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(this.service.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }
}
