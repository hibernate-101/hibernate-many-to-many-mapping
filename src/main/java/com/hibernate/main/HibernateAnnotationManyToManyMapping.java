package com.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.model.CartAnnotation;
import com.hibernate.model.ItemAnnotation;
import com.hibernate.util.HibernateAnnotationUtil;

public class HibernateAnnotationManyToManyMapping {
	public static void main(String[] args) {
		ItemAnnotation item1 = new ItemAnnotation();
		item1.setDescription("samsung"); item1.setPrice(300);
		ItemAnnotation item2 = new ItemAnnotation();
		item2.setDescription("nokia"); item2.setPrice(200);
		CartAnnotation cart = new CartAnnotation();
		cart.setTotal(500);
		Set<ItemAnnotation> items = new HashSet<ItemAnnotation>();
		items.add(item1); items.add(item2);
		cart.setItems(items);
		
		SessionFactory sessionFactory = null;
		try{
		sessionFactory = HibernateAnnotationUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(cart);
		System.out.println("Before committing transaction");
		tx.commit();
		sessionFactory.close();
		
		System.out.println("Cart ID="+cart.getId());
		System.out.println("Item1 ID="+item1.getId());
		System.out.println("Item2 ID="+item2.getId());
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(sessionFactory != null && !sessionFactory.isClosed()) sessionFactory.close();
		}
	}

}
