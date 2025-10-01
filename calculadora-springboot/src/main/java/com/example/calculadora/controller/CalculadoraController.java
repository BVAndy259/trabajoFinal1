package com.example.calculadora.controller;

import com.example.calculadora.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculadora")
public class CalculadoraController {

    @Autowired
    private CalculadoraService calculadoraService;

    @GetMapping("/sumar")
    public ResponseEntity<Double> sumar(@RequestParam double a, @RequestParam double b) {
        return ResponseEntity.ok(calculadoraService.sumar(a, b));
    }

    @GetMapping("/restar")
    public ResponseEntity<Double> restar(@RequestParam double a, @RequestParam double b) {
        return ResponseEntity.ok(calculadoraService.restar(a, b));
    }

    @GetMapping("/multiplicar")
    public ResponseEntity<Double> multiplicar(@RequestParam double a, @RequestParam double b) {
        return ResponseEntity.ok(calculadoraService.multiplicar(a, b));
    }

    @GetMapping("/dividir")
    public ResponseEntity<?> dividir(@RequestParam double a, @RequestParam double b) {
        try {
            return ResponseEntity.ok(calculadoraService.dividir(a, b));
        } catch (ArithmeticException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
