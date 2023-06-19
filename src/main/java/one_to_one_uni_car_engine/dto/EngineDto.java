package one_to_one_uni_car_engine.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Generated;

@Entity
public class EngineDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ename;
	private String etype;

	public EngineDto() {

	}

	

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEtype() {
		return etype;
	}

	public void setEtype(String etype) {
		this.etype = etype;
	}

	@Override
	public String toString() {
		return "EngineDto [id=" + id + ", ename=" + ename + ", etype=" + etype + "]";
	}
	

}
