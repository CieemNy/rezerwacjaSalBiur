package com.zeto.rezerwacja.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zeto.rezerwacja.service.ImageGalleryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.zeto.rezerwacja.model.ImageGallery;
import com.zeto.rezerwacja.service.ImageGalleryService;


@RestController
@RequestMapping("/image")
@CrossOrigin("*")
public class ImageGalleryController {

    @Value("${uploadDir}")
    private String uploadFolder;

    @Autowired
    private ImageGalleryService imageGalleryService;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = {"/", "/home"})
    public String addProductPage() {
        return "index";
    }

    @PostMapping("/add")
    public @ResponseBody ResponseEntity<?> createProduct(@RequestParam("nazwa") String name,
                                                         @RequestParam("opis") String description, Model model, HttpServletRequest request
            ,final @RequestParam("obraz") MultipartFile file) {
        try {
            //String uploadDirectory = System.getProperty("user.dir") + uploadFolder;
            String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
            log.info("uploadDirectory:: " + uploadDirectory);
            String fileName = file.getOriginalFilename();
            String filePath = Paths.get(uploadDirectory, fileName).toString();
            log.info("FileName: " + file.getOriginalFilename());
            if (fileName == null || fileName.contains("..")) {
                model.addAttribute("invalid", "Bledna sciezka pliku! \" + fileName");
                return new ResponseEntity<>("Bledna sciezka pliku " + fileName, HttpStatus.BAD_REQUEST);
            }
            String[] names = name.split(",");
            String[] descriptions = description.split(",");
            log.info("Nazwa: " + names[0]+" "+filePath);
            log.info("opis: " + descriptions[0]);
            try {
                File dir = new File(uploadDirectory);
                if (!dir.exists()) {
                    log.info("Folder utworzony");
                    dir.mkdirs();
                }
                // Save the file locally
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
                stream.write(file.getBytes());
                stream.close();
            } catch (Exception e) {
                log.info("in catch");
                e.printStackTrace();
            }
            byte[] imageData = file.getBytes();
            ImageGallery imageGallery = new ImageGallery();
            imageGallery.setName(names[0]);
            imageGallery.setImage(imageData);
            imageGallery.setDescription(descriptions[0]);
            imageGalleryService.saveImage(imageGallery);
            log.info("HttpStatus===" + new ResponseEntity<>(HttpStatus.OK));
            return new ResponseEntity<>("Plik zapisany " + fileName, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Exception: " + e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    void showImage(@PathVariable("id") Long id, HttpServletResponse response, Optional<ImageGallery> imageGallery)
            throws ServletException, IOException {
        log.info("Id :: " + id);
        imageGallery = imageGalleryService.getImageById(id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(imageGallery.get().getImage());
        response.getOutputStream().close();
    }

    @GetMapping("/desc/{id}")
    String showProductDetails(@RequestParam("id") Long id, Optional<ImageGallery> imageGallery, Model model) {
        try {
            log.info("Id :: " + id);
            if (id != 0) {
                imageGallery = imageGalleryService.getImageById(id);

                log.info("zdjecia :: " + imageGallery);
                if (imageGallery.isPresent()) {
                    model.addAttribute("id", imageGallery.get().getId());
                    model.addAttribute("opis", imageGallery.get().getDescription());
                    model.addAttribute("nazwa", imageGallery.get().getName());
                    return "imagedetails";
                }
                return "redirect:/home";
            }
            return "redirect:/home";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/home";
        }
    }

    @GetMapping("/findall")
    String show(Model map) {
        List<ImageGallery> images = imageGalleryService.getAllActiveImages();
        map.addAttribute("images", images);
        return "images";
    }
    @DeleteMapping("/delete/{id}")
    public void deleteImage(@PathVariable("id") Long id){
        imageGalleryService.deleteImage(id);
    }
}
