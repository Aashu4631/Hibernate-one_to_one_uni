package one_to_one_uni_car_engine.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CarDto 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String brand;
private double cost;

@OneToOne
private EngineDto engineDto;

public CarDto() {
	
}

public String getBrand() {
	return brand;
}

public void setBrand(String brand) {
	this.brand = brand;
}

public double getCost() {
	return cost;
}

public void setCost(double cost) {
	this.cost = cost;
}

public EngineDto getEngineDto() {
	return engineDto;
}

public void setEngineDto(EngineDto engineDto) {
	this.engineDto = engineDto;
}

@Override
public String toString() {
	return "CarDto [id=" + id + ", brand=" + brand + ", cost=" + cost + ", engineDto=" + engineDto + "]";
}


}
