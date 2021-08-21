package com.digitalinnovationone.citiesapi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_states")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class State implements Serializable {
	
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="state_name", nullable = false)
	private String stateName;
	
	@Column(name="uf",nullable = false)
	private String uf;
	
	@Column(name="ibge_code", nullable = false, unique = true)
	private int ibgeCode;
	
	@Column(name="country", nullable = false)
	private String country;
	
	@Column(name="ddd", nullable = false)
	private String ddd;
	
	
	
	
	
	
	
}
