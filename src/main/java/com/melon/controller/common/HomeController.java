package com.melon.controller.common;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.melon.dto.album.AlbumDto;
import com.melon.dto.common.LoginDto;
import com.melon.dto.common.MainAlbumDto;
import com.melon.dto.common.MainSongDto;
import com.melon.dto.playlistnow.PlaylistnowDto;
import com.melon.service.common.IMainService;
import com.melon.service.playlistnow.IPlaylistnowService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class HomeController {


    private final IMainService iMainService;
    private final IPlaylistnowService playlistnowService;

    @GetMapping("/")
    public String Home(Model model, HttpSession session, LoginDto m){

        // 앨범추천
        List<MainAlbumDto> fourAlbum = iMainService.fourAlbum();
        model.addAttribute("fourAlbum", fourAlbum);


        // 추천음악
        List<MainSongDto> recommendSong = iMainService.recommendSong();
        model.addAttribute("recommendSong", recommendSong);


        // 마이뮤직
        List<MainAlbumDto> myMusic = iMainService.myMusic();
        model.addAttribute("myMusic", myMusic);
        System.out.println("마이뮤직");
        System.out.println(myMusic);

        // top100
        List<MainSongDto> topMusic = iMainService.topMusic();
        model.addAttribute("topMusic", topMusic);
        
        LoginDto loginDto = (LoginDto) session.getAttribute("user");
        if(loginDto==null) {
        	return "index";
		} else {
			String memberId = loginDto.getId();
        	List<PlaylistnowDto> pd = playlistnowService.getMyPlaylist(memberId);
			model.addAttribute("pd", pd);
			return "index";
		}
    } 
}