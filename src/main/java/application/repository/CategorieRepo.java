package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import application.models.Categorie;

public interface CategorieRepo extends JpaRepository<Categorie, Integer> {
}