package cs.skuniv.POS.dao;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import cs.skuniv.POS.dto.Income;

public class IncomeDao {

	private JdbcTemplate jdbcTemplate;
	
	public IncomeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// order는 auto_increment 이므로 제외
	public void insert(final Income income) {
		jdbcTemplate.update("insert into income(code, stock, price, date)" + " values(?,?,?,?)",
			income.getCode(), income.getStock(), income.getPrice(), LocalDate.now());	
	}
	
	public List<Income> selectAll() {
		List<Income> results = jdbcTemplate.query("select * from income", (ResultSet rs, int rowNum)->{
			Income income = new Income(	rs.getString("code"),
					rs.getInt("stock"),	rs.getInt("price"),
					LocalDate.parse(rs.getString("date"), DateTimeFormatter.ISO_DATE));
			return income;
		});
		return results;
	}
	
}