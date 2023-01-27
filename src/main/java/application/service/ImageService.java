package application.service;

import application.models.Image;
import application.repository.ImageRepo;
import application.utils.Service;

@org.springframework.stereotype.Service
public class ImageService extends Service<Image, ImageRepo> {

    public ImageService(ImageRepo repo) {
        super(repo);
        this.c = Image.class;
    }

}
