package cs.skuniv.POS.service;

import java.time.LocalDate;

import cs.skuniv.POS.IncomeRequest;
import cs.skuniv.POS.dao.IncomeDao;
import cs.skuniv.POS.dao.ProductDao;
import cs.skuniv.POS.dto.Income;
import cs.skuniv.POS.dto.Product;

/*
 * [ 제품 판매 서비스 ]
 * 판매 정보를 데이터베이스에 저장하고
 * 판매된 제품의 수량을 업데이트함
 */
public class ProductSellService {
	
	private ProductDao productDao;
	private IncomeDao incomeDao;
	
	public ProductSellService(ProductDao productDao, IncomeDao incomeDao) {
		this.productDao = productDao;
		this.incomeDao = incomeDao;
	}
	
	public String sell(IncomeRequest iReq) throws Exception {
		Product product = productDao.selectByCode(iReq.getCode());
		
		// 존재하는 상품일 경우
		if(product != null) {
			int stock = product.getStock() - iReq.getStock();
			// 수량이 0 미만일 때
			if(stock < 0)
				throw new Exception("MinusStockException");
			// 수량 업데이트
			Product updateProduct = new Product(product.getCode(), product.getName(),
					stock, product.getPrice(), product.getDate());
			productDao.update(updateProduct);
			
			// 판매 기록
			Income newIncome = new Income(iReq.getCode(), iReq.getStock(), product.getPrice(), LocalDate.now());
			incomeDao.insert(newIncome);
			
			return updateProduct.getCode();
		} else {
			throw new Exception("NotExistCodeException");
		}
	}

}
