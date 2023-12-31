package com.melon.controller.artist;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.melon.dto.artist.ArtistDto;
import com.melon.service.artist.IArtistService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/artist")
@RequiredArgsConstructor
@Slf4j
public class ArtistController {

    private final IArtistService artistService;

    /**
     * 가수 정보, 가수 곡 조회, 가수 앨범 조회, 가수 상세정보 조회
     * @author 임휘재
     */
    @GetMapping("/{artistId}")
    public String artistMain(@PathVariable("artistId") int artistId,
                             Model model){
        //가수정보
        ArtistDto artistDto = artistService.getArtistInfo(artistId);
        model.addAttribute("artistInfo", artistDto);
        log.info("artistInfo : {}", artistDto);

        //곡
        List<ArtistDto> artistDtoList = artistService.getArtistSongs(artistId);
        model.addAttribute("artistSongs", artistDtoList);

        //앨범
        List<ArtistDto> artistAlbums = artistService.getArtistAlbums(artistId);
        model.addAttribute("artistAlbums", artistAlbums);
        if (!artistAlbums.isEmpty()) {
            log.info("albumId : {}", artistAlbums.get(0).getAlbumId());
        } else {
            log.info("No albums found for this artist.");
        }

        //활동정보
        try {
            ArtistDto artistActivity = artistService.getArtistActivity(artistId);
            model.addAttribute("artistActivity", artistActivity);
        }catch (Exception e){
            ArtistDto artistAc = artistService.getArtistActivity(artistId);
            if(artistAc.getDebut().isEmpty()) {
                model.addAttribute("emptyMessage", "알 수 없음");
            }
        }

        //가수 - 앨범 중복 제거
        List<ArtistDto> artistAlbumsRemoveDuplication = artistService.ArtistAlbumsRemoveDuplication(artistId);
        model.addAttribute("removeDuplication", artistAlbumsRemoveDuplication);
        log.info("remove : {}", artistAlbumsRemoveDuplication);

        //가수 좋아요 조회
        int artistCnt = artistService.ArtistLikeCnt(artistId);
        model.addAttribute("artistCnt", artistCnt);
        System.out.println(artistCnt);

        return "artist/artist";
    }

    /**
     * ajax 가수 곡 최신순, 인기순, 가나다순 정렬
     * @author 임휘재
     */
    @GetMapping("/detail/song/{artistId}")
    @ResponseBody
    public List<ArtistDto> artistSongSort(@PathVariable("artistId") int artistId,
                                          @RequestParam("sortType") String sortType){
        return artistService.getArtistSongsSort(artistId, sortType);
    }

    /**
     * 가수 좋아요 증가
     * @author 임휘재
     */
    @PostMapping("/{artistId}/like/update")
    public ResponseEntity<Integer> artistLikeCntUpdate(@PathVariable("artistId") int artistId,
                                                       HttpServletResponse res,
                                                       @CookieValue(value = "isLiked", defaultValue = "false") boolean isLiked) {

        Cookie cookie = new Cookie("isLiked", Boolean.toString(isLiked));
        cookie.setMaxAge(3600); // 쿠키 만료 시간(초) 설정
        res.addCookie(cookie);
        try {
            String memberId = "admin";
            artistService.ArtistLikeUpdate(artistId);
            ArtistDto dto = artistService.getArtistLikeCntNow(artistId);
            log.info("ArtistLikeUpdateCnt : {}", dto.getArtistLike());
            int likeCnt = dto.getArtistLike();
            artistService.artistLikeToUserLike(artistId, memberId);
            log.info("가수 좋아요 증가를 user_like 테이블에 저장. memberId: {}", memberId);
            return ResponseEntity.ok(likeCnt);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(-1);
        }
    }

    /**
     * 가수 좋아요 삭제
     * @author 임휘재
     */
    @PostMapping("/{artistId}/like/delete")
    public ResponseEntity<Integer> artistLikeCntDelete(@PathVariable("artistId") int artistId,
                                                       HttpServletResponse res,
                                                       @CookieValue(value = "isLiked", defaultValue = "false") boolean isLiked) {


        Cookie cookie = new Cookie("isLiked", Boolean.toString(isLiked));
        cookie.setMaxAge(3600); // 쿠키 만료 시간(초) 설정
        res.addCookie(cookie);
        try {
            String memberId = "admin";
            artistService.ArtistLikeDelete(artistId);
            ArtistDto dto = artistService.getArtistLikeCntNow(artistId);
            log.info("ArtistLikeDeleteCnt : {}", dto.getArtistLike());
            int likeCnt = dto.getArtistLike();
            artistService.artistLikeToUserLike(artistId, memberId);
            log.info("가수 좋아요 감소를 user_like 테이블에 저장. memberId: {}", memberId);
            return ResponseEntity.ok(likeCnt);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(1);
        }
    }


}
