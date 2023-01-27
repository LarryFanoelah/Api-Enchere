package application.controller;

import org.springframework.web.bind.annotation.*;
import application.models.Image;
import application.repository.ImageRepo;
import application.service.ImageService;
import application.utils.Controller;

@RestController
@RequestMapping("/images")
@CrossOrigin("*")
public class ImageController extends Controller<Image, ImageRepo, ImageService> {
    public ImageController(ImageService service) {
        super(service);
    }
}   