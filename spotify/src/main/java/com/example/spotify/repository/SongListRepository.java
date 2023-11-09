package com.example.spotify.repository;

import com.example.spotify.entity.SongList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongListRepository extends JpaRepository<SongList, Long> {
}
