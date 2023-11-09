package com.example.spotify.dto;

import com.example.spotify.entity.UserInfo;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SongListDto {

    private Long songId;
    private Long userId;
    private String songName;
    private String song;
    private List<String> tags;
    private List<String> songType;
    private Date songUploadAt;
    private String songLanguage;
    private String songCoverImage;
    private String songVideo;
    private String credits;
    private String description;
}
