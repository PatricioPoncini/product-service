package com.services.ms.product.product_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestControllerAdvice
@RequestMapping("/api/docs")
public class ApiDocsController {

    @GetMapping(value = "/api-docs.yaml", produces = "text/yaml")
    public ResponseEntity<String> getApiDocs() throws IOException {
        String yaml = Files.readString(
                Paths.get("openapi/openapi.yml")
        );
        return ResponseEntity.ok(yaml);
    }
}