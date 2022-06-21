package org.ciberfarma.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tb_carrera")
@Setter
@Getter
@Data

public class Carrera {
	
	@Id
	@Column(name = "id_carrera")
	private int idcarrera;
	@Column(name = "descricion")
	private String des_carrera;
	
	public Carrera(int idcarrera, String des_carrera) {
		super();
		this.idcarrera = idcarrera;
		this.des_carrera = des_carrera;
	}

	public Carrera() {
		super();
	}
	
	

}
