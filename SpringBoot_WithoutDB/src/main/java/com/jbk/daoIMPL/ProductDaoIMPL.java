package com.jbk.daoIMPL;

import java.util.ArrayList;
import java.util.List;

import com.jbk.dao.ProductDao;
import com.jbk.model.Product;

public class ProductDaoIMPL implements ProductDao {

	List<Product> list = new ArrayList();
	
	public ProductDaoIMPL() {
		list.add(new Product("1", "XYZ", 1,1, 10, 10));
		list.add(new Product("2", "abc", 1,1, 10, 12));
		list.add(new Product("3", "pqr", 1,1, 10, 15));
	}

	@Override
	public String saveProduct(Product product) {
		list.add(product);
		return "Product is saved!";
	}

	@Override
	public Product getProductById(String productId) {
		for (Product product : list) {
			if (productId.equals(product.getProductId())) {
				return product;
			}
		}
		return null;
		
}
	@Override
	public List<Product> getProduct() {
		if(!list.isEmpty()) {
			return list;
		}else {
			return null;
		}
	}

}
