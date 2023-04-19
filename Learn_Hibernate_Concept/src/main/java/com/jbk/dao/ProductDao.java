package com.jbk.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import com.jbk.config.HibernateConfig;
import com.jbk.entity.Product;
import com.mysql.cj.x.protobuf.MysqlxCrud.Projection;

public class ProductDao {

	SessionFactory sf = HibernateConfig.getSessionFactory();

	public ProductDao() {
	}

	public String saveProduct(Product product) {
		String msg = null;
		Session session = null;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(product);
			transaction.commit();
			msg = "Data saved";
		} catch (PersistenceException e) {

			msg = "Product Not Saved Due To Duplicate Entry With Id = " + product.getProductId() + " ANd Name = "
					+ product.getProductName();
		}

		catch (Exception e) {
			e.printStackTrace();
			msg = "Something Wrong While Data Saving !!";
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;

	}

	public Product getProductById(String productId) {
		Product product = null;
		Session session = null;
		try {
			session = sf.openSession();

			product = session.get(Product.class, productId);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return product;

	}

	public String deleteProductByProductId(String productId) {
		Session session = null;
		String msg = null;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();

			Product product = getProductById(productId);
			if (product != null) {
				session.delete(product);
				transaction.commit();
				msg = "Deleted";
			} else {
				msg = "Product Not Found For Delete With Id =" + productId;
			}

		} catch (Exception e) {
			msg = "Something Wrong While Deleting ";
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;

	}

	public String updateProduct(Product product) {
		Session session = null;
		String msg = null;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(product);
			transaction.commit();
			msg = "updated";
		} catch (Exception e) {
			msg = "not updated";
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public List<Product> getAllProduct() {
		Session session = null;
		List<Product> list = null;
		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Product.class);

			criteria.addOrder(Order.asc("productName")); // order
			criteria.setFirstResult(2);
			criteria.setMaxResults(3); // limit

			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	public List<Product> restrictionEx(Object val) {
		Session session = null;
		List<Product> list = null;
		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Product.class);

			SimpleExpression productPrice = Restrictions.eq("productPrice", 20d);
			SimpleExpression productQty = Restrictions.eq("productQty", 10);

			criteria.add(Restrictions.or(productPrice, productQty));

			// criteria.add(Restrictions.ge("productPrice", val));
			// Product product = (Product) criteria.uniqueResult();
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;

	}

	public double projectionEx() {
		Session session = null;
		double sum = 0;
		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setProjection(Projections.count("productPrice"));

			List list = criteria.list();

			sum = (Long) list.get(0);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return sum;

	}

	public List<Product> queryEx() {
		Session session = null;
		List list = null;
		double price = 10;
		try {
			session = sf.openSession();

			Query query = session.createQuery("FROM Product p WHERE p.productPrice> :xyz");
			query.setParameter("xyz", price);
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;

	}

}
