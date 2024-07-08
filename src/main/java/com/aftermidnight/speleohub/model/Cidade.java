package com.aftermidnight.speleohub.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Cidade {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Nome é obrigatório")
	@Column(nullable = false)
	private String nome;
	
	@NotNull(message = "Estado é obrigatório")
	@ManyToOne
	@JoinColumn(nullable = false, name = "estado_id")
	private Estado estado;


	public boolean temEstado() {
		return estado != null;
	}

}