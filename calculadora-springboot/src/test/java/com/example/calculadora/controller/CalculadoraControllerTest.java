package com.example.calculadora.controller;

import com.example.calculadora.service.CalculadoraService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CalculadoraController.class)
public class CalculadoraControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculadoraService calculadoraService;

    @Test
    public void testSumar() throws Exception {
        when(calculadoraService.sumar(5.0, 3.0)).thenReturn(8.0);

        mockMvc.perform(get("/api/calculadora/sumar")
                .param("a", "5.0")
                .param("b", "3.0"))
                .andExpect(status().isOk())
                .andExpect(content().string("8.0"));
    }

    @Test
    public void testRestar() throws Exception {
        when(calculadoraService.restar(10.0, 4.0)).thenReturn(6.0);

        mockMvc.perform(get("/api/calculadora/restar")
                .param("a", "10.0")
                .param("b", "4.0"))
                .andExpect(status().isOk())
                .andExpect(content().string("6.0"));
    }

    @Test
    public void testMultiplicar() throws Exception {
        when(calculadoraService.multiplicar(6.0, 7.0)).thenReturn(42.0);

        mockMvc.perform(get("/api/calculadora/multiplicar")
                .param("a", "6.0")
                .param("b", "7.0"))
                .andExpect(status().isOk())
                .andExpect(content().string("42.0"));
    }

    @Test
    public void testDividir() throws Exception {
        when(calculadoraService.dividir(15.0, 3.0)).thenReturn(5.0);

        mockMvc.perform(get("/api/calculadora/dividir")
                .param("a", "15.0")
                .param("b", "3.0"))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }

    @Test
    public void testDividirPorCero() throws Exception {
        when(calculadoraService.dividir(5.0, 0.0))
                .thenThrow(new ArithmeticException("No se puede dividir por cero"));

        mockMvc.perform(get("/api/calculadora/dividir")
                .param("a", "5.0")
                .param("b", "0.0"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("No se puede dividir por cero"));
    }
}
