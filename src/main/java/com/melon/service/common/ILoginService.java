package com.melon.service.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.melon.dto.common.LoginDto;

public interface ILoginService {
	public String join(LoginDto m, RedirectAttributes rttr, HttpSession session);
	public String login(LoginDto m, HttpSession session, RedirectAttributes rttr, HttpServletResponse response);
	public void logout(LoginDto m, HttpSession sessoin, RedirectAttributes rttr, HttpServletResponse response);
	public int check(LoginDto m);

}
