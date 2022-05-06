package com.zeto.rezerwacja.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Arrays;
import javax.persistence.*;

@Entity
@Table(name = "galeria")
public class ImageGallery {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "nazwa", nullable = false)
    private String name;

    @Column(name = "opis", nullable = false)
    private String description;

    @Lob
    @Column(name = "obraz", length = Integer.MAX_VALUE, nullable = true)
    private byte[] image;

    public ImageGallery() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ImageGallery{" +
                "id=" + id +
                ", nazwa='" + name + '\'' +
                ", opis='" + description + '\'' +
                ", obraz=" + Arrays.toString(image) +
                '}';
    }
}


