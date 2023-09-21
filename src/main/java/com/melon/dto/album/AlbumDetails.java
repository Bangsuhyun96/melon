package com.melon.dto.album;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDetails {

    private int albumId;
    private int songId;
    private int artistId;
    private int albumLike;
    private int songLike;
    private String albumType;
    private String songName;
    private String artistName;
    private String releaseDate;
    private String genreName;
    private String albumPublisher;
    private String albumAgency;
    private String albumPro;
    private String albumName;
    private String artistAgency;
    private String memberId;
}