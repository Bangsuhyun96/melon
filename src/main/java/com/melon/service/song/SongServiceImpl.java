package com.melon.service.song;

import java.util.ArrayList;
import java.util.List;

import com.melon.dto.song.SongLike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melon.dao.song.ISongDao;
import com.melon.dto.playlistnow.PlaylistnowDto;
import com.melon.dto.song.BeforeChartDto;
import com.melon.dto.song.NowChartDto;
import com.melon.dto.song.SongDto;
import com.melon.dto.song.SongLike;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class SongServiceImpl implements ISongService {

	private final ISongDao songDao;

	@Autowired
	public SongServiceImpl(ISongDao songDao) {
		this.songDao = songDao;
	}

	/**
	 * 최신노래 조회
	 * 
	 * @author 여수한
	 */
	@Override
	public List<SongDto> getRecentSong() {
		List<SongDto> rsd = songDao.selectRecentSong();
		return rsd;
	}

	/**
	 * 최신노래 조회(버튼별)
	 * 
	 * @author 여수한
	 */
	@Override
	public List<SongDto> getOriginRecentSong(String origin) {
		if (origin.equals("해외")) {
			origin = "foreign";
		} else if (origin.equals("국내")) {
			origin = "domestic";
		}
		List<SongDto> rsd = songDao.selectOriginRecenSong(origin);
		return rsd;
	}

	/**
	 * 인기차트 조회
	 * 
	 * @author 여수한
	 */
	@Override
	public List<SongDto> getPopularSong() {
		List<SongDto> sd = songDao.selectPopularSong();
		return sd;
	}

	/**
	 * 노래 아이디 조회
	 * 
	 * @author 여수한
	 */
	@Override
	public int getSongId(String songName) {
		int songId = songDao.selectSongId(songName);
		return songId;
	}

	/**
	 * 노래 조회수 증가
	 * 
	 * @author 여수한
	 * @return
	 */
	@Override
	public void updatePlayCount(int songId) {
		songDao.updatePlayCount(songId);
	}

	/**
	 * 시간당 조회수 정보 넣기
	 * 
	 * @author 여수한
	 * @return
	 */
	@Override
	public void insertTimeViews(int songId) {
		songDao.insertTimeViews(songId);
	}

	/**
	 * 현재 차트 가져오기
	 * 
	 * @author 여수한
	 * @return
	 */
	@Override
	public List<BeforeChartDto> getNowChart() {
		List<BeforeChartDto> bcd = songDao.selectNowChart();
		return bcd;
	}

	/**
	 * 시간별 조회수 정보 가져오기
	 * 
	 * @author 여수한
	 * @return
	 */
	@Override
	public List<NowChartDto> getTimeViews() {
		List<NowChartDto> ncd = songDao.selectTimeViews();
		return ncd;
	}

	/**
	 * 현재 차트 정보를 이전 차트에 넣기
	 * 
	 * @author 여수한
	 * @return
	 */
	@Override
	public void insertBeforeChart(List<BeforeChartDto> bcd) {
		for (int i = 0; i < bcd.size(); i++) {
			songDao.insertBeforeChart(bcd.get(i));
		}
	}

	/**
	 * 시간별 차트 정보를 현재 차트에 넣기
	 * 
	 * @author 여수한
	 * @return
	 */
	@Override
	public void insertNowChart(List<NowChartDto> ncd) {
		for (int i = 0; i < ncd.size(); i++) {
			songDao.insertNowChart(ncd.get(i));
		}
	}

	/**
	 * 이전 차트 삭제
	 * 
	 * @author 여수한
	 * @return
	 */
	@Override
	public void deleteBeforeChart() {
		songDao.deleteBeforeChart();
	}

	/**
	 * 현재 차트 삭제
	 * 
	 * @author 여수한
	 * @return
	 */
	@Override
	public void deleteNowChart() {
		songDao.deleteNowChart();
	}
	/**
	* 현재 차트 순위 변동
	* @author 여수한
	 * @return 
	*/
	@Override
	public List<String> getRankChange() {
		List<String> rankChange = songDao.selectRankChange();
		return rankChange;
	}
	/**
	* 리스트 형태의 노래 아이디 조회
	* @author 여수한
	 * @return 
	*/
	@Override
	public List<Integer> getSongIds(List<PlaylistnowDto> pd) {
		List<Integer> SongId = new ArrayList<>();
		for(int i=0; i<pd.size(); i++) {
			List<Integer> result = songDao.selectSongIds(pd.get(i).getSongName());
			SongId.addAll(result);
		}
		return SongId;
	}
	/**
	* SongName타입의 List타입 데이터로 리스트 형태의 노래 아이디 조회
	* @author 여수한
	 * @return 
	*/
	@Override
	public List<Integer> getSongsId(List<String> songName) {
		List<Integer> songsId = new ArrayList<>();
		for(int i=0; i<songName.size(); i++) {
			List<Integer> result = songDao.selectSongIds(songName.get(i));
			songsId.addAll(result);
		}	
		return songsId;
	}
	/**
	* 여러 노래 조회수 증가
	* @author 여수한
	 * @return 
	*/
	@Override
	public void updatePlayCounts(List<Integer> songsId) {
		for(int i=0; i<songsId.size(); i++) {
			songDao.updatePlayCount(songsId.get(i));
		}	
	}
	/**
	* 노래들은 시간 조회수 증가
	* @author 여수한
	 * @return 
	*/
	@Override
	public void insertTimeViewss(List<Integer> songsId) {
		for(int i=0; i<songsId.size(); i++) {
			songDao.insertTimeViews(songsId.get(i));
		}	
	}
	/**
	 * 노래 좋아요 증가
	 * @author 임휘재
	 * @return
	 */
	@Override
	public void getSongLikeAdd(int songId) {
		log.info("serviceSongId : {}", songId);
		songDao.songLikeAdd(songId);
	}

	/**
	 * 노래 좋아요 감소
	 * @author 임휘재
	 * @return
	 */
	@Override
	public void getSongLikeDel(int songId) {
		log.info("serviceSongIdDel : {}", songId);
		songDao.songLikeDel(songId);
	}

	/**
	 * 노래 좋아요 조회
	 * @author 임휘재
	 * @return
	 */
	@Override
	public SongLike getSongLikeSelect(int songId) {
		return songDao.songLikeSelect(songId);
	}

	/**
	 * 노래 좋아요를 좋아요 테이블에 저장
	 * @author 임휘재
	 * @return
	 */
	@Override
	public void SongLikeToUserLike(int songId, String memberId) {
		songDao.songLikeToUserLike(songId, memberId);
	}
}
