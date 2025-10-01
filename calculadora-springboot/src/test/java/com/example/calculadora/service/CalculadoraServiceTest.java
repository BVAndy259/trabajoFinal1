package com.example.calculadora.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraServiceTest {

    private CalculadoraService calculadoraService;

    @BeforeEach
    public void setUp() {
        calculadoraService = new CalculadoraService();
    }

    @Test
    public void testSumar() {
        assertEquals(8.0, calculadoraService.sumar(5, 3));
        assertEquals(0.0, calculadoraService.sumar(-5, 5));
        assertEquals(-8.0, calculadoraService.sumar(-5, -3));
    }

    @Test
    public void testRestar() {
        assertEquals(2.0, calculadoraService.restar(5, 3));
        assertEquals(-10.0, calculadoraService.restar(-5, 5));
        assertEquals(-2.0, calculadoraService.restar(-5, -3));
    }

    @Test
    public void testMultiplicar() {
        assertEquals(15.0, calculadoraService.multiplicar(5, 3));
        assertEquals(-25.0, calculadoraService.multiplicar(-5, 5));
        assertEquals(15.0, calculadoraService.multiplicar(-5, -3));
    }

    @Test
    public void testDividir() {
        assertEquals(2.0, calculadoraService.dividir(6, 3));
        assertEquals(-1.0, calculadoraService.dividir(-5, 5));
        assertEquals(2.5, calculadoraService.dividir(5, 2));
    }

    @Test
    public void testDividirPorCero() {
        assertThrows(ArithmeticException.class, () -> {
            calculadoraService.dividir(5, 0);
        });
    }
}
