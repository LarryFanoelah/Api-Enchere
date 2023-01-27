package application.service;

import application.models.Categorie;
import application.repository.CategorieRepo;
import application.utils.Service;

@org.springframework.stereotype.Service
public class CategorieService extends Service<Categorie, CategorieRepo> {

    public CategorieService(CategorieRepo repo) {
        super(repo);
        this.c = Categorie.class;
    }

}
