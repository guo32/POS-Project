package cs.skuniv.POS.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cs.skuniv.POS.IncomeRequest;
import cs.skuniv.POS.ProductRequest;
import cs.skuniv.POS.dao.ProductDao;
import cs.skuniv.POS.dto.Product;
import cs.skuniv.POS.service.ProductRegisterService;
import cs.skuniv.POS.service.ProductSellService;
import cs.skuniv.POS.service.StatsService;

@Controller
public class systemController {
	
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ProductRegisterService productRegisterService;
	@Autowired
	private ProductSellService productSellService;
	@Autowired
	private StatsService statsService;

	// 시스템 시작 페이지
	@GetMapping(value="/system")
	public String system() {
		return "system";
	}
	
	// 입고 -------------------------------------
	@GetMapping(value="/stock-product")
	public String stockGet() {
		return "stock-product";
	}
	
	@PostMapping(value="/stock-product")
	public String stockPost(Model model) {
		try {
			model.addAttribute("productRequest", new ProductRequest());
			return "stock-product";
		} catch (Exception ex) {
			return "system";
		}
	}
	
	@PostMapping(value="/stock-completion")
	public String stockCompletion(ProductRequest proReq) {
		try {
			productRegisterService.regist(proReq);
			return "stock-completion";
		} catch (Exception ex) {
			return "stock-fail";
		}
	}
	
	// 판매 -------------------------------------
	@GetMapping(value="/sell-product")
	public String sellGet(Model model) {
		List<Product> productList = productDao.selectAll();
		model.addAttribute("products", productList);
		
		return "sell-product";
	}
	
	@PostMapping(value="/sell-product")
	public String sellPost(Model model) {
		List<Product> productList = productDao.selectAll();
		model.addAttribute("products", productList);
		try {
			model.addAttribute("incomeRequest", new IncomeRequest());
			return "sell-product";
		} catch (Exception ex) {
			return "system";
		}
	}
	
	@PostMapping(value="/sell-completion")
	public String sellCompletion(IncomeRequest incReq, Model model) {
		List<Product> productList = productDao.selectAll();
		model.addAttribute("products", productList);
		try {
			productSellService.sell(incReq);
			return "sell-completion";
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return "sell-fail";
		}
	}
	
	// 재고 -------------------------------------
	@GetMapping(value="/show-product")
	public String list(Model model) {
		List<Product> productList = productDao.selectAll();
		model.addAttribute("products", productList);
		
		return "show-product";
	}
	
	// 통계 -------------------------------------
	@GetMapping(value="/show-stats")
	public String stats(Model model) {
		Map<String, Integer> numberOfSales = statsService.numberOfSales();
		model.addAttribute("numberOfSales", numberOfSales);
		
		Map<LocalDate, Integer> salesData = statsService.daySales();
		model.addAttribute("sales", salesData);
		
		ArrayList<Product> maxList = statsService.maxNumberOfSales();
		model.addAttribute("maxList", maxList);
		
		int[] monthSales = statsService.monthSales();
		model.addAttribute("monthSales", monthSales);
		
		return "show-stats";
	}
		
}
