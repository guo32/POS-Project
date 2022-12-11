package cs.skuniv.POS.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cs.skuniv.POS.dto.Product;

public class ProductDao {

	private JdbcTemplate jdbcTemplate;
	
	public ProductDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// code 검색
	public Product selectByCode(String code) {
		List<Product> results = jdbcTemplate.query("select * from product where code = ?", new RowMapper<Product>() {
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product(rs.getString("code"), 
						rs.getString("name"), 
						rs.getInt("stock"), 
						rs.getInt("price"),
						LocalDate.parse(rs.getString("date"), DateTimeFormatter.ISO_DATE));
				return product;
			}
		}, code);
		
		return results.isEmpty() ? null : results.get(0);
	}
	
	public void insert(final Product product) {
		jdbcTemplate.update("insert into product(code, name, stock, price, date)" + " values(?,?,?,?,?)",
				product.getCode(), product.getName(), product.getStock(), product.getPrice(), LocalDate.now());
	}
	
	public void update(final Product product) {
		jdbcTemplate.update("update product set name = ?, stock = ?, price = ?, date = ?" + " where code = ?",
				product.getName(), product.getStock(), product.getPrice(), product.getDate(), product.getCode());
	}
	
	public List<Product> selectAll() {
		List<Product> results = jdbcTemplate.query("select * from product", (ResultSet rs, int rowNum)->{
			Product product = new Product(rs.getString("code"), 
					rs.getString("name"), 
					rs.getInt("stock"), 
					rs.getInt("price"),
					LocalDate.parse(rs.getString("date"), DateTimeFormatter.ISO_DATE));
			return product;
		});
		return results;
	}
	
}
