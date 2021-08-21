package com.digitalinnovationone.citiesapi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_cities")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class City implements Serializable {
	
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name="state")
	private State state;
	
	@Column(name="ibge", nullable = false)
	private String ibge;
	
	
}
