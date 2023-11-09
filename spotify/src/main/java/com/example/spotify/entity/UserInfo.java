package com.example.spotify.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Base64;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String nanoId;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phNo;
    private String displayName;
    private String bio;
    private String profile;
    private String coverImage;

    private String name;
    private String type;
    @Lob
    @Column(length = 1000)
    private byte[] imageData;

    private String coverName;
    private String coverType;
    @Lob
    @Column(length = 1000)
    private byte[] imageDataCover;

}
