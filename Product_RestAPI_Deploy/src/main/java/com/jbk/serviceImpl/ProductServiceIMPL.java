package com.jbk.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jbk.dao.ProductDao;
import com.jbk.entity.Category;
import com.jbk.entity.Product;
import com.jbk.entity.Supplier;
import com.jbk.service.ProductService;

@Service
public class ProductServiceIMPL implements ProductService {

	@Autowired
	private ProductDao dao;

	@Override
	public boolean saveProduct(Product product) {
		String productId = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now());
		product.setProductId(productId);
		boolean isAdded = dao.saveProduct(product);
		return isAdded;
	}

	@Override
	public Product getProductById(String productId) {

		return dao.getProductById(productId);
	}

	@Override
	public List<Product> getAllProducts() {

		return dao.getAllProducts();
	}

	@Override
	public boolean deleteProductById(String productId) {
		return dao.deleteProductById(productId);
	}

	@Override
	public boolean updateProduct(Product product) {
		return dao.updateProduct(product);
	}

	@Override
	public List<Product> sortProductsById_ASC() {
		return dao.sortProductsById_ASC();
	}

	@Override
	public List<Product> sortProductsByName_DESC() {

		return dao.sortProductsByName_DESC();
	}

	@Override
	public List<Product> getMaxPriceProducts() {
		return dao.getMaxPriceProducts();
	}

	@Override
	public double getMaxPrice() {
		return dao.getMaxPrice();
	}

	@Override
	public double countSumOfProductPrice() {
		return dao.countSumOfProductPrice();
	}

	@Override
	public int getTotalCountOfProducts() {
		return dao.getTotalCountOfProducts();

	}

	public List<Product> readExcelSheet(String path) {
		Product product = null;
		List<Product> list = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(path);

			Workbook workbook = new XSSFWorkbook(fis);

			Sheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rows = sheet.rowIterator();

			while (rows.hasNext()) {

				Row row = rows.next();
				int rowNum = row.getRowNum();
				if (rowNum == 0) {
					continue;
				}
				product = new Product();
				String productId = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now());
		        Random random = new Random();
		        int randomNumber = random.nextInt(90) + 10;
				productId=productId.concat(String.valueOf(randomNumber));
				product.setProductId(productId);
				Iterator<Cell> cells = row.cellIterator();

				while (cells.hasNext()) {
					Cell cell = cells.next();

					int columnIndex = cell.getColumnIndex();

					switch (columnIndex) {
					case 0: {
						product.setProductName(cell.getStringCellValue());
						break;
					}
					case 1: {
						Supplier supplier = new Supplier();
						supplier.setSupplierId((int) cell.getNumericCellValue());
						product.setSupplier(supplier);
						;
						break;
					}
					case 2: {
						Category category = new Category();
						category.setCategoryId((int) cell.getNumericCellValue());
						product.setCategory(category);
						break;
					}
					case 3: {
						product.setProductQty((int) cell.getNumericCellValue());
						break;
					}

					case 4: {
						product.setProductPrice(cell.getNumericCellValue());
						break;
					}
					}

				}

				
				
				list.add(product);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public String upploadSheet(MultipartFile myFile) {
		String path = "src/main/resources";
		File file = new File(path);
		String msg = null;
		String absolutePath = file.getAbsolutePath();

		System.out.println(absolutePath);

		try {
			byte[] data = myFile.getBytes();
			FileOutputStream fos = new FileOutputStream(
					new File(absolutePath + File.separator + myFile.getOriginalFilename()));
			fos.write(data);

			List<Product> list = readExcelSheet(absolutePath + File.separator + myFile.getOriginalFilename());

			msg = dao.uploadProducts(list);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return msg;
	}

}
