package com.melon.service.genre;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melon.dao.genre.IGenreDao;
import com.melon.dto.album.AlbumDto;
import com.melon.dto.genre.GenreDto;
import com.melon.dto.song.SongDto;

@Service
public class GenreServiceImpl implements IGenreService {

	public final IGenreDao genreDao;

	@Autowired
	public GenreServiceImpl(IGenreDao genreDao) {
		this.genreDao = genreDao;
	}

	/**
	 * 장르홈 조회
	 * 
	 * @author 여수한
	 */
	@Override
	public List<GenreDto> getMyGenre() {
		List<GenreDto> gd = genreDao.selectMyGenre();
		return gd;
	}

	/**
	 * 장르 즐겨찾기 추가
	 * 
	 * @author 여수한
	 */
	@Override
	public void insertGenreLike(int genreCategory) {
		genreDao.insertGenreLike(genreCategory);
	}

	/**
	 * 장르 즐겨찾기 추가
	 * 
	 * @author 여수한
	 */
	@Override
	public void deleteGenreLike(int genreCategory) {
		genreDao.deleteGenreLike(genreCategory);
	}

	/**
	 * 장르별 앨범 조회
	 * 
	 * @author 여수한
	 */
	@Override
	public List<AlbumDto> getByGenreAlbum(String choiceGenre) {
		int genreId = 0;
		if (choiceGenre.equals("발라드")) {
			genreId = 0;
		} else if (choiceGenre.equals("댄스")) {
			genreId = 1;
		} else if (choiceGenre.equals("국내힙합")) {
			genreId = 2;
		} else if (choiceGenre.equals("인디")) {
			genreId = 3;
		} else if (choiceGenre.equals("국내 R&B")) {
			genreId = 4;
		} else if (choiceGenre.equals("OST")) {
			genreId = 5;
		} else if (choiceGenre.equals("해외")) {
			genreId = 6;
		}
		List<AlbumDto> ad = genreDao.selectByGenreAlbum(genreId);
		return ad;
	}

	/**
	 * 장르별 앨범 + 년도별 조회
	 * 
	 * @author 여수한
	 */
	@Override
	public List<AlbumDto> getByGenreByEraAlbum(String choiceEra, String genreName) {
		// 년도
		int era = 0;
		if (choiceEra.equals("전체")) {

		} else if (choiceEra.equals("20's")) {
			era = 2020;
		} else if (choiceEra.equals("10's")) {
			era = 2010;
		} else if (choiceEra.equals("00's")) {
			era = 2000;
		} else if (choiceEra.equals("90's")) {
			era = 1990;
		} else if (choiceEra.equals("80's")) {
			era = 1980;
		}
		// 장르
		int genreId = 0;
		if (genreName.equals("발라드")) {
			genreId = 0;
		} else if (genreName.equals("댄스")) {
			genreId = 1;
		} else if (genreName.equals("국내힙합")) {
			genreId = 2;
		} else if (genreName.equals("인디")) {
			genreId = 3;
		} else if (genreName.equals("국내 R&B")) {
			genreId = 4;
		} else if (genreName.equals("OST")) {
			genreId = 5;
		} else if (genreName.equals("해외")) {
			genreId = 6;
		}
		List<AlbumDto> ad = genreDao.selectByGenreByEraAlbum(era, genreId);
		return ad;
	}

	/**
	 * 장르별 노래 조회
	 * 
	 * @author 여수한
	 */
	@Override
	public List<SongDto> getByGenreSong(String choiceGenre) {
		int genreId = 0;
		if (choiceGenre.equals("발라드")) {
			genreId = 0;
		} else if (choiceGenre.equals("댄스")) {
			genreId = 1;
		} else if (choiceGenre.equals("국내힙합")) {
			genreId = 2;
		} else if (choiceGenre.equals("인디")) {
			genreId = 3;
		} else if (choiceGenre.equals("국내 R&B")) {
			genreId = 4;
		} else if (choiceGenre.equals("OST")) {
			genreId = 5;
		} else if (choiceGenre.equals("해외")) {
			genreId = 6;
		}
		List<SongDto> rsd = genreDao.selectByGenreSong(genreId);
		return rsd;
	}

	/**
	 * 장르별 노래 + 년도별 조회
	 * 
	 * @author 여수한
	 */
	@Override
	public List<SongDto> getByGenreByEraSong(String choiceEra, String genreName) {
		// 년도
		int era = 0;
		if (choiceEra.equals("전체")) {

		} else if (choiceEra.equals("20's")) {
			era = 2020;
		} else if (choiceEra.equals("10's")) {
			era = 2010;
		} else if (choiceEra.equals("00's")) {
			era = 2000;
		} else if (choiceEra.equals("90's")) {
			era = 1990;
		} else if (choiceEra.equals("80's")) {
			era = 1980;
		}
		// 장르
		int genreId = 0;
		if (genreName.equals("발라드")) {
			genreId = 0;
		} else if (genreName.equals("댄스")) {
			genreId = 1;
		} else if (genreName.equals("국내힙합")) {
			genreId = 2;
		} else if (genreName.equals("인디")) {
			genreId = 3;
		} else if (genreName.equals("국내 R&B")) {
			genreId = 4;
		} else if (genreName.equals("OST")) {
			genreId = 5;
		} else if (genreName.equals("해외")) {
			genreId = 6;
		}
		List<SongDto> rsd = genreDao.selectByGenreByEraSong(era, genreId);
		return rsd;
	}
}
