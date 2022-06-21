package org.ciberfarma.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tb_reserva")
@Setter
@Getter
@Data

public class reserva {
	@Id
	@Column(name="id_carrera")
	private int idcarrera;
	@Column(name ="codigo")
	private String codigo;
	@Column(name ="nombre")
	private String nombre;
	@Column(name ="apellido")
	private String apellido;
	@Column(name ="fchregistro")
	private String fchregistro;
	
	
}
