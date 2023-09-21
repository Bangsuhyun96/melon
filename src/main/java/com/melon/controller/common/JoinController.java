package com.melon.controller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.melon.dto.common.LoginDto;
import com.melon.service.common.ILoginService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/join")
public class JoinController {
	
	@Autowired
    ILoginService ILoginService;
	
    @GetMapping
    private String join(){
        return "/common/join";
    }
    
    @PostMapping
    private String join(LoginDto m, RedirectAttributes rttr, HttpSession session) {
    	return ILoginService.join(m, rttr, session);
    }
    
    @GetMapping("/check")
    private @ResponseBody int check(LoginDto m) {
    	int result = ILoginService.check(m);
    	return result;
    }
}
