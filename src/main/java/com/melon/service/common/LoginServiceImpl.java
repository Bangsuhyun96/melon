package com.melon.service.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.melon.dto.common.LoginDto;
import com.melon.dao.common.ILoginDao;

@Service
@RequiredArgsConstructor
@Log4j2
public class LoginServiceImpl implements ILoginService {

	private final ILoginDao ILoginDao;

	@Override
	public String login(LoginDto m, HttpSession session, RedirectAttributes rttr, HttpServletResponse response) {
		LoginDto loginDto = ILoginDao.login(m);
		if(loginDto != null) {

			session.setAttribute("user", loginDto);
			session.setMaxInactiveInterval(1800);

			Cookie cookie = new Cookie("usercookie", loginDto.getId());
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);

			rttr.addFlashAttribute("msg", "로그인 성공");
			return "redirect:/";
		}else {
			rttr.addFlashAttribute("msg", "로그인 실패");
			return "redirect:/login/melon";
		}
	}

	@Override
	public void logout(LoginDto m, HttpSession session, RedirectAttributes rttr, HttpServletResponse response) {

		session.invalidate();

		Cookie cookie = new Cookie("usercookie", null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);

		rttr.addFlashAttribute("msgTitle","Success !");
		rttr.addFlashAttribute("msg", "로그아웃 성공");
	}

	@Override
	public String join(LoginDto m, RedirectAttributes rttr, HttpSession session) {

		// 아이디 중복 검사
		int idCheckResult = check(m);
		if (idCheckResult > 0) {
			rttr.addFlashAttribute("msg", "중복된 아이디입니다.");
			return "redirect:/join";
		}

		// 빈 필드 검사
		if(
		        m.getId().isEmpty() ||
		        m.getPassword().isEmpty() ||
		        m.getEmail().isEmpty() ||
		        m.getName().isEmpty() ||
		        m.getBirthday().isEmpty() ||
		        m.getTel().isEmpty())
		{
			rttr.addFlashAttribute("msg","빈 칸을 입력해주세요.");
			return "redirect:/join";
		}

		ILoginDao.insertUser(m);
		ILoginDao.playList(m);
		rttr.addFlashAttribute("msg", "회원가입성공");
		session.setAttribute("user", m);
		session.setMaxInactiveInterval(1800);
		return "redirect:/";
	}

	public int check(LoginDto m) {
		int result = ILoginDao.check(m);
		return result;
	}
}
