package cs.skuniv.POS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cs.skuniv.POS.dao.StaffDao;
import cs.skuniv.POS.dto.Staff;

@Controller
public class ManageController {
	
	@Autowired
	private StaffDao staffDao;
	
	// staff 목록을 출력
	@GetMapping(value="/show-staff")
	public String list(Model model) {
		List<Staff> staffList = staffDao.selectAll();
		model.addAttribute("staffs", staffList);
		return "show-staff";
	}
	
	// 직원관리 페이지
	@GetMapping(value="/manage-staff")
	public String manage() {
		return "manage-staff";
	}

}
