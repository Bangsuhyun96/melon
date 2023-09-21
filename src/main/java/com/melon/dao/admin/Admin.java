package com.melon.dao.admin;

import com.melon.dto.admin.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Admin {

    List<AdminSongDto> findAllSong();

    List<AdminArtistDto> findAllArtist();

    List<AdminAlbumDto> findAllAlbum();

    void saveArtist(AdminArtistDto adminArtistDto);

    void saveAlbum(AdminAlbumDto adminAlbumDto);


    void saveSong(AdminSongDto adminSongDto);
    int saveSongArtistId(String artistName);
    int saveSongAlbumId(String albumName);


    void deleteSongsById(List<Long> songIds);

    List<AdminMemberDto> findAllMember();

    // 노래 검색
    List<AdminSongDto> searchSong(String name);

    // 맴버테이블에 티켓 연동
    void memberBuyTicket(PaymentRequest paymentRequest);
}
