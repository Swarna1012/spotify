package com.example.spotify.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserInfoDto {
    private Long userId;
    private String userName;
    private String email;
    private String password;
    private Long phNo;
    private String displayName;
    private String bio;
    private String profile;
    private String coverImage;
    private String language;
    private String socialMedia;
}
