//package com.example.spotify.service.impl;
//
//import com.example.spotify.entity.ImageData;
//import com.example.spotify.repository.ImageRepository;
//import com.example.spotify.service.ImageDataService;
//import com.example.spotify.util.ImageUtils;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.Optional;
//
//@Service
//public class ImageDataServiceIMPL implements ImageDataService {
//
//    @Autowired
//    private ImageRepository imageRepository;
//
//
//    public String uploadImage(MultipartFile file) throws IOException {
//        ImageData imageData = imageRepository.save(ImageData.builder()
//                .name(file.getOriginalFilename())
//                .type(file.getContentType())
//                .imageData(ImageUtils.compressImage(file.getBytes())).build());
//        if (imageData != null) {
//            return "file uploaded successfully : " + file.getOriginalFilename();
//        }
//        return null;
//    }
//
//
//    @Transactional
//    public byte[] downloadImage(String fileName) {
//        Optional<ImageData> dbImageData = imageRepository.findByName(fileName);
//        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
//        System.out.println("image sent " + images);
//        return images;
//    }
//}
