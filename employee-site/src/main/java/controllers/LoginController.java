package controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@RequestMapping("/loginPage")
	String loginPage(HttpSession session) {
		System.out.println("status=" + session.getAttribute("status"));
		return "login";
	}

	@RequestMapping("/invalidate")
	String invalidate(HttpSession session) {
		session.invalidate();
		// System.out.println("status="+session.getAttribute("status"));
		return "login";
	}

	@RequestMapping("/loginSubmit")
	String loginSubmit(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session) {
		System.out.println(username + " " + password);
		session.setAttribute("status", "yes");
		return "login";
	}
}
