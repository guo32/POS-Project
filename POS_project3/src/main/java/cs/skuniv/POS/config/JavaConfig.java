package cs.skuniv.POS.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cs.skuniv.POS.dao.IncomeDao;
import cs.skuniv.POS.dao.ProductDao;
import cs.skuniv.POS.dao.StaffDao;
import cs.skuniv.POS.service.ProductRegisterService;
import cs.skuniv.POS.service.ProductSellService;
import cs.skuniv.POS.service.StaffLoginService;
import cs.skuniv.POS.service.StaffRegisterService;
import cs.skuniv.POS.service.StatsService;

@Configuration
public class JavaConfig {

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("-");
		ds.setUsername("-");
		ds.setPassword("-");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		ds.setTestWhileIdle(true);
		ds.setMinEvictableIdleTimeMillis(60000 * 3);
		ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
		
		return ds;
	}
	
	@Bean
	public StaffDao staffDao() {
		return new StaffDao(dataSource());
	}
	
	@Bean
	public StaffRegisterService staffRegSvc() {
		return new StaffRegisterService(staffDao());
	}
	
	@Bean
	public StaffLoginService staffLoginSvc() {
		return new StaffLoginService(staffDao());
	}
	
	@Bean
	public ProductDao productDao() {
		return new ProductDao(dataSource());
	}
	
	@Bean
	public ProductRegisterService productRegSvc() {
		return new ProductRegisterService(productDao());
	}
	
	@Bean
	public ProductSellService productSellSvc() {
		return new ProductSellService(productDao(), incomeDao());
	}
	
	@Bean
	public IncomeDao incomeDao() {
		return new IncomeDao(dataSource());
	}
	
	@Bean
	public StatsService statsSvc() {
		return new StatsService(incomeDao(), productDao());
	}
	
}
