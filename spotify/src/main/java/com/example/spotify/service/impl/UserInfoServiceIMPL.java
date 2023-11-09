package com.example.spotify.service.impl;

import com.example.spotify.entity.UserInfo;
import com.example.spotify.repository.UserInfoRepository;
import com.example.spotify.service.UserInfoService;
import com.example.spotify.util.ImageUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserInfoServiceIMPL implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Transactional
    @Override
    public UserInfo addNewUser(UserInfo userInfo) {
        UserInfo existingUser = userInfoRepository.findByUsername(userInfo.getUsername());

        if (existingUser != null) {
            return null;
        }

        userInfoRepository.save(userInfo);
        System.out.println(userInfo);
        return userInfo;
    }


    @Transactional
    @Override
    public UserInfo login(String username, String password) {
        System.out.println("inside login");
        UserInfo userInfo1 = userInfoRepository.findByUsernameAndPassword(username, password);

        if(userInfo1!=null){
            System.out.println("login");
            return userInfo1;
        }
        else{
            return null;
        }
    }

    @Transactional
    @Override
    public UserInfo editUser(UserInfo userInfo) {

        UserInfo checkUsername = userInfoRepository.findByUsername(userInfo.getUsername());
        System.out.println(checkUsername.getUsername());

        if(userInfo.getUsername().equals(checkUsername.getUsername()) && !Objects.equals(userInfo.getNanoId(), checkUsername.getNanoId())){
            return null;
        }

        UserInfo userInfo1 = userInfoRepository.findByNanoId(userInfo.getNanoId());
        System.out.println("user " + userInfo1.getUsername());

        userInfo1.setUsername(userInfo.getUsername());
        userInfo1.setFirstName(userInfo.getFirstName());
        userInfo1.setLastName(userInfo.getLastName());
        userInfo1.setPhNo(userInfo.getPhNo());
        userInfo1.setEmail(userInfo.getEmail());
        userInfo1.setPassword(userInfo.getPassword());
        userInfoRepository.save(userInfo1);
        System.out.println("edited");
        return userInfo1;

    }

    @Transactional
    @Override
    public UserInfo signup(MultipartFile file, MultipartFile files, String nanoId) throws IOException {

            UserInfo userInfo = userInfoRepository.findByNanoId(nanoId);
            System.out.println(userInfo);

//        ImageData imageData = imageRepository.save(ImageData.builder()
//                .name(file.getOriginalFilename())
//                .type(file.getContentType())
//                .imageData(ImageUtils.compressImage(file.getBytes())).build());
//        if (imageData != null) {
//            return "file uploaded successfully : " + file.getOriginalFilename();
//        }

        UserInfo userInfo2 = UserInfo.builder()
                .coverName(files.getOriginalFilename())
                .coverType(files.getContentType())
                .imageDataCover(ImageUtils.compressImage(files.getBytes()))
                .build();

            UserInfo userInfo1 = UserInfo.builder()
                    .name(file.getOriginalFilename())
                    .type(file.getContentType())
                    .imageData(ImageUtils.compressImage(file.getBytes()))
                    .build();



        System.out.println(userInfo2);

            userInfo.setName(userInfo1.getName());
            userInfo.setType(userInfo1.getType());
            userInfo.setImageData(userInfo1.getImageData());
            userInfo.setCoverName(userInfo2.getCoverName());
            userInfo.setCoverType(userInfo2.getCoverType());
            userInfo.setImageDataCover(userInfo2.getImageDataCover());

            userInfo = userInfoRepository.save(userInfo);

            return userInfo;
    }


    @Transactional
    public byte[] downloadImage(String nanoId, String fileName) {
        System.out.println(nanoId +"   " + fileName);
        Optional<UserInfo> dbImageData = userInfoRepository.findByNanoIdAndName(nanoId,fileName);
        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }

    @Transactional
    public byte[] downloadImage1(String nanoId, String fileName) {
        System.out.println(nanoId +"   " + fileName);
        Optional<UserInfo> dbImageData = userInfoRepository.findByNanoIdAndCoverName(nanoId,fileName);
        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }


    @Transactional
    public byte[] downloadImages(String fileName) {
        System.out.println(fileName);
        Optional<UserInfo> dbImageData = userInfoRepository.findByName(fileName);
        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
        System.out.println("image sent " + images);
        return images;
    }
}

