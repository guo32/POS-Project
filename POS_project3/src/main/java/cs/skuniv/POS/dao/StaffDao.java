package cs.skuniv.POS.dao;

import java.sql.*;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cs.skuniv.POS.dto.Staff;

public class StaffDao {
	
	// jdbcTemplate 객체 구현
	private JdbcTemplate jdbcTemplate;
		
	public StaffDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 아이디 검색
	public Staff selectById(String id) {
		List<Staff> results = jdbcTemplate.query("select * from staff where id = ?", new RowMapper<Staff>() {
			public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
				Staff staff = new Staff(rs.getString("id"), 
						rs.getString("password"), 
						rs.getString("name"), 
						rs.getString("role"));
				return staff;
			}
		}, id);
		
		// 없는 직원이라면 null 반환, 존재하는 직원이라면 id 값 반환
		return results.isEmpty() ? null : results.get(0);
	}
	
	// 새로운 직원 추가
	public void insert(final Staff staff) {
		jdbcTemplate.update("insert into staff(id, password, name, role)" + " values(?,?,?,?)", 
				staff.getId(), staff.getPassword(), staff.getName(), staff.getRole());
	}
	
	// 직원 정보 수정
	public void update(final Staff staff) {
		jdbcTemplate.update("update staff set name = ?, password = ?" + " where id = ?",
				staff.getName(), staff.getPassword(), staff.getId());
	}
	
	public List<Staff> selectAll() {
		List<Staff> results = jdbcTemplate.query("select * from staff", (ResultSet rs, int rowNum)->{
			Staff staff = new Staff(rs.getString("id"), rs.getString("password"), 
							rs.getString("name"), rs.getString("role"));
			return staff;
		});
		return results;
	}
	
}
