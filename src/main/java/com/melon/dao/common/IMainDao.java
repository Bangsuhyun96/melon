package com.melon.dao.common;

import com.melon.dto.common.MainAlbumDto;
import com.melon.dto.common.MainSongDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IMainDao {

    public List<MainAlbumDto> fourAlbum();

    public List<MainSongDto> recommendSong();

    public List<MainAlbumDto> myMusic();

    public List<MainSongDto> topMusic();
}
