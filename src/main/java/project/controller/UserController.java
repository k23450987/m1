package project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import project.domain.User;
import project.service.UserService;

@Controller
public class UserController {

	@Resource
	private UserService userService;

	/**
	 * 前往管理页面
	 */
	@RequestMapping("toManage.action")
	public String listAll(Model model) {

		return "/manage/index.jsp";
	}

	/**
	 * 进行管理员用户登录操作
	 */
	@RequestMapping("/login.action")
	public String login(String username, String password, Model model,
			HttpSession httpSession) {

		// 将页面传的用户名密码封装
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		map.put("password", password);
		List<User> list = userService.login(map);
		// 判断是否查询到
		if (list.size() != 0) {
			for (User user : list) {
				// 成功!存到session
				httpSession.setAttribute("user", user);
			}
			return "/success.jsp";
		} else {
			// 失败,返回错误信息
			model.addAttribute("message", "用户名密码错误");
			return "/fail.jsp";
		}
	}

	/**
	 * 跳转到登录页面
	 */
	@RequestMapping("/toLogin.action")
	public String toLogin(HttpSession httpSession) {
		if (httpSession.getAttribute("user") != null) {
			return "/success.jsp";
		}
		return "/login.jsp";
	}

	/**
	 * 跳转到注册页面
	 */
	@RequestMapping("/toReg.action")
	public String toReg() {
		return "/reg.jsp";
	}

	/**
	 * 进行注册操作
	 */
	@RequestMapping("/insert.action")
	public String reg(String username, User user, Model model) {
		if (!userService.check(username)) {
			model.addAttribute("message", "注册失败，用户名已存在");
			return "/reg.jsp";
		}
		userService.reg(user);
		model.addAttribute("message", "注册成功");
		return "/login.jsp";
	}

	@ResponseBody
	@RequestMapping("/checkUser.action")
	public String checkUser(String username) {
		if (userService.check(username)) {
			return "true";
		}
		return "false";
	}


	/**
	 * testjson
	 */
	@ResponseBody
	@RequestMapping("jsontest.spring")
	public String jsonTest() {

		String string = "[{\"name1\":\"123\"},{\"name2\":\"你好好\"},{\"name3\":\"你好好好\"}]";
		String string1 = "阿斯达所多";
		return string1;
	}

}
