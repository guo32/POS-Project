package cs.skuniv.POS.service;

import java.time.LocalDate;

import cs.skuniv.POS.ProductRequest;
import cs.skuniv.POS.dao.ProductDao;
import cs.skuniv.POS.dto.Product;

// 제품 입고 서비스
public class ProductRegisterService {
	
	private ProductDao productDao;
	
	public ProductRegisterService(ProductDao productDao) {
		this.productDao = productDao;
	}

	public String regist(ProductRequest pReq) throws Exception {
		Product product = productDao.selectByCode(pReq.getCode());
		
		if(product != null) {
			// 수량 및 입고일 업데이트
			int stock = product.getStock() + pReq.getStock();
			Product updateProduct = new Product(pReq.getCode(), pReq.getName(),
					stock, pReq.getPrice(), LocalDate.now());
			productDao.update(updateProduct);
			return updateProduct.getCode();
		} else {
			Product newProduct = new Product(pReq.getCode(), pReq.getName(),
					pReq.getStock(), pReq.getPrice(), LocalDate.now());
			productDao.insert(newProduct);
			return newProduct.getCode();
		}
	}

}
