package com.jbk.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.jbk.entity.Product;
import com.jbk.model.ProductWithSC;


public interface ProductService {
	
	public boolean saveProduct(Product product);
	public Product getProductById(String productId);
	
	public ProductWithSC getProductWithSCByPid(String productId);
	
	public List<Product> getAllProducts();
	public boolean deleteProductById(String productId);
	public boolean updateProduct(Product product);
	
	public List<Product> sortProductsById_ASC();

	public List<Product> sortProductsByName_DESC();

	public List<Product> getMaxPriceProducts();
	
	public double getMaxPrice();

	public double countSumOfProductPrice();

	public int getTotalCountOfProducts();
	
	public String upploadSheet(MultipartFile file);


}
