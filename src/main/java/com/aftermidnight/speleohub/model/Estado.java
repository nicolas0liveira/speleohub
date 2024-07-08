package com.aftermidnight.speleohub.model;

import com.aftermidnight.speleohub.core.validation.Groups;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Entity
public class Estado {

	@NotNull(groups = Groups.EstadoId.class)
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Nome é obrigatório")
	@Column(nullable = false)
	private String nome;

	@NotBlank(message = "Sigla é obrigatório")
	@Column(nullable = false)
	private String sigla;
	
}