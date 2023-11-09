//package com.example.spotify.controller;
//
//import com.example.spotify.service.ImageDataService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//
//@RestController
//@RequestMapping("image")
//@CrossOrigin
//public class ImageDataController {
//
//    @Autowired
//    private ImageDataService imageDataService;
//
//    @PostMapping()
//    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
//        String uploadImage = imageDataService.uploadImage(file);
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(uploadImage);
//    }
//
//    @GetMapping("/{fileName}")
//    public ResponseEntity<?> downloadImage(@PathVariable String fileName){
//        byte[] imageData=imageDataService.downloadImage(fileName);
//        return ResponseEntity.status(HttpStatus.OK)
//                .contentType(MediaType.valueOf("image/png"))
//                .body(imageData);
//    }
//
//}
