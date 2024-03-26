package com.pgd.app.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormularioController {

    // creating a logger
    Logger logger = LoggerFactory.getLogger(FormularioController.class);

    @Value("${custom.property}")
    private String myPropertyValue;

    //Obtener datos base de formulario y preguntas asociadas
    @GetMapping("/api/formulario")
    public ResponseEntity<String> greetings()
    {
        // Logging various log level messages
        logger.trace("Log level: TRACE");
        logger.info("Log level: INFO");
        logger.debug("Log level: DEBUG");
        logger.error("Log level: ERROR");
        logger.warn("Log level: WARN");

        logger.info("custom property:" + myPropertyValue);

        return ResponseEntity.ok("Request exitoso");
    }

    @GetMapping("/goodBye")
    public ResponseEntity<String> goodBye()
    {
        // Logging various log level messages
        logger.trace("Log level: TRACE");
        logger.info("Log level: INFO");
        logger.debug("Log level: DEBUG");
        logger.error("Log level: ERROR");
        logger.warn("Log level: WARN");

        logger.info("custom property:" + myPropertyValue);

        return ResponseEntity.ok("Request exitoso");
    }
}