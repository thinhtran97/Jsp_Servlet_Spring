package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping(value = "/login")

	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username != null && password != null) {
			if (username.equalsIgnoreCase("admin") & password.equals("admin")) {

				return new ModelAndView("confirmation", "username", username);

			} else {
				return new ModelAndView("login", "error", "Username or password is invalid");
			}
		}

		return new ModelAndView("login", "error", "Please enter username and password");
	}

}
