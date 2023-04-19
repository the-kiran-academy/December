package com.jbk.service;

import com.jbk.entity.Supplier;

public interface SupplierService {
	
	public boolean saveSupplier(Supplier supplier);
	public Supplier getSupplierById(int supplierId);


}
