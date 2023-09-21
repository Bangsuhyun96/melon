package com.melon.service.album;

import java.util.List;

import org.springframework.stereotype.Service;

import com.melon.dao.album.IAlbumDao;
import com.melon.dto.album.AlbumDetails;
import com.melon.dto.album.AlbumDto;
import com.melon.dto.comment.CommentDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
@RequiredArgsConstructor
public class AlbumServiceImpl implements IAlbumService {

	private final IAlbumDao albumDao;
	/**
	* 최신앨범 조회
	* @author 여수한
	*/
	@Override
	public List<AlbumDto> getRecentAlbum() {
		return albumDao.selectRecentAlbum();
	}
	/**
	* 최신앨범 조회(버튼별)
	* @author 여수한
	*/
	@Override
	public List<AlbumDto> getOriginRecentAlbum(String origin) {
		if(origin.equals("해외")) {
			log.info(origin);
			origin="foreign";
			log.info(origin);
		} else if(origin.equals("국내")) {
			log.info(origin);
			origin="domestic";
			log.info(origin);
		} else if(origin.equals("전체")) {
			log.info(origin);
			origin="all";
			log.info(origin);
		}
		List<AlbumDto> ad = albumDao.selectOriginRecentAlbum(origin);
		return ad;
	}
//	휘재
	/**
	    * 앨범 정보
	    *
	    * @author 임휘재
	    */
	   @Override
	   public AlbumDetails getAlbumDetails(int albumId) {
	      return albumDao.selectAlbumDetails(albumId);
	   }

	   /**
	    * 앨범 수록곡 조회
	    *
	    * @author 임휘재
	    */
	   @Override
	   public List<AlbumDetails> getAlbumSongList(int albumId) {
	      return albumDao.selectAlbumSongList(albumId);
	   }

	   /**
	    * 앨범 상세 조회
	    *
	    * @author 임휘재
	    */
	   @Override
	   public AlbumDetails getAlbumDetail(int albumId) {
	      return albumDao.selectAlbumDetail(albumId);
	   }

	   /**
	    * 앨범 댓글 작성
	    *
	    * @author 임휘재
	    */
	   @Override
	   public void saveComment(CommentDto commentDto, int albumId, String memberId) {
	      albumDao.saveComment(albumId, commentDto, memberId);
	   }

	   /**
	    * 앨범 댓글 조회
	    *
	    * @author 임휘재
	    */
	   @Override
	   public List<CommentDto> getAlbumCommentList(int albumId) {
	      List<CommentDto> dto =  albumDao.selectMyComment(albumId);
	      dto.sort((c1, c2) -> c2.getCommentDate().compareTo(c1.getCommentDate()));
	      return dto;
	   }

	   /**
	    * 앨범 댓글 삭제
	    *
	    * @author 임휘재
	    */
	   @Override
	   public void deleteComment(int commentId, int albumId) {
	      albumDao.deleteComment(albumId, commentId);
	   }

	   /**
	    * 앨범 좋아요 증가
	    *
	    * @author 임휘재
	    */
	   @Override
	   public void albumLikeUpdate(int albumId) {
	      albumDao.albumLikeUpdate(albumId);
	   }

	   /**
	    * 앨범 좋아요 삭제
	    *
	    * @author 임휘재
	    */
	   @Override
	   public void albumLikeDelete(int albumId) {
	      albumDao.albumLikeDelete(albumId);
	   }

	   /**
	    * 앨범 좋아요 조회
	    *
	    * @author 임휘재
	    */
	   @Override
	   public AlbumDetails selectAlbumLike(int albumId) {
	      return albumDao.selectAlbumLike(albumId);
	   }

	   /**
	    * 앨범의 좋아요를 좋아요 테이블에 저장
	    *
	    * @author 임휘재
	    */
	   @Override
	   public void albumLikeToUserLike(int albumId, String memberId) {
	      try {
	         albumDao.AlbumLikeToUserLike(albumId, memberId);
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	   }

}
