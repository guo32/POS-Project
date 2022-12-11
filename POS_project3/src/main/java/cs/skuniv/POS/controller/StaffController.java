package cs.skuniv.POS.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import cs.skuniv.POS.RegisterRequest;
import cs.skuniv.POS.dao.StaffDao;
import cs.skuniv.POS.dto.Staff;
import cs.skuniv.POS.service.StaffLoginService;
import cs.skuniv.POS.service.StaffRegisterService;

@Controller
public class StaffController {
	
	@Autowired
	private StaffRegisterService staffRegisterService;
	@Autowired
	private StaffLoginService staffLoginService;
		
	// 로그인 페이지 접근
	@GetMapping(value="/login")
	public String loginGet() {		
		return "login";
	}
	
	// 로그인 처리 및 시스템 접근
	@PostMapping(value="/login-success")
	public String loginPost(Model model, @RequestParam(value="id") String id,
			@RequestParam(value="password") String password, HttpServletRequest request) {
				
		Staff staff = staffLoginService.login(id, password);
		
		if(staff != null) {
			HttpSession session = request.getSession();
			session.setAttribute("staff", staff);
						
			return "login-success";
		}
		return "login";
	}
	
	// 로그아웃
	@GetMapping(value="logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
	
	// 직원등록 페이지 접근
	@RequestMapping("/register")
	public String registerGet() {
		return "register"; 
	}
	
	@PostMapping(value="/register")
	public String registerPost(Model model) {
		try {
			model.addAttribute("registerRequest", new RegisterRequest());
			return "register";
		} catch (Exception ex) {
			return "manage-staff";
		}
	}
	
	@PostMapping(value="/register-completion")
	public String registerCompletion(RegisterRequest regReq) { 
		try {			
			staffRegisterService.regist(regReq);
			return "register-completion";
		} catch (Exception ex) {
			// System.out.println("fail register");
			return "register";
		}
	}
	
}
