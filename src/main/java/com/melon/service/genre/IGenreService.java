package com.melon.service.genre;

import java.util.List;

import org.springframework.web.bind.annotation.ResponseBody;

import com.melon.dto.album.AlbumDto;
import com.melon.dto.genre.GenreDto;
import com.melon.dto.song.SongDto;

public interface IGenreService {

	/**
	* 장르홈 조회
	* @author 여수한
	*/
	List<GenreDto> getMyGenre();
	/**
	* 장르 즐겨찾기 추가
	* @author 여수한
	*/
	void insertGenreLike(int genreCategory);
	/**
	* 장르 즐겨찾기 추가
	* @author 여수한
	*/
	void deleteGenreLike(int genreCategory);
	/**
	* 장르별 앨범 조회
	* @author 여수한
	*/
	List<AlbumDto> getByGenreAlbum(String choiceGenre);
	/**
	* 장르별 앨범 + 년도별 조회
	* @author 여수한
	 * @param genreName 
	*/
	List<AlbumDto> getByGenreByEraAlbum(String choiceEra, String genreName);
	/**
	* 장르별 노래 조회
	* @author 여수한
	*/
	List<SongDto> getByGenreSong(String choiceGenre);
	/**
	* 장르별 노래 + 년도별 조회
	* @author 여수한
	 * @param genreName 
	*/
	List<SongDto> getByGenreByEraSong(String choiceEra, String genreName);

}
