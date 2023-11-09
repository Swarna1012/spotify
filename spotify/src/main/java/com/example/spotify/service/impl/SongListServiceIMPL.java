package com.example.spotify.service.impl;

import com.example.spotify.dto.ResponseDto;
import com.example.spotify.dto.SongListDto;
import com.example.spotify.entity.SongList;
import com.example.spotify.entity.UserInfo;
import com.example.spotify.repository.SongListRepository;
import com.example.spotify.repository.UserInfoRepository;
import com.example.spotify.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongListServiceIMPL implements SongListService {

    @Autowired
    private SongListRepository songListRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;


    @Override
    public SongList addSong(SongList songList) {
        songList.setNanoId(songList.getNanoSongId());
        songList.setUserId(songList.getUserId());
        songList.setNanoSongId(songList.getNanoSongId());
        songList.setSong(songList.getSong());
        songList.setSongImage(songList.getSongImage());
        songList.setSongTitle(songList.getSongTitle());
        songListRepository.save(songList);
        return songList;
    }

    @Override
    public ArrayList<SongList> getAllSongs() {
        ArrayList<SongList> songLists = (ArrayList<SongList>) songListRepository.findAll();
        return songLists;
    }
}
