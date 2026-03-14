package com.abes.client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.abes.dao.OrderDao;
import com.abes.dao.OrderDaoImpl;
import com.abes.entity.Order;

public class DaoClient {
    static OrderDao dao = new OrderDaoImpl();
    static Scanner scan = new Scanner(System.in);
        
	public static void main(String[] args) {
		String opt = null;
		do {
			System.out.println("1 --> ADD, 2 --> VIEW BY ORDER ID, 3 --> VIEW BY CUSTOMER NAME");
			int mtype = scan.nextInt();
			processMenu(mtype);
			System.out.println("press y to continue");
			opt=scan.next();
		}while(opt.equalsIgnoreCase("y"));

	}
	
	public static void processMenu(int mtype) {
		switch(mtype) {
		case 1:
			addOrder();
			break;
		case 2:
			viewOrderByOrderID();
			break;
		case 3:
			viewOrdersByCustName();
			break;
		default:
			System.out.println("Invalid option");
		}
	}

	public static void addOrder() {
		System.out.println("Enter the Order Date (format: d-M-yyyy)");
		String odate = scan.next();
		System.out.println("Enter the Amount ");
		double amt = scan.nextDouble();
		System.out.println("Enter the Customer ID ");
		int custId = scan.nextInt();

		Order order = new Order();
		order.setOrderDate(LocalDate.parse(odate, DateTimeFormatter.ofPattern("d-M-yyyy")));
		order.setAmount(amt);
        
		try {
			dao.addOrder(order, custId);
			System.out.println("Employee added successfully.");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	public static void viewOrderByOrderID() {
		System.out.println("Enter the Order ID ");
		int oid = scan.nextInt();
		Order emp = dao.getOrder(oid);
		System.out.println(emp);
		
	}
	
	public static void viewOrdersByCustName() {
		
		System.out.println("Enter the Customer Name ");
		String cname = scan.next();
		List<Order> lst = dao.getOrder(cname);
		lst.forEach(System.out::println);
		
	}
 }