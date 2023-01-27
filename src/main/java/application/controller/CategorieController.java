package application.controller;

import org.springframework.web.bind.annotation.*;
import application.models.Categorie;
import application.repository.CategorieRepo;
import application.service.CategorieService;
import application.utils.Controller;

@RestController
@RequestMapping("/categories")
@CrossOrigin("*")
public class CategorieController extends Controller<Categorie, CategorieRepo, CategorieService> {
    public CategorieController(CategorieService service) {
        super(service);
    }
}