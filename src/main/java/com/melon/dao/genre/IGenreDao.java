package com.melon.dao.genre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.melon.dto.album.AlbumDto;
import com.melon.dto.genre.GenreDto;
import com.melon.dto.song.SongDto;

@Mapper
public interface IGenreDao {
	/**
	 * 장르홈 조회
	 * @author 여수한
	 */
	List<GenreDto> selectMyGenre();
	/**
	* 장르 즐겨찾기 추가
	* @author 여수한
	*/
	void insertGenreLike(@Param("genreCategory")int genreCategory);
	/**
	* 장르 즐겨찾기 추가
	* @author 여수한
	*/
	void deleteGenreLike(@Param("genreCategory")int genreCategory);
	/**
	* 장르별 앨범 조회
	* @author 여수한
	*/
	List<AlbumDto> selectByGenreAlbum(@Param("genreId") int genreId);
	/**
	* 장르별 앨범 + 년도별 조회
	* @author 여수한
	*/
	List<AlbumDto> selectByGenreByEraAlbum(@Param("era") int era, @Param("genreId") int genreId);
	/**
	* 장르별 노래 조회
	* @author 여수한
	*/
	List<SongDto> selectByGenreSong(@Param("genreId") int genreId);
	/**
	 * 장르별 노래 + 년도별 조회
	 * @author 여수한
	 */
	List<SongDto> selectByGenreByEraSong(@Param("era") int era, @Param("genreId") int genreId);
	
}
