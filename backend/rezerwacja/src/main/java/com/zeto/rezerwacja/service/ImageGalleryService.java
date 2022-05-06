package com.zeto.rezerwacja.service;

import java.util.List;
import java.util.Optional;

import com.zeto.rezerwacja.model.ImageGallery;
import com.zeto.rezerwacja.repo.ImageGalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImageGalleryService {

    @Autowired
    private ImageGalleryRepository imageGalleryRepository;

    public void saveImage(ImageGallery imageGallery) {
        imageGalleryRepository.save(imageGallery);
    }

    public List<ImageGallery> getAllActiveImages() {
        return imageGalleryRepository.findAll();
    }

    public Optional<ImageGallery> getImageById(Long id) {
        return imageGalleryRepository.findById(id);
    }
    public void deleteImage(Long id){
        imageGalleryRepository.deleteById(id);
    }
}
