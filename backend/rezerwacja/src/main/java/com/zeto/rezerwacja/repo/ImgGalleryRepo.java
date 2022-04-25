package com.zeto.rezerwacja.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zeto.rezerwacja.model.ImgGallery;


@Repository
public interface ImgGalleryRepo extends JpaRepository<ImgGallery, Long>{

}

