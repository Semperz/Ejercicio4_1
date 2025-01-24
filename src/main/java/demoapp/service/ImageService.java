package demoapp.service;

import demoapp.model.entity.Image;
import demoapp.model.repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    private ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
        imageRepository.save(new Image("/img/facts.png"));
        imageRepository.save(new Image("/img/VNMJ.jpg"));
        imageRepository.save(new Image("/img/flanos.jpg"));

    }

    public List<Image> listImages() {
        return imageRepository.findAll();
    }

    public void voteImage(Long id) {
        Image image = imageRepository.findById(id).orElse(null);
        assert image != null;
        image.setVotes(image.getVotes() + 1);
        imageRepository.save(image);
    }
}