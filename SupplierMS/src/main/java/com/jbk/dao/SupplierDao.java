package com.jbk.dao;

import com.jbk.entity.Supplier;

public interface SupplierDao {

	public boolean saveSupplier(Supplier supplier);
	
	public Supplier getSupplierById(int supplierId);
}
