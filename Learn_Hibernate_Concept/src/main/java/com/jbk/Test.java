package com.jbk;

import java.util.List;
import java.util.Scanner;

import com.jbk.entity.Product;
import com.jbk.service.ProductService;
import com.jbk.utility.ProductUtility;

public class Test {

	public static void main(String[] args) {
		ProductService service = new ProductService();
		Scanner sc = new Scanner(System.in);
		char ch;
		int choice;
		do {
			System.out.println("Press 1 for save product");
			System.out.println("Press 2 for delete product");
			System.out.println("Press 3 for get single product");
			System.out.println("Press 4 for update product");

			System.out.println("Press 5 for get all product");

			System.out.println("press 6 For Restriction Ex");
			System.out.println("Press 7 for projection Ex");

			System.out.println("Press 8 for Max Price Product");
			System.out.println("Press 9 for Query Ex");

			choice = sc.nextInt();

			switch (choice) {
			case 1: {
				Product product = ProductUtility.prepareProductData(sc, false);
				String msg = service.saveProduct(product);
				System.out.println(msg);
				break;
			}

			case 2: {

				String productId = ProductUtility.getProductId(sc);
				String msg = service.deleteProductByProductId(productId);
				System.out.println(msg);

				break;
			}

			case 3: {

				String productId = ProductUtility.getProductId(sc);
				Product product = service.getProductById(productId);
				if (product != null) {
					System.out.println(product);
				} else {
					System.out.println("Product Not Found For ID = " + productId);
				}
				break;
			}

			case 4: {
				Product product = ProductUtility.prepareProductData(sc, true);
				String msg = service.updateProduct(product);
				System.out.println(msg);

				break;
			}

			case 5: {
				List<Product> list = service.getAllProduct();
				for (Product product : list) {
					System.out.println(product);
				}
				break;
			}

			case 6: {
				System.out.println("Enter ProductPrice");
				Object val = sc.nextInt();
				List<Product> list = service.restrictionEx(val);

				for (Product product : list) {
					System.out.println(product);
				}
				break;
			}

			case 7: {
				double sum = service.projectionEx();
				System.out.println(sum);
				break;
			}

			case 8: {
				break;
			}

			case 9: {
				List<Product> list = service.queryEx();
				for (Product product : list) {
					System.out.println(product);
				}
				break;
			}

			default:
				System.out.println("Invalid Choice !!");
				break;
			}

			System.out.println(" Do You Want to continue Y/N");
			ch = sc.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');

		System.out.println("App Terminated");

	}

}
