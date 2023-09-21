package com.melon.dao.playlistnow;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.melon.dto.playlistnow.PlaylistnowDto;

@Mapper
public interface IPlaylistnowDao {
	/**
	* 내 재생목록 조회
	* @author 여수한
	*/
	public List<PlaylistnowDto> selectMyPlaylist(String memberId);
	/**
	* 재생목록에 노래 추가
	* @author 여수한
	 * @param playlistCd 
	*/
	public void insertMyPlaylistSong(@Param("playlistCd")int playlistCd,@Param("songId")int songId);
	/**
	* 내 재생목록 코드 조회
	* @author 여수한
	*/
	public int selectPlaylistCd(String memberId);
	/**
	* 재생목록 셔플
	* @author 여수한
	*/
	public List<PlaylistnowDto> getMyPlaylistShuffle(String memberId);
	/**
	* 재생목록 삭제
	* @author 여수한
	*/
	public void deleteMyPlaylist(int playlistCd);
	/**
	* 재생목록에 노래 전체 추가
	* @author 여수한
	 * @param playlist_cd 
	*/
	public void insertMyPlaylist(@Param("playlistCd")int playlistCd, @Param("songId")int songId);
	/**
	* 재생목록에 노래 삭제
	* @author 여수한
	*/
	public void deleteMyPlaylistSong(@Param("playlistCd")int playlistCd, @Param("songId")int songId);
}
