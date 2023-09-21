package com.melon.dao.album;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.melon.dto.album.AlbumDetails;
import com.melon.dto.album.AlbumDto;
import com.melon.dto.comment.CommentDto;

@Mapper
public interface IAlbumDao {
	/**
	 * 최신앨범 조회
	 * 
	 * @author 여수한
	 */
	public List<AlbumDto> selectRecentAlbum();

	/**
	 * 최신앨범 조회(버튼별)
	 * 
	 * @author 여수한
	 */
	public List<AlbumDto> selectOriginRecentAlbum(@Param("origin") String origin);

	/* 휘재 */
	/**
	 * 앨범 정보
	 * 
	 * @author 임휘재
	 */
	AlbumDetails selectAlbumDetails(@Param("albumId") int albumId);

	/**
	 * 앨범 수록곡
	 * 
	 * @author 임휘재
	 */
	List<AlbumDetails> selectAlbumSongList(@Param("albumId") int albumId);

	/**
	 * 앨범 상세 정보
	 * 
	 * @author 임휘재
	 */
	AlbumDetails selectAlbumDetail(@Param("albumId") int albumId);

	/**
	 * 앨범 댓글 작성
	 *
	 * @author 임휘재
	 */
	void saveComment(@Param("albumId") int albumId, @Param("commentDto") CommentDto commentDto, @Param("memberId") String memberId);

	/**
	 * 앨범 댓글 조회
	 *
	 * @author 임휘재
	 */
	List<CommentDto> selectMyComment(@Param("albumId") int albumId);

	/**
	 * 앨범 댓글 삭제
	 *
	 * @author 임휘재
	 */
	void deleteComment(@Param("albumId") int albumId, @Param("commentId") int commentId);

	/**
	 * 앨범 좋아요 증가
	 *
	 * @author 임휘재
	 */
	void albumLikeUpdate(@Param("albumId") int albumId);

	/**
	 * 앨범 좋아요 삭제
	 *
	 * @author 임휘재
	 */
	void albumLikeDelete(@Param("albumId") int albumId);

	/**
	 * 앨범 좋아요 조회
	 *
	 * @author 임휘재
	 */
	AlbumDetails selectAlbumLike(@Param("albumId") int albumId);

	/**
	 * 앨범의 좋아요를 좋아요 테이블에 저장
	 *
	 * @author 임휘재
	 */
	void AlbumLikeToUserLike(@Param("albumId") int albumId, @Param("memberId") String memberId);
}
