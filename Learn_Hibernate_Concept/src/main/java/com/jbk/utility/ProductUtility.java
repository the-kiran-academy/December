package com.jbk.utility;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.jbk.entity.Product;

public class ProductUtility {
	public static Product prepareProductData(Scanner scanner, boolean val) {
		String productId=null;
		if (val) {
			System.out.println("Enter Id");
			productId = scanner.next();
		} else {
			 productId = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new java.util.Date());

		}

		System.out.println("Enter Product Name");
		String productName = scanner.next();

		System.out.println("Enter Supplier Id");
		int supplierId = scanner.nextInt();

		System.out.println("Enter Category Id");
		int categoryId = scanner.nextInt();

		System.out.println("Enter QTY");
		int productQty = scanner.nextInt();

		System.out.println("Enter Price");
		double productPrice = scanner.nextDouble();

		Product product = new Product(productId, productName, supplierId, categoryId, productQty, productPrice);
		return product;

	}

	public static String getProductId(Scanner scanner) {
		System.out.println("Enter Id");
		String productId = scanner.next();
		return productId;
	}

}
