package com.aftermidnight.speleohub.core.exceptionhandler;

import java.net.URI;

import lombok.Getter;

/**
 Padronizando o formato de problemas no corpo de respostas com a RFC 7807
 */

@Getter
public enum ProblemType {

	ERRO_DE_SISTEMA("/erro-de-sistema", "Erro de sistema","ambiente"),
	PARAMETRO_INVALIDO("/parametro-invalido", "Parâmetro inválido","dados"),
	MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreensível","dados"),
	RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado","dados"),
	ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso","dados"),
	ERRO_NEGOCIO("/erro-negocio", "Violação de regra de negócio","negócio"),
	DADOS_INVALIDOS("/dados-invalidos", "Dados inválidos","dados");
	
	private String title;
	private URI type;
	private String category;
	
	ProblemType(String path, String title, String category) {
		this.type = URI.create("https://xxxxxxx.com.br" + path);
		this.title = title;
		this.category = category;
		
	}
	
}