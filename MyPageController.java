package jp.co.internous.altair.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.altair.model.domain.MstUser;
import jp.co.internous.altair.model.mapper.MstUserMapper;
import jp.co.internous.altair.model.session.LoginSession;

@Controller
@RequestMapping("/altair/mypage")
public class MyPageController {
	
	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	private MstUserMapper userMapper;
	
		@RequestMapping("/")
		public String index(Model m) {
			MstUser user = userMapper.findByUserNameAndPassword(loginSession.getUserName(),loginSession.getPassword());
			m.addAttribute("user", user);
			m.addAttribute("loginSession", loginSession);
			return "my_page";
		}

}
