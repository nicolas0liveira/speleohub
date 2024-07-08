package com.aftermidnight.speleohub.model;


import java.util.Arrays;
import java.util.List;

public enum StatusPedidoIngresso {

	CRIADO("Criado"),
	ANALISE("Em Análise", CRIADO),
	DEFERIDO("Deferido", ANALISE,CRIADO),
	INDEFERIDO("Indeferido", ANALISE,CRIADO);
	
	private String descricao;
	private List<StatusPedidoIngresso> statusAnteriores;
	
	StatusPedidoIngresso(String descricao, StatusPedidoIngresso... statusAnteriores) {
		this.descricao = descricao;
		this.statusAnteriores = Arrays.asList(statusAnteriores);
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public boolean naoPodeAlterarPara(StatusPedidoIngresso novoStatus) {
		return !novoStatus.statusAnteriores.contains(this);
	}
	
}