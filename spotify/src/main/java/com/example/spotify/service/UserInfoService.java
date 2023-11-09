package com.example.spotify.service;

import com.example.spotify.dto.ResponseDto;
import com.example.spotify.dto.UserInfoDto;
import com.example.spotify.entity.UserInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserInfoService {

    UserInfo addNewUser(UserInfo userInfo);

    UserInfo login(String username,String password );

    UserInfo editUser(UserInfo userInfo);

    UserInfo signup(MultipartFile file, MultipartFile files, String nanoId) throws IOException;

    byte[] downloadImage(String nanoId, String fileName);

    byte[] downloadImage1(String nanoId, String fileName);

    byte[] downloadImages(String fileName);
}
