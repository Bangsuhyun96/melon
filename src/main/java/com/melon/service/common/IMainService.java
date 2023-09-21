package com.melon.service.common;

import com.melon.dto.common.MainAlbumDto;
import com.melon.dto.common.MainSongDto;

import java.util.List;

public interface IMainService {
    public List<MainAlbumDto> fourAlbum();

    public List<MainSongDto> recommendSong();

    public List<MainAlbumDto> myMusic();

    public List<MainSongDto> topMusic();
}
