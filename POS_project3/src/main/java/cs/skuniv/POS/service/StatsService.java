package cs.skuniv.POS.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cs.skuniv.POS.dao.IncomeDao;
import cs.skuniv.POS.dao.ProductDao;
import cs.skuniv.POS.dto.Income;
import cs.skuniv.POS.dto.Product;

public class StatsService {
	
	private IncomeDao incomeDao;
	private ProductDao productDao;
	
	public StatsService(IncomeDao incomeDao, ProductDao productDao) {
		this.incomeDao = incomeDao;
		this.productDao = productDao;
	}
	
	// 일자별 매출액
	public Map<LocalDate, Integer> daySales() {		
		Map<LocalDate, Integer> sales = new HashMap<>();		
		List<Income> salesData = incomeDao.selectAll();
		
		// 일자별 매출액 계산
		for(Income income : salesData) {
			int price = income.getPrice() * income.getStock();
			if(sales.containsKey(income.getDate())) {
				int accrue = sales.get(income.getDate()) + price;
				sales.put(income.getDate(), accrue);
			} else {
				sales.put(income.getDate(), price);
			}
		}
		
		return sales;
	}
	
	// 월별 매출액 (올해 데이터만 표시됨)
	public int[] monthSales() {
		int[] sales = new int[12];
		List<Income> salesData = incomeDao.selectAll();
		
		for(Income income : salesData) {
			int price = income.getPrice() * income.getStock();
			int month = income.getDate().getMonthValue();
			sales[month-1] += price;
		}
		return sales;
	}
	
	// 제품별 판매 수
	public Map<String, Integer> numberOfSales() {
		Map<String, Integer> number = new HashMap<>();
		List<Income> salesData = incomeDao.selectAll();
		
		for(Income income : salesData) {
			if(number.containsKey(income.getCode())) {
				int accrue = number.get(income.getCode()) + income.getStock();
				number.put(income.getCode(), accrue);
			} else {
				number.put(income.getCode(), income.getStock());
			}
		}
		
		return number;
	}
	
	// 최다 판매 제품
	public ArrayList<Product> maxNumberOfSales() {
		ArrayList<Product> list = new ArrayList<Product>();
		Map<String, Integer> data = numberOfSales();
		int num = Collections.max(data.values());
		
		for(String code : data.keySet()) {
			if(data.get(code) == num) {
				Product product = productDao.selectByCode(code);
				if(product != null) list.add(product);
			} else continue;
		}
		
		return list;
	}

}
