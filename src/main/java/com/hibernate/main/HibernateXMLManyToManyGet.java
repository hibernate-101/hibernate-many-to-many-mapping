package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.model.Cart;
import com.hibernate.model.Item;
import com.hibernate.util.HibernateUtil;

public class HibernateXMLManyToManyGet {
	public static void main(String[] args) {
		// For Cart id 7 get all item Inforamtion
		//and also for item id get cart information.

				SessionFactory sessionFactory = null;
				Session session = null;
				Transaction tx = null;

				// Get Session
				sessionFactory = HibernateUtil.getSessionFactory();
				session = sessionFactory.getCurrentSession();
				System.out.println("Session created");
				// start transaction
				tx = session.beginTransaction();
				Cart cart = (Cart) session.get(Cart.class, 7L);
				System.out.println(cart);
				System.out.println(cart.getItems());
				
				Item item=(Item)session.get(Item.class,8L);
				System.out.println(item);
				System.out.println(item.getCart());
				

				tx.commit();

				// session.close();//becauee of contextual thread session gets closed
				// due to tx.commit().

				sessionFactory.close();
	}

}
