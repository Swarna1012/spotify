package com.example.spotify.service;

import com.example.spotify.dto.ResponseDto;
import com.example.spotify.dto.SongListDto;
import com.example.spotify.entity.SongList;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public interface SongListService {

    SongList addSong(SongList songList);

    ArrayList<SongList> getAllSongs();
}
