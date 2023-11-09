package com.example.spotify.controller;

import com.example.spotify.entity.UserInfo;
import com.example.spotify.service.UserInfoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/register")
    public UserInfo addNewUser(@RequestBody UserInfo userInfo){
        return userInfoService.addNewUser(userInfo);
    }

    @PostMapping("/login/{username}/{password}")
    public UserInfo login(@PathVariable String username, @PathVariable String password){
        return userInfoService.login(username, password);
    }

    @PostMapping("/edit")
    public UserInfo editUser(@RequestBody UserInfo userInfo){
        return userInfoService.editUser(userInfo);
    }

    @PostMapping("/images/{nanoId}")
    public UserInfo signup(@RequestParam("image") MultipartFile file, @RequestParam("image1") MultipartFile files, @PathVariable String nanoId) throws IOException {
        return userInfoService.signup(file, files, nanoId);
    }

    @GetMapping("/image/{nanoId}/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable String nanoId, @PathVariable String fileName){
        byte[] imageData=userInfoService.downloadImage(nanoId, fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }

    @GetMapping("/image1/{nanoId}/{fileName}")
    public ResponseEntity<?> downloadImage1(@PathVariable String nanoId, @PathVariable String fileName){
        byte[] imageData=userInfoService.downloadImage1(nanoId, fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }


    @GetMapping("/imageTest/{fileName}")
    public ResponseEntity<?> downloadImages(@PathVariable String fileName){
        byte[] imageData=userInfoService.downloadImages(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }
}
