package com.melon.dto.common;

import lombok.Data;

@Data
public class MainSongDto {
    private int songId;
    private int albumId;
    private int artistId;
    private String songName;
    private String artistName;
    private String albumName;
}
