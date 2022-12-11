package cs.skuniv.POS.service;

import cs.skuniv.POS.RegisterRequest;
import cs.skuniv.POS.dao.StaffDao;
import cs.skuniv.POS.dto.Staff;

public class StaffRegisterService {

	private StaffDao staffDao;
	
	public StaffRegisterService(StaffDao staffDao) {
		this.staffDao = staffDao;
	}
	
	public String regist(RegisterRequest req) throws Exception {
		Staff staff = staffDao.selectById(req.getId());
		if(staff != null) {
			throw new Exception("DuplicateStaffException");
		}
		Staff newStaff = new Staff(req.getId(), req.getPassword(), req.getName(), req.getRole());
		
		staffDao.insert(newStaff);
		return newStaff.getId();
	}
	
}
