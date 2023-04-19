package com.jbk.service;

import java.util.List;

import com.jbk.dao.ProductDao;
import com.jbk.entity.Product;

public class ProductService {
	ProductDao dao = new ProductDao();

	public String saveProduct(Product product) {

		return dao.saveProduct(product);
	}

	public Product getProductById(String productId) {
		Product product = dao.getProductById(productId);

		return product;
	}

	public String deleteProductByProductId(String productId) {
		return dao.deleteProductByProductId(productId);
	}
	
	public String updateProduct(Product product) {
		return dao.updateProduct(product);
	}

	public List<Product> getAllProduct() {
		return dao.getAllProduct();
	}
	
	public List<Product> restrictionEx(Object val) {
	 return	dao.restrictionEx(val);
	}
	
	public double projectionEx() {
		
		return dao.projectionEx();
	}
	
	public List<Product> queryEx() {
		return dao.queryEx();
		
	}

}
