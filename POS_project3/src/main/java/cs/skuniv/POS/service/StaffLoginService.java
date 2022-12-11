package cs.skuniv.POS.service;

import cs.skuniv.POS.dao.StaffDao;
import cs.skuniv.POS.dto.Staff;

public class StaffLoginService {
	
	StaffDao staffDao;
	
	public StaffLoginService(StaffDao staffDao) {
		this.staffDao = staffDao;
	}
	
	public Staff login(String id, String password) {
		Staff staff = staffDao.selectById(id);
		
		if(staff != null) {
			if(staff.getPassword().equals(password)) {
				return staff;
			}
		}		
		
		return null;
	}

}
