package com.example.spotify.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class SongList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long songId;
    private String nanoId;
    private String userId;
    private String nanoSongId;
    private String songImage;
    private String song;
    private String songTitle;

//    @PrePersist
//    public void onSave(){
//        this.songUploadAt=new Date(System.currentTimeMillis());
//    }
}
