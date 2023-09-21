package com.melon.service.playlistnow;

import java.util.List;

import org.springframework.stereotype.Service;

import com.melon.dao.playlistnow.IPlaylistnowDao;
import com.melon.dto.playlistnow.PlaylistnowDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class PlaylistnowServiceImpl implements IPlaylistnowService{
	
	private final IPlaylistnowDao playlistnowDao;
	/**
	* 내 재생목록 조회
	* @author 여수한
	*/
	@Override
	public List<PlaylistnowDto> getMyPlaylist(String memberId) {
		List<PlaylistnowDto> pd = playlistnowDao.selectMyPlaylist(memberId);
		return pd;
	}
	/**
	* 재생목록에 노래 추가
	* @author 여수한
	*/
	@Override
	public void insertMyPlaylistSong(int playlistCd,int songId) {
		playlistnowDao.insertMyPlaylistSong(playlistCd,songId);
	}
	/**
	* 내 재생목록 코드 조회
	* @author 여수한
	*/
	@Override
	public int getPlaylistCd(String memberId) {
		int playlist_cd = playlistnowDao.selectPlaylistCd(memberId);
		return playlist_cd;
	}
	/**
	* 재생목록 셔플
	* @author 여수한
	*/
	@Override
	public List<PlaylistnowDto> getMyPlaylistShuffle(String memberId) {
		List<PlaylistnowDto> pd = playlistnowDao.getMyPlaylistShuffle(memberId);
		return pd;
	}
	/**
	* 재생목록 삭제
	* @author 여수한
	*/
	@Override
	public void deleteMyPlaylist(int playlistCd) {
		playlistnowDao.deleteMyPlaylist(playlistCd);
	}
	/**
	* 재생목록에 노래 전체 추가
	* @author 여수한
	 * @param playlist_cd 
	*/
	@Override
	public void insertMyPlaylist(int playlistCd, List<Integer> songId) {
		for(int i=0; i<songId.size(); i++) {
			playlistnowDao.insertMyPlaylist(playlistCd,songId.get(i));
		}
	}
	/**
	* 재생목록에 여러 노래 추가
	* @author 여수한
	 * @param playlist_cd 
	*/
	@Override
	public void insertMyPlaylistSongs(int playlistCd, List<Integer> songsId) {
		for(int i=0; i<songsId.size(); i++) {
			playlistnowDao.insertMyPlaylistSong(playlistCd,songsId.get(i));	
		}
	}
	/**
	* 재생목록에 노래 삭제
	* @author 여수한
	*/
	@Override
	public void deleteMyPlaylistSongs(int playlistCd, List<Integer> songsId) {
		for(int i=0; i<songsId.size(); i++) {
			playlistnowDao.deleteMyPlaylistSong(playlistCd,songsId.get(i));	
		}
	}
}
