package com.jbk.serviceIMPL;

import java.util.ArrayList;
import java.util.List;

import com.jbk.dao.ProductDao;
import com.jbk.daoIMPL.ProductDaoIMPL;
import com.jbk.model.Product;
import com.jbk.service.ProductService;

public class ProductServiceIMPL implements ProductService {

	ProductDao dao = new ProductDaoIMPL();
  
	@Override
	public String saveProduct(Product product) {
    String msg = dao.saveProduct(product);
		return msg;
	}

	@Override
	public Product getProductById(String productId) {
    Product product = dao.getProductById(productId);
		return product;
	}

	@Override
	public List<Product> getProduct() {
		List<Product> list = new ArrayList<Product>();
		list = dao.getProduct();
		return list;
	}

}
