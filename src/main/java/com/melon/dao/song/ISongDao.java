package com.melon.dao.song;

import java.util.List;

import com.melon.dto.song.SongLike;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.melon.dto.playlistnow.PlaylistnowDto;
import com.melon.dto.song.BeforeChartDto;
import com.melon.dto.song.NowChartDto;
import com.melon.dto.song.SongDto;
import com.melon.dto.song.SongLike;

@Mapper
public interface ISongDao {
	/**
	* 최신노래 조회
	* @author 여수한
	*/
	public List<SongDto> selectRecentSong();
	/**
	* 최신노래 조회(버튼별)
	* @author 여수한
	*/
	public List<SongDto> selectOriginRecenSong(String origin);
	/**
	* 내 재생목록 조회
	* @author 여수한
	*/
	public List<PlaylistnowDto> selectMyPlaylist(@Param("memberId")String memberId);
	/**
	* 인기차트 조회
	* @author 여수한
	*/
	public List<SongDto> selectPopularSong();
	/**
	* 노래 아이디 조회
	* @author 여수한
	*/
	public int selectSongId(@Param("songName")String songName);
	/**
	* 노래 조회수 증가
	* @author 여수한
	 * @return 
	*/
	public void updatePlayCount(int songId);
	/**
	* 시간당 조회수 정보 넣기
	* @author 여수한
	 * @return 
	*/
	public void insertTimeViews(int songId);
	/**
	* 현재 차트 가져오기
	* @author 여수한
	 * @return 
	*/
	public List<BeforeChartDto> selectNowChart();
	/**
	* 시간별 조회수 정보 가져오기
	* @author 여수한
	 * @return 
	*/
	public List<NowChartDto> selectTimeViews();
	/**
	* 현재 차트 정보를 이전 차트에 넣기
	* @author 여수한
	 * @return 
	*/
	public void insertBeforeChart(@Param("bcd")BeforeChartDto bcd);
	/**
	* 시간별 차트 정보를 현재 차트에 넣기
	* @author 여수한
	 * @return 
	*/
	public void insertNowChart(@Param("ncd")NowChartDto ncd);
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
	public List<String> selectRankChange();
	/**
	* 리스트 형태의 노래 아이디 조회
	* @author 여수한
	 * @return 
	*/
	public List<Integer> selectSongIds(String SongName);
	/**
	 * 노래 좋아요 증가
	 * @author 임휘재
	 * @return
	 */
	void songLikeAdd(@Param("songId") int songId);

	/**
	 * 노래 좋아요 감소
	 * @author 임휘재
	 * @return
	 */
	void songLikeDel(@Param("songId") int songId);

	/**
	 * 노래 좋아요 조회
	 * @author 임휘재
	 * @return
	 */
	SongLike songLikeSelect(@Param("songId") int songId);

	/**
	 * 노래 좋아요를 좋아요 테이블에 저장
	 * @author 임휘재
	 * @return
	 */
	void songLikeToUserLike(@Param("songId") int songId, @Param("memberId") String memberId);
}
