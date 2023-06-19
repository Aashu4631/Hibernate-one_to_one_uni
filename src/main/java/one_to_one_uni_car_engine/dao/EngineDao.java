package one_to_one_uni_car_engine.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

import one_to_one_uni_car_engine.dto.CarDto;
import one_to_one_uni_car_engine.dto.EngineDto;

public class EngineDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashutosh");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	Scanner sc = new Scanner(System.in);
	CarDto car = new CarDto();

	public void addengine() {
		EngineDto engine = new EngineDto();
		System.out.println("ENTER THE ENGINE NAME");
		engine.setEname(sc.next());
		System.out.println("ENTER THE ENGINE TYPE");
		engine.setEtype(sc.next());

		entityTransaction.begin();
		entityManager.persist(engine);
		entityTransaction.commit();

	}

	public void removeEngine() {
		System.out.println("ENTER THE ENGINE ID TO REMOVE");
		int id = sc.nextInt();
		EngineDto engine = entityManager.find(EngineDto.class, id);
		if (engine != null) {

			entityTransaction.begin();
			entityManager.remove(car);
			entityManager.remove(engine);
			entityTransaction.commit();

		} else {
			System.err.println("ID NOT FOUND");
		}

	}

	public void updateEngine() {
		System.out.println("ENTER THE ID OF ENGINE TO UPDATE");
		int id = sc.nextInt();
		EngineDto engine = entityManager.find(EngineDto.class, id);
		if (engine != null) {
			System.out.println("1 ENGINE-NAME 2.ENGINE-TYPE");
			switch (sc.nextInt()) {
			case 1:
				System.out.println("ENTER THE NEW ENGINE NAME");
				engine.setEname(sc.next());
				entityTransaction.begin();
				entityManager.merge(engine);
				entityTransaction.commit();
				break;
			case 2:
				System.out.println("ENTER THE NEW ENGINE TYPE");
				engine.setEtype(sc.next());
				entityTransaction.begin();
				entityManager.merge(engine);
				entityTransaction.commit();
			default:
				break;
			}

		} else {
			System.err.println("ID NOT FOUND");
		}

	}

	public void getEngine() {
		System.out.println("ENTER THE ENGINE ID TO FETCH");
		int id = sc.nextInt();
		EngineDto engine = entityManager.find(EngineDto.class, id);
		if (engine != null) {
			System.out.println(engine);

		}

	}

	public void getAllEngine() {
		Query query = entityManager.createQuery("select e from EngineDto e");
		List list = query.getResultList();
		System.err.println(list);

	}

}
