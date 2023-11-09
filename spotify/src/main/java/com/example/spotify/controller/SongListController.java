package com.example.spotify.controller;

import com.example.spotify.entity.SongList;
import com.example.spotify.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/songList")
@CrossOrigin
public class SongListController {

    @Autowired
    private SongListService songListService;

    @PostMapping("/addSong")
    public SongList addSong(@RequestBody SongList songList){
        return songListService.addSong(songList);
    }

    @PostMapping("/allSongs")
    public ArrayList<SongList> getAllSongs(){
        return songListService.getAllSongs();
    }
}