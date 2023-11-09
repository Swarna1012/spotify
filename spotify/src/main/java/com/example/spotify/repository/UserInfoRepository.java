package com.example.spotify.repository;

import com.example.spotify.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findByUsernameAndPassword(String username, String password);

    UserInfo findByUsername(String username);

    UserInfo findByNanoId(String nanoId);

    Optional<UserInfo> findByName(String fileName);

    Optional<UserInfo> findByNanoIdAndName(String nanoId, String fileName);

    Optional<UserInfo> findByNanoIdAndCoverName(String nanoId, String fileName);

    UserInfo findAllByUsername(String username);
}
