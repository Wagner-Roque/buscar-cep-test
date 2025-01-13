package com.roque.teste.act.api_busca_cep.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        // Logar a exceção para análise posterior (opcional)
        logger.error("Erro interno do servidor: ", ex);

        // Mensagem amigável para o usuário
        String mensagemErro = "Ocorreu um erro inesperado. Por favor, tente novamente mais tarde.";
        logger.error(mensagemErro);
        // Retornar uma resposta com status 500 e a mensagem de erro
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(mensagemErro);
    }
}
