package com.melon.service.song;

import java.util.List;

import com.melon.dto.playlistnow.PlaylistnowDto;
import com.melon.dto.song.BeforeChartDto;
import com.melon.dto.song.NowChartDto;
import com.melon.dto.song.SongDto;
import com.melon.dto.song.SongLike;

public interface ISongService {
	/**
	* 최신노래 조회
	* @author 여수한
	*/
	public List<SongDto> getRecentSong();
	/**
	* 최신노래 조회(버튼별)
	* @author 여수한
	*/
	public List<SongDto> getOriginRecentSong(String origin);
	/**
	* 인기차트 조회
	* @author 여수한
	*/
	public List<SongDto> getPopularSong();
	/**
	* 노래 아이디 조회
	* @author 여수한
	 * @return 
	*/
	public int getSongId(String songName);
	/**
	* 노래 조회수 증가
	* @author 여수한
	 * @return 
	*/
	public void updatePlayCount(int songId);
	/**
	* 노래들은 시간 조회수 증가
	* @author 여수한
	 * @return 
	*/
	public void insertTimeViews(int songId);
	/**
	* 현재 차트 가져오기
	* @author 여수한
	 * @return 
	*/
	public List<BeforeChartDto> getNowChart();
	/**
	* 시간별 조회수 정보 가져오기
	* @author 여수한
	 * @return 
	*/
	public List<NowChartDto> getTimeViews();
	/**
	* 현재 차트 정보를 이전 차트에 넣기
	* @author 여수한
	 * @return 
	*/
	public void insertBeforeChart(List<BeforeChartDto> bcd);
	/**
	* 시간별 차트 정보를 현재 차트에 넣기
	* @author 여수한
	 * @return 
	*/
	public void insertNowChart(List<NowChartDto> ncd);
	/**
	* 이전 차트 삭제
	* @author 여수한
	 * @return 
	*/
	public void deleteBeforeChart();
	/**
	* 현재 차트 삭제
	* @author 여수한
	 * @return 
	*/
	public void deleteNowChart();
	/**
	* 현재 차트 순위 변동
	* @author 여수한
	 * @return 
	*/
	public List<String> getRankChange();
	/**
	* Dto데이터 타입으로 리스트 형태의 노래 아이디 조회
	* @author 여수한
	 * @return 
	*/
	public List<Integer> getSongIds(List<PlaylistnowDto> pd);
	/**
	* SongName타입의 List타입 데이터로 리스트 형태의 노래 아이디 조회
	* @author 여수한
	 * @return 
	*/
	public List<Integer> getSongsId(List<String> songName);
	/**
	* 여러 노래 조회수 증가
	* @author 여수한
	 * @return 
	*/
	public void updatePlayCounts(List<Integer> songsId);
	/**
	* 노래들은 시간 조회수 증가
	* @author 여수한
	 * @return 
	*/
	public void insertTimeViewss(List<Integer> songsId);

	/**
	 * 노래 좋아요 증가
	 * @author 임휘재
	 * @return
	 */
	void getSongLikeAdd(int songId);

	/**
	 * 노래 좋아요 감소
	 * @author 임휘재
	 * @return
	 */
	void getSongLikeDel(int songId);

	/**
	 * 노래 좋아요 조회
	 * @author 임휘재
	 * @return
	 */
	SongLike getSongLikeSelect(int songId);

	/**
	 * 노래 좋아요를 좋아요 테이블에 저장
	 * @author 임휘재
	 * @return
	 */
	void SongLikeToUserLike(int songId, String memberId);
}
