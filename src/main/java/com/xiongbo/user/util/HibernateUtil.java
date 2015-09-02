package com.xiongbo.user.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private final static SessionFactory Factory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		Configuration cfg = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties())
				.buildServiceRegistry();
		SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);
		return factory;
	}

	public static SessionFactory getSessionFactory() {
		return Factory;
	}

	public static Session openSession() {
		return Factory.openSession();
	}

	public static void closeSession(Session session) {

		if (session != null) {
			session.close();
		}
	}
}
