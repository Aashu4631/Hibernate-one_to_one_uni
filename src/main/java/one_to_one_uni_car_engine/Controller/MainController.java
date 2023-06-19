package one_to_one_uni_car_engine.Controller;

import java.util.Scanner;
import java.util.zip.CRC32;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one_to_one_uni_car_engine.dao.CarDao;
import one_to_one_uni_car_engine.dao.EngineDao;



public class MainController
{
public static void main(String[] args) {
	 EngineDao ed=new EngineDao();
	 CarDao car =new CarDao();
	 Scanner scanner=new Scanner(System.in);
	for(;;)
	{
		System.err.println("1.ENGINE 2.CAR")	;
		switch (scanner.nextInt()) {
		case 1:
			System.out.println("1.ADD-ENGINE 2.REMOVE-ENGINE 3.UPDATE-ENGINE 4.GET-ENGINE 5.GET ALL ENGINE");
			switch (scanner.nextInt()) {
			case 1:
				ed.addengine();
				break;
			case 2:
				ed.removeEngine();
				break;
			case 3:
				ed.updateEngine();
				break;
			case 4:
				ed.getEngine();
				break;
			case 5:
				ed.getAllEngine();
				break;
			default:
				break;
			}
			break;
		case 2:
			System.out.println("1.ADD-CAR 2.REMOVE-CAR 3.UPDATE-CAR 4.GET-CAR 5.GET ALL CARS");
			switch (scanner.nextInt()) {
			case 1:
				car.addCar();
				break;
			case 2:
				car.removeCar();
				break;
			case 3:
				car.UpdateCar();
				break;
			case 4:
				car.getCar();
				break;
			case 5:
				car.getAllCars();
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}
		
	}
}
}
