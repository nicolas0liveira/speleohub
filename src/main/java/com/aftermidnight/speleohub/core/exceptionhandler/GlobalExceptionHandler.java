package com.aftermidnight.speleohub.core.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.aftermidnight.speleohub.exception.UsuarioNaoEncontradoException;
import com.fasterxml.jackson.databind.JsonMappingException.Reference;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	public static final String MSG_ERRO_GENERICA_USUARIO_FINAL
		= "Ocorreu um erro interno inesperado no sistema. Tente novamente e se "
				+ "o problema persistir, entre em contato com o administrador do sistema.";
	
	@Autowired
	private MessageSource messageSource;

    @ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleUncaught(Exception e, WebRequest request) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		ProblemType problemType = ProblemType.ERRO_DE_SISTEMA;
		String userMessage = MSG_ERRO_GENERICA_USUARIO_FINAL;

		log.error(userMessage, e);
		
		Problem problem = createProblem(status, problemType, e.getLocalizedMessage(), userMessage, e);

		return handleExceptionInternal(e, problem, new HttpHeaders(), status, request);
	}

	@ExceptionHandler(UsuarioNaoEncontradoException.class)
    Problem handleUsuarioNaoInformadoException(UsuarioNaoEncontradoException e) {
        HttpStatus status = HttpStatus.NOT_FOUND;
		ProblemType problemType = ProblemType.RECURSO_NAO_ENCONTRADO;
        String userMessage = "Usuário não encontrado";

        Problem problem = createProblem(status, problemType, e.getLocalizedMessage(), userMessage, e);
        return problem;
 
    }

    private Problem createProblem(HttpStatus status, ProblemType problemType, String detail, String userMessage, Exception e) {
		return Problem.builder()
			.timestamp(OffsetDateTime.now())
			.status(status)
			.problemType(problemType)
			.detail(detail)
            .userMessage(userMessage)
            .exception(e)
            .build();
	}

	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		
		if (body == null) {
			body = Problem.builder()
				.timestamp(OffsetDateTime.now())
				.title(status.getReasonPhrase())
				.status(status)
				.userMessage(MSG_ERRO_GENERICA_USUARIO_FINAL)
				.build();
		} else if (body instanceof String) {
			body = Problem.builder()
				.timestamp(OffsetDateTime.now())
				.title((String) body)
				.status(status)
				.userMessage(MSG_ERRO_GENERICA_USUARIO_FINAL)
				.build();
		}
		
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}

    private String joinPath(List<Reference> references) {
		return references.stream()
			.map(ref -> ref.getFieldName())
			.collect(Collectors.joining("."));
	}
}