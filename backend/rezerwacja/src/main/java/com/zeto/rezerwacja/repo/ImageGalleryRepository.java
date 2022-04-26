package com.zeto.rezerwacja.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zeto.rezerwacja.model.ImageGallery;


@Repository
public interface ImageGalleryRepository extends JpaRepository<ImageGallery, Long>{

}

