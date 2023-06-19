package one_to_one_uni_car_engine.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_one_uni_car_engine.dto.CarDto;
import one_to_one_uni_car_engine.dto.EngineDto;

public class CarDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashutosh");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	Scanner sc = new Scanner(System.in);

	public void addCar() {
		EngineDto engine = new EngineDto();
		System.out.println("ENTER THE ENGINE NAME");
		engine.setEname(sc.next());
		System.out.println("ENTER THE ENGINE TYPE");
		engine.setEtype(sc.next());

		CarDto car = new CarDto();
		System.err.println("ENTER THE CAR BRAND");
		car.setBrand(sc.next());
		System.err.println("ENTER THE CAR COST");
		car.setCost(sc.nextDouble());
		car.setEngineDto(engine);

		entityTransaction.begin();
		entityManager.persist(car.getEngineDto());
		entityManager.persist(car);
		entityTransaction.commit();

	}

	public void removeCar() {
		System.out.println("ENTER THE CAR ID");
		int id = sc.nextInt();
		CarDto car = entityManager.find(CarDto.class, id);
		if (car != null) {

			entityTransaction.begin();
			entityManager.remove(car);
			entityTransaction.commit();
		}
	}

	public void getCar() {

		System.out.println("ENTER THE ID ");
		int id = sc.nextInt();
		CarDto car = entityManager.find(CarDto.class, id);
		if (car != null) {
			System.err.println(car);

		}

	}

	public void getAllCars() {
		Query query = entityManager.createQuery("select c from CarDto c");
		List list = query.getResultList();
		System.out.println(list);

	}

	public void UpdateCar() {
		System.err.println("ENTER THE ID TO UPDATE");
		int id = sc.nextInt();
		CarDto car = entityManager.find(CarDto.class, id);
		if (car != null) {
			System.out.println("1.BRAND 2.COST");
			switch (sc.nextInt()) {
			case 1:
				System.out.println("ENTER THE NEW BRAND NAME");
				car.setBrand(sc.next());
				entityTransaction.begin();
				entityManager.merge(car);
				entityTransaction.commit();
				break;
			case 2:
				System.out.println("ENTER THE NEW COST");
				car.setCost(sc.nextDouble());
				entityTransaction.begin();
				entityManager.merge(car);
				entityTransaction.commit();
				break;
			default:
				break;
			}

		} else {
			System.err.println("ID NOT FOUND");
		}
	}
}