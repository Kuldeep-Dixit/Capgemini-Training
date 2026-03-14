package com.abes.dao;

import java.util.List;

import com.abes.entity.Customer;
import com.abes.entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class OrderDaoImpl implements OrderDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("abes");

	@Override
	public boolean addOrder(Order order, int custId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//storing Foreign key in employee table
		Customer cust = em.find(Customer.class, custId);
		System.out.println(cust);
		
		order.setCustomer(cust);
		System.out.println(order);
		
		em.merge(order);
		tx.commit();
		em.close();
		return true;
	}

	@Override
	public Order getOrder(int orderId) {
		EntityManager em = emf.createEntityManager();
		Order order = em.find(Order.class, orderId);
		em.close();
		return order;
	}

	@Override
	public List<Order> getOrder(String custName) {
		EntityManager em=emf.createEntityManager();
		String jpql="from Order o inner join fetch o.customer c where c.customerName=?1";
		TypedQuery<Order> cq=em.createQuery(jpql,Order.class);
		cq.setParameter(1, custName);
		List<Order> lst=cq.getResultList();
		em.close();
		return lst;
	}

}
