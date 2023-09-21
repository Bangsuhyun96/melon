package com.melon.service.playlistnow;

import java.util.List;

import com.melon.dto.playlistnow.PlaylistnowDto;

public interface IPlaylistnowService {
	/**
	* 내 재생목록 조회
	* @author 여수한
	*/
	public List<PlaylistnowDto> getMyPlaylist(String memberId);
	/**
	* 재생목록에 노래 추가
	* @author 여수한
	 * @param playlist_cd 
	*/
	public void insertMyPlaylistSong(int playlistCd,int songId);
	/**
	* 내 재생목록 코드 조회
	* @author 여수한
	*/
	public int getPlaylistCd(String memberId);
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
	public void insertMyPlaylist(int playlistCd, List<Integer> songId);
	/**
	* 재생목록에 여러 노래 추가
	* @author 여수한
	 * @param playlist_cd 
	*/
	public void insertMyPlaylistSongs(int playlistCd, List<Integer> songsId);
	/**
	* 재생목록에 노래 삭제
	* @author 여수한
	*/
	public void deleteMyPlaylistSongs(int playlistCd, List<Integer> songsId);
}
